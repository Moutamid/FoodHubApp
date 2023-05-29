package com.moutamid.foodhubapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.PurchaseInfo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.moutamid.foodhubapp.databinding.ActivityMainBinding;
import com.moutamid.foodhubapp.model.User;
import com.moutamid.foodhubapp.utils.Constants;

public class MainActivity extends AppCompatActivity implements BillingProcessor.IBillingHandler{

    private ActivityMainBinding binding;
    private DBHandler dbHandler;
    private SharedPreferencesManager manager;
    private String email;
    private static final int STORAGE_PERMISSION_CODE = 101;
    private String version = "Free Version";
    private InterstitialAd interstitialAd;

    BillingProcessor bp;
    public static final String LICENSE_KEY = "";
    public static final String ONE_TIME_PRODUCT = "one.time.com.moutamid.foodhub";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       // Constants.checkApp(MainActivity.this);
        dbHandler = new DBHandler(MainActivity.this);
        manager = new SharedPreferencesManager(MainActivity.this);
        version = manager.retrieveString("billing","Free Version");
        email = manager.retrieveString("email","");
        bp = BillingProcessor.newBillingProcessor(this, LICENSE_KEY, this);
        bp.initialize();

        checkPermission();
        Constants.checkApp(MainActivity.this);
        interstitialAd = new InterstitialAd (MainActivity.this) ;
        MobileAds.initialize(MainActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        //setting Ad Unit Id to the interstitialAd
        interstitialAd.setAdUnitId ( "ca-app-pub-3940256099942544/1033173712" ) ;

        AdView mAdView = findViewById(R.id.adView);
        if (version.equals("Free Version")) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            loadInterstitialAd();
            showInterstitialAd();
        }else{
            mAdView.setVisibility(View.GONE);
        }
        binding.product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProductScreen.class));
                finish();
            }
        });
        binding.ingredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,IngredientsScreen.class));
                finish();
            }
        });
        binding.recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (version.equals("Free Version")){
                    buyDialog();
                }else {
                    startActivity(new Intent(MainActivity.this,PersonalRecipes.class));
                    finish();
                }
            }
        });

    }



    private void buyDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.buy_dialog, null);
        dialogBuilder.setView(dialogView);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button addBtn = (Button) dialogView.findViewById(R.id.buy);
        AlertDialog alertDialog = dialogBuilder.create();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.storeString("billing","Paid Version");
                //    bp.subscribe(PersonalRecipes.this,ONE_TIME_PRODUCT);
                alertDialog.dismiss();
            }
        });
        alertDialog.show();

    }


    private void showInterstitialAd()
    {
        if (interstitialAd.isLoaded() )
        {
            //showing the ad Interstitial Ad if it is loaded
            interstitialAd.show() ;

            // Showing a simple Toast message to user when an Interstitial ad is shown to the user
     //       Toast.makeText (MainActivity.this, "Interstitial is loaded and showing ad  ", Toast.LENGTH_LONG) .show();
        }
        else
        {
            //Load the Interstitial ad if it is not loaded
            loadInterstitialAd() ;

            // Showing a simple Toast message to user when an ad is not loaded
     //       Toast.makeText ( MainActivity.this, "Interstitial Ad is not Loaded ", Toast.LENGTH_LONG).show() ;
        }
    }

    private void loadInterstitialAd()
    {
        // Creating  a Ad Request
        AdRequest adRequest = new AdRequest.Builder().build() ;

        // load Ad with the Request
        interstitialAd.loadAd(adRequest) ;

        // Showing a simple Toast message to user when an ad is Loading
       // Toast.makeText ( MainActivity.this, "Interstitial Ad is loading ", Toast.LENGTH_LONG).show() ;
    }

    public void checkPermission()
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {
                    Manifest.permission.READ_EXTERNAL_STORAGE }, STORAGE_PERMISSION_CODE);
        }
        else {
            getUserDetails();
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
                getUserDetails();
                //Toast.makeText(EditProfileScreen.this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                //  Toast.makeText(EditProfileScreen.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("Range")
    private void getUserDetails() {
        User user = dbHandler.getUser(email);
        binding.name.setText(user.getName());
        binding.surName.setText(user.getSurname());
        binding.email.setText(user.getEmail());
        binding.paid.setText(version);
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

        Toast.makeText(MainActivity.this, "onBillingError: code: " + ""+ errorCode , Toast.LENGTH_SHORT).show();
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