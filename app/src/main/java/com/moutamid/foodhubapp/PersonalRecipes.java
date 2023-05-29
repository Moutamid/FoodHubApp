package com.moutamid.foodhubapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.PurchaseInfo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.moutamid.foodhubapp.adapters.ProductListAdapters;
import com.moutamid.foodhubapp.adapters.RecipeListAdapters;
import com.moutamid.foodhubapp.databinding.ActivityPersonalRecipesBinding;
import com.moutamid.foodhubapp.databinding.ActivityRecipeWebScreenBinding;
import com.moutamid.foodhubapp.model.Product;
import com.moutamid.foodhubapp.model.Recipe;
import com.moutamid.foodhubapp.utils.DbBitmapUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.List;

public class PersonalRecipes extends AppCompatActivity implements BillingProcessor.IBillingHandler {

    private ActivityPersonalRecipesBinding binding;
    private DBHandler dbHandler;
    private static final int STORAGE_PERMISSION_CODE = 101;
    private Uri uri;
    private Bitmap image = null;
    ImageView imageView;
    private static final int PICK_IMAGE_REQUEST = 1;
    private RecipeListAdapters adapters;
    List<Recipe> recipeList;
    private SharedPreferencesManager manager;
    BillingProcessor bp;
    public static final String LICENSE_KEY = "";
    public static final String ONE_TIME_PRODUCT = "one.time.com.moutamid.foodhub";
    private String version = "Free Version";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonalRecipesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbHandler = new DBHandler(PersonalRecipes.this);
        manager = new SharedPreferencesManager(PersonalRecipes.this);
        version = manager.retrieveString("billing","Free Version");
        bp = BillingProcessor.newBillingProcessor(this, LICENSE_KEY, this);
        bp.initialize();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        if(!BillingProcessor.isIabServiceAvailable(this)) {
            Toast.makeText(this, "In-app billing service is unavailable, please upgrade Android Market/Play to version >= 3.9.16", Toast.LENGTH_SHORT).show();
        }

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonalRecipes.this,MainActivity.class));
                finish();
            }
        });

        binding.addNEw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (version.equals("Free Version")){
                //    bp.subscribe(PersonalRecipes.this,ONE_TIME_PRODUCT);
                    buyDialog();
                }else {
                    showAddNewProductDialog();
                }
            }
        });

        getRecipesList();
    }

    private void buyDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(PersonalRecipes.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.buy_dialog, null);
        dialogBuilder.setView(dialogView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button addBtn = (Button) dialogView.findViewById(R.id.buy);
        AlertDialog alertDialog = dialogBuilder.create();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.storeString("billing","Paid Version");
                alertDialog.dismiss();
            }
        });
        alertDialog.show();

    }

    String recipe = "";
    String description = "";
    private void showAddNewProductDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(PersonalRecipes.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_new_recipe_dialog, null);
        dialogBuilder.setView(dialogView);
        imageView = (ImageView) dialogView.findViewById(R.id.imageView);
        EditText recipeName = (EditText) dialogView.findViewById(R.id.recipeName);
        EditText desp = (EditText) dialogView.findViewById(R.id.description);
        Button addBtn = (Button) dialogView.findViewById(R.id.update);
        AlertDialog alertDialog = dialogBuilder.create();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe = recipeName.getText().toString();
                description = desp.getText().toString();
                if (!TextUtils.isEmpty(recipe) && !TextUtils.isEmpty(description) && image != null){

                    Recipe model = new Recipe(recipe,description,image);
                    dbHandler.addRecipe(model);
                    getRecipesList();
                }
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private void getRecipesList() {
        recipeList = dbHandler.getAllRecipes();
        adapters = new RecipeListAdapters(PersonalRecipes.this,recipeList);
        binding.recyclerview.setAdapter(adapters);
        adapters.notifyDataSetChanged();
    }


    public void checkPermission()
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(PersonalRecipes.this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(PersonalRecipes.this, new String[] {
                    Manifest.permission.READ_EXTERNAL_STORAGE }, STORAGE_PERMISSION_CODE);
        }
        else {
            openGallery();
            //  Toast.makeText(EditProfileScreen.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
                //Toast.makeText(EditProfileScreen.this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                //  Toast.makeText(EditProfileScreen.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"SELECT IMAGE"),PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            uri = data.getData();
           try {
                image = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                imageView.setImageBitmap(image);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable PurchaseInfo details) {
        manager.storeString("billing","Paid Version");
    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {

        Toast.makeText(PersonalRecipes.this, "onBillingError: code: " + ""+ errorCode , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBillingInitialized() {

    }

    @Override
    protected void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
    }
}