package com.moutamid.foodhubapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.moutamid.foodhubapp.adapters.IngredientListAdapters;
import com.moutamid.foodhubapp.adapters.SelectedProductListAdapter;
import com.moutamid.foodhubapp.databinding.ActivityIngredientsScreenBinding;
import com.moutamid.foodhubapp.listener.ItemClickListener;
import com.moutamid.foodhubapp.model.Ingredients;
import com.moutamid.foodhubapp.model.Product;
import com.moutamid.foodhubapp.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class IngredientsScreen extends AppCompatActivity {

    private ActivityIngredientsScreenBinding binding;
    private List<Product> productArrayList;
    private SharedPreferencesManager manager;
    private String version = "Free Version";
    private DBHandler handler;
    private SelectedProductListAdapter adapter;
    private ArrayList<Ingredients> ingredientsArrayList;
    List<String> ingr1 = new ArrayList<>();
    List<String> ingr2 = new ArrayList<>();
    List<String> ingr3 = new ArrayList<>();
    List<String> ingr4 = new ArrayList<>();
    List<String> ingr5 = new ArrayList<>();
    List<String> ingr6 = new ArrayList<>();
    List<String> ingr7 = new ArrayList<>();
    List<String> ingr8 = new ArrayList<>();
    List<String> ingr9 = new ArrayList<>();
    List<String> ingr10 = new ArrayList<>();
    List<String> ingr11 = new ArrayList<>();
    List<String> ingr12 = new ArrayList<>();
    List<String> ingr13 = new ArrayList<>();
    List<String> ingr14 = new ArrayList<>();
    List<String> ingr15 = new ArrayList<>();
    List<String> ingr16 = new ArrayList<>();
    List<String> ingr17 = new ArrayList<>();
    List<String> ingr18 = new ArrayList<>();
    List<String> ingr19 = new ArrayList<>();
    List<String> ingr20 = new ArrayList<>();
    List<String> ingr21 = new ArrayList<>();
    List<String> ingr22 = new ArrayList<>();
    List<String> ingr23 = new ArrayList<>();
    List<String> ingr24 = new ArrayList<>();
    List<String> ingr25 = new ArrayList<>();
    List<String> ingr26 = new ArrayList<>();
    List<String> ingr27 = new ArrayList<>();
    List<String> ingr28 = new ArrayList<>();
    List<String> ingr29 = new ArrayList<>();
    List<String> ingr30 = new ArrayList<>();
    List<String> ingr31 = new ArrayList<>();
    List<String> ingr32 = new ArrayList<>();
    List<String> ingr33 = new ArrayList<>();
    List<String> ingr34 = new ArrayList<>();
    List<String> ingr35 = new ArrayList<>();
    List<String> ingr36 = new ArrayList<>();
    List<String> ingr37 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIngredientsScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        handler = new DBHandler(IngredientsScreen.this);
        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IngredientsScreen.this,MainActivity.class));
                finish();
            }
        });
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        manager = new SharedPreferencesManager(IngredientsScreen.this);
        version = manager.retrieveString("billing","Free Version");
        AdView mAdView = findViewById(R.id.adView);
        ingredientsArrayList = new ArrayList<>();
        if (version.equals("Free Version")) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }else{
            mAdView.setVisibility(View.GONE);
        }

        loadRecipes();

        binding.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductsList();
            }
        });

    }


    private void loadRecipes() {
        Resources res = getResources();

        ingr1.add("Spaghetti 320g");
        ingr1.add("Pecorino romano 200g");
        ingr1.add("Pepe nero in grani 5g");

        Ingredients recipe1 = new Ingredients("Spaghetti cacio e pepe",ingr1,
                R.drawable.spaghetti_cacio_e_pepe,res.getString(R.string.recipe1));
        ingredientsArrayList.add(recipe1);


        ingr2.add("Spaghetti grossi 320 g");
        ingr2.add("Aglio 1 spicchio");
        ingr2.add("olio extravergine d'oliva");
        ingr2.add("sale fino");
        ingr2.add("vongole 1kg");
        ingr2.add("prezzemolo 1 mazzetto");
        ingr2.add("pepe nero");
        ingr2.add("sale grosso");

        Ingredients recipe2 = new Ingredients("Spaghetti alle vongole",ingr2,R.drawable.spaghetti_alle_vongole,
                res.getString(R.string.recipe2));
        ingredientsArrayList.add(recipe2);


        ingr3.add("Riso ribe 200g");
        ingr3.add("Prosciutto cotto 30g");
        ingr3.add("Acqua 200 g");
        ingr3.add("Olio di semi di arachide q.b.");
        ingr3.add("Sale fino q.b.");
        ingr3.add("Pisellini 50g");
        ingr3.add("Uova 2");
        ingr3.add("Vino rosso 25 g");
        ingr3.add("Erba cipollina q.b.");


        Ingredients recipe3 = new Ingredients("Riso alla cantonese",ingr3,R.drawable.riso_alla_cantonese,
                res.getString(R.string.recipe3));
        ingredientsArrayList.add(recipe3);


        ingr4.add("Riso carnaroli 320g");
        ingr4.add("Cipolle ramate 100g");
        ingr4.add("Parmigiano reggiano DOP 80g");
        ingr4.add("Burro 50g");
        ingr4.add("Sale fino q.b.");
        ingr4.add("Zucca 600g");
        ingr4.add("Brodo vegetale 1,5 L");
        ingr4.add("Vino bianco 60g");
        ingr4.add("Pepe nero q.b.");
        ingr4.add("Olio extravergine d’oliva 20g");

        Ingredients recipe4 = new Ingredients("Risotto alla zucca",ingr4,R.drawable.risotto_alla_zucca,
                res.getString(R.string.recipe4));
        ingredientsArrayList.add(recipe4);

        ingr5.add("Spaghetti 320g");
        ingr5.add("Pecorino romano 200g");
        ingr5.add("Pepe nero in grani 5g");

        Ingredients recipe5 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe5));
        ingredientsArrayList.add(recipe5);

        ingr6.add("Spaghetti 320g");
        ingr6.add("Pecorino romano 200g");
        ingr6.add("Pepe nero in grani 5g");

        Ingredients recipe6 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe6));
        ingredientsArrayList.add(recipe6);

        ingr7.add("Spaghetti 320g");
        ingr7.add("Pecorino romano 200g");
        ingr7.add("Pepe nero in grani 5g");

        Ingredients recipe7 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe7));
        ingredientsArrayList.add(recipe7);

        ingr8.add("Spaghetti 320g");
        ingr8.add("Pecorino romano 200g");
        ingr8.add("Pepe nero in grani 5g");

        Ingredients recipe8 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe8));
        ingredientsArrayList.add(recipe8);

        ingr9.add("Spaghetti 320g");
        ingr9.add("Pecorino romano 200g");
        ingr9.add("Pepe nero in grani 5g");

        Ingredients recipe9 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe9));
        ingredientsArrayList.add(recipe9);

        ingr10.add("Spaghetti 320g");
        ingr10.add("Pecorino romano 200g");
        ingr10.add("Pepe nero in grani 5g");

        Ingredients recipe10 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe10));
        ingredientsArrayList.add(recipe10);

        ingr11.add("Spaghetti 320g");
        ingr11.add("Pecorino romano 200g");
        ingr11.add("Pepe nero in grani 5g");

        Ingredients recipe11 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe11));
        ingredientsArrayList.add(recipe11);

        ingr12.add("Spaghetti 320g");
        ingr12.add("Pecorino romano 200g");
        ingr12.add("Pepe nero in grani 5g");

        Ingredients recipe12 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe12));
        ingredientsArrayList.add(recipe12);

        ingr13.add("Spaghetti 320g");
        ingr13.add("Pecorino romano 200g");
        ingr13.add("Pepe nero in grani 5g");

        Ingredients recipe13 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe13));
        ingredientsArrayList.add(recipe13);

        ingr14.add("Spaghetti 320g");
        ingr14.add("Pecorino romano 200g");
        ingr14.add("Pepe nero in grani 5g");

        Ingredients recipe14 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe14));
        ingredientsArrayList.add(recipe14);

        ingr15.add("Spaghetti 320g");
        ingr15.add("Pecorino romano 200g");
        ingr15.add("Pepe nero in grani 5g");

        Ingredients recipe15 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe15));
        ingredientsArrayList.add(recipe15);

        ingr16.add("Spaghetti 320g");
        ingr16.add("Pecorino romano 200g");
        ingr16.add("Pepe nero in grani 5g");

        Ingredients recipe16 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe16));
        ingredientsArrayList.add(recipe16);

        ingr17.add("Spaghetti 320g");
        ingr17.add("Pecorino romano 200g");
        ingr17.add("Pepe nero in grani 5g");

        Ingredients recipe17 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe17));
        ingredientsArrayList.add(recipe17);

        ingr18.add("Spaghetti 320g");
        ingr18.add("Pecorino romano 200g");
        ingr18.add("Pepe nero in grani 5g");

        Ingredients recipe18 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe18));
        ingredientsArrayList.add(recipe18);

        ingr19.add("Spaghetti 320g");
        ingr19.add("Pecorino romano 200g");
        ingr19.add("Pepe nero in grani 5g");

        Ingredients recipe19 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe19));
        ingredientsArrayList.add(recipe19);

        ingr20.add("Spaghetti 320g");
        ingr20.add("Pecorino romano 200g");
        ingr20.add("Pepe nero in grani 5g");

        Ingredients recipe20 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe20));
        ingredientsArrayList.add(recipe20);

        ingr21.add("Spaghetti 320g");
        ingr21.add("Pecorino romano 200g");
        ingr21.add("Pepe nero in grani 5g");

        Ingredients recipe21 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe21));
        ingredientsArrayList.add(recipe21);

        ingr22.add("Spaghetti 320g");
        ingr22.add("Pecorino romano 200g");
        ingr22.add("Pepe nero in grani 5g");

        Ingredients recipe22 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe22));
        ingredientsArrayList.add(recipe22);

        ingr23.add("Spaghetti 320g");
        ingr23.add("Pecorino romano 200g");
        ingr23.add("Pepe nero in grani 5g");

        Ingredients recipe23 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe23));
        ingredientsArrayList.add(recipe23);

        ingr24.add("Spaghetti 320g");
        ingr24.add("Pecorino romano 200g");
        ingr24.add("Pepe nero in grani 5g");

        Ingredients recipe24 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe24));
        ingredientsArrayList.add(recipe24);

        ingr25.add("Spaghetti 320g");
        ingr25.add("Pecorino romano 200g");
        ingr25.add("Pepe nero in grani 5g");

        Ingredients recipe25 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe25));
        ingredientsArrayList.add(recipe25);

        ingr26.add("Spaghetti 320g");
        ingr26.add("Pecorino romano 200g");
        ingr26.add("Pepe nero in grani 5g");

        Ingredients recipe26 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe26));
        ingredientsArrayList.add(recipe26);

        ingr27.add("Spaghetti 320g");
        ingr27.add("Pecorino romano 200g");
        ingr27.add("Pepe nero in grani 5g");

        Ingredients recipe27 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe27));
        ingredientsArrayList.add(recipe27);

        ingr28.add("Spaghetti 320g");
        ingr28.add("Pecorino romano 200g");
        ingr28.add("Pepe nero in grani 5g");

        Ingredients recipe28 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe28));
        ingredientsArrayList.add(recipe28);

        ingr29.add("Spaghetti 320g");
        ingr29.add("Pecorino romano 200g");
        ingr29.add("Pepe nero in grani 5g");

        Ingredients recipe29 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe29));
        ingredientsArrayList.add(recipe29);

        ingr30.add("Spaghetti 320g");
        ingr30.add("Pecorino romano 200g");
        ingr30.add("Pepe nero in grani 5g");

        Ingredients recipe30 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe30));
        ingredientsArrayList.add(recipe30);

        ingr31.add("Spaghetti 320g");
        ingr31.add("Pecorino romano 200g");
        ingr31.add("Pepe nero in grani 5g");

        Ingredients recipe31 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe31));
        ingredientsArrayList.add(recipe31);

        ingr32.add("Spaghetti 320g");
        ingr32.add("Pecorino romano 200g");
        ingr32.add("Pepe nero in grani 5g");

        Ingredients recipe32 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe32));
        ingredientsArrayList.add(recipe32);

        ingr33.add("Spaghetti 320g");
        ingr33.add("Pecorino romano 200g");
        ingr33.add("Pepe nero in grani 5g");

        Ingredients recipe33 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe33));
        ingredientsArrayList.add(recipe33);

        ingr34.add("Spaghetti 320g");
        ingr34.add("Pecorino romano 200g");
        ingr34.add("Pepe nero in grani 5g");

        Ingredients recipe34 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe34));
        ingredientsArrayList.add(recipe34);

        ingr35.add("Spaghetti 320g");
        ingr35.add("Pecorino romano 200g");
        ingr35.add("Pepe nero in grani 5g");

        Ingredients recipe35 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe35));
        ingredientsArrayList.add(recipe35);

        ingr36.add("Spaghetti 320g");
        ingr36.add("Pecorino romano 200g");
        ingr36.add("Pepe nero in grani 5g");

        Ingredients recipe36 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe36));
        ingredientsArrayList.add(recipe36);

        ingr37.add("Spaghetti 320g");
        ingr37.add("Pecorino romano 200g");
        ingr37.add("Pepe nero in grani 5g");

        Ingredients recipe37 = new Ingredients("Spaghetti cacio e pepe",ingr1,R.drawable.spaghetti_cacio_e_pepe,
                res.getString(R.string.recipe37));
        ingredientsArrayList.add(recipe37);


    }

    ListView listView;
    private void showProductsList() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(IngredientsScreen.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.products_dialog, null);
        dialogBuilder.setView(dialogView);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText searchBar = (EditText) dialogView.findViewById(R.id.searchTxt);
        listView = (ListView)dialogView.findViewById(R.id.listView);

        AlertDialog alertDialog = dialogBuilder.create();

        loadData(alertDialog);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0){
                    adapter.getFilter().filter(s.toString());
                }else {
                    loadData(alertDialog);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        alertDialog.show();

    }

    ArrayList<Ingredients> recipeArrayList = new ArrayList<>();
    private void loadData(AlertDialog alertDialog) {
        productArrayList = handler.getAllProducts();

        adapter = new SelectedProductListAdapter(IngredientsScreen.this,productArrayList);
        listView.setAdapter(adapter);
        adapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Product products = productArrayList.get(position);
                for (int i = 0;i < ingredientsArrayList.size();i++){
                    for (String model : ingredientsArrayList.get(i).getIngredients())
                    if (model.contains(products.getProductName())){

                        recipeArrayList.add(ingredientsArrayList.get(i));
                        showList();
                        alertDialog.dismiss();
                    }
                }

            //    Toast.makeText(IngredientsScreen.this, products.getProductName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showList() {

        IngredientListAdapters ingredientListAdapters = new IngredientListAdapters(IngredientsScreen.this,recipeArrayList);
        binding.recyclerview.setAdapter(ingredientListAdapters);
        ingredientListAdapters.notifyDataSetChanged();
    }


}