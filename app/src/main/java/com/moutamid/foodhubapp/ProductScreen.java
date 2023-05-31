package com.moutamid.foodhubapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.moutamid.foodhubapp.adapters.ProductListAdapters;
import com.moutamid.foodhubapp.databinding.ActivityProductScreenBinding;
import com.moutamid.foodhubapp.model.Product;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductScreen extends AppCompatActivity {

    private ActivityProductScreenBinding binding;
    private DBHandler dbHandler;
    private List<Product> productArrayList;
    private ProductListAdapters adapters;
    private SharedPreferencesManager manager;
    private String version = "Free Version";
    private String[] prodName = {"Arachidi","Avocado","Banana","Burro","Caffè","Carne di manzo","Carne di maiale",
    "Cioccolato","Formaggio","Gelato","Latte","Insalata","Noci","Olive","Yogurt", "Zucchine","Mele","Mandorle","Melanzane",
    "Salsa di pomodoro","Salmone","Salsiccia","Spinaci","Tè","Tonno","Uva","Uvetta","Vaniglia","Vino","Mais","Cipolle",
    "Peperoni","Patate","Limoni","Aceto balsamico","Aceto di mele","Anatra","Aceto di riso","Ketchup","Maionese",
    "Pollo"};

    private int[] images = {R.drawable.arachidi,R.drawable.avocado,R.drawable.banana,R.drawable.burro,R.drawable.caffe,R.drawable.carne_di_manzo,R.drawable.carne_di_maiale,
    R.drawable.cioccolato,R.drawable.formaggio,R.drawable.gelato,R.drawable.latte,R.drawable.insalata,R.drawable.noci,R.drawable.olive,
            R.drawable.yogurt,R.drawable.zucchine,R.drawable.mele,R.drawable.mandorle,R.drawable.melanzane,
            R.drawable.salsa_di_pomodoro,R.drawable.salmone,R.drawable.salsiccia,R.drawable.spinaci,R.drawable.te,R.drawable.tonno,
    R.drawable.uva,R.drawable.uvetta,R.drawable.vaniglia,R.drawable.vino,R.drawable.mais,R.drawable.cipolle,
    R.drawable.peperoni,R.drawable.patate,R.drawable.limoni,R.drawable.aceto_balsamico,R.drawable.aceto_di_mele,R.drawable.anatra,R.drawable.aceto_di_riso,
    R.drawable.ketchup,R.drawable.maionese,R.drawable.pollo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbHandler = new DBHandler(ProductScreen.this);
        manager = new SharedPreferencesManager(ProductScreen.this);
        version = manager.retrieveString("billing","Free Version");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });


        AdView mAdView = findViewById(R.id.adView);
        if (version.equals("Free Version")) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }else{
            mAdView.setVisibility(View.GONE);
        }

        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductScreen.this,MainActivity.class));
                finish();
            }
        });

        binding.addNEw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddNewProductDialog();
            }
        });
        getProductList();
    }

    String product = "";
    String exDate = "";
    int pos = 0;
    byte[] imageByte;
    private void showAddNewProductDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ProductScreen.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_new_product_dialog, null);
        dialogBuilder.setView(dialogView);
        TextView expiryTxt = (TextView) dialogView.findViewById(R.id.expiryDate);
        Spinner productName = (Spinner) dialogView.findViewById(R.id.productName);
        ImageView imageView = (ImageView) dialogView.findViewById(R.id.imageView);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,prodName);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        productName.setAdapter(aa);
        productName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                product = prodName[position];
                pos = position;
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(images[pos]);

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),images[pos]);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                imageByte = bos.toByteArray();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button addBtn = (Button) dialogView.findViewById(R.id.update);
        AlertDialog alertDialog = dialogBuilder.create();
        expiryTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(ProductScreen.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        int mon= monthOfYear+1;
                        exDate = dayOfMonth+"/"+mon+"/"+year;
                        expiryTxt.setText(exDate);
                    }
                }, yy, mm, dd);
                datePicker.show();

            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   prodName = productName.getText().toString();
                Product model = new Product(product,exDate,imageByte);
                dbHandler.addProduct(model);
                getProductList();

                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }


    private void getProductList() {
        productArrayList = dbHandler.getAllProducts();
        adapters = new ProductListAdapters(ProductScreen.this,productArrayList);
        binding.recyclerview.setAdapter(adapters);
        adapters.notifyDataSetChanged();
    }
}