package com.moutamid.foodhubapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.moutamid.foodhubapp.adapters.ProductListAdapters;
import com.moutamid.foodhubapp.databinding.ActivityProductScreenBinding;
import com.moutamid.foodhubapp.model.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductScreen extends AppCompatActivity {

    private ActivityProductScreenBinding binding;
    private DBHandler dbHandler;
    private List<Product> productArrayList;
    private ProductListAdapters adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbHandler = new DBHandler(ProductScreen.this);

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


    String prodName = "";
    String exDate = "";
    private void showAddNewProductDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ProductScreen.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_new_product_dialog, null);
        dialogBuilder.setView(dialogView);
        TextView expiryTxt = (TextView) dialogView.findViewById(R.id.expiryDate);
        EditText productName = (EditText) dialogView.findViewById(R.id.productName);
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
                prodName = productName.getText().toString();
                if (!TextUtils.isEmpty(prodName) && !TextUtils.isEmpty(exDate)){
                    Product product = new Product(prodName,exDate);
                    dbHandler.addProduct(product);
                    getProductList();
                }
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