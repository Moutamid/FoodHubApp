package com.moutamid.foodhubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.moutamid.foodhubapp.adapters.IngredientListAdapters;
import com.moutamid.foodhubapp.databinding.ActivityIngredientsScreenBinding;
import com.moutamid.foodhubapp.model.Ingredients;

import java.util.ArrayList;

public class IngredientsScreen extends AppCompatActivity {

    private ActivityIngredientsScreenBinding binding;
    private ArrayList<Ingredients> ingredientsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIngredientsScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ingredientsArrayList = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        Resources res = getResources();
        Ingredients model1 = new Ingredients(res.getString(R.string.ingredient1),"https://ricette.giallozafferano.it/Spaghetti-Cacio-e-Pepe.html",320.0);
        Ingredients model2 = new Ingredients(res.getString(R.string.ingredient2),"https://ricette.giallozafferano.it/Spaghetti-Cacio-e-Pepe.html",200.0);
        Ingredients model3 = new Ingredients(res.getString(R.string.ingredient3),"https://ricette.giallozafferano.it/Spaghetti-Cacio-e-Pepe.html",5.0);
        Ingredients model4 = new Ingredients(res.getString(R.string.ingredient4),"https://ricette.giallozafferano.it/Spaghetti-alle-vongole.html",320.0);
        Ingredients model5 = new Ingredients(res.getString(R.string.ingredient5),"https://ricette.giallozafferano.it/Spaghetti-alle-vongole.html",1.0);
        Ingredients model6 = new Ingredients(res.getString(R.string.ingredient6),"https://ricette.giallozafferano.it/Spaghetti-alle-vongole.html",0);
        Ingredients model7 = new Ingredients(res.getString(R.string.ingredient7),"https://ricette.giallozafferano.it/Spaghetti-alle-vongole.html",0);
        Ingredients model8 = new Ingredients(res.getString(R.string.ingredient8),"https://ricette.giallozafferano.it/Spaghetti-alle-vongole.html",1.0);
        Ingredients model9 = new Ingredients(res.getString(R.string.ingredient9),"https://ricette.giallozafferano.it/Spaghetti-alle-vongole.html",1.0);
        Ingredients model10 = new Ingredients(res.getString(R.string.ingredient10),"https://ricette.giallozafferano.it/Spaghetti-alle-vongole.html",0);
        Ingredients model11 = new Ingredients(res.getString(R.string.ingredient11),"https://ricette.giallozafferano.it/Spaghetti-alle-vongole.html",0);
        Ingredients model12 = new Ingredients(res.getString(R.string.ingredient12),"https://ricette.giallozafferano.it/Riso-alla-cantonese.html",200.0);
        Ingredients model13 = new Ingredients(res.getString(R.string.ingredient13),"https://ricette.giallozafferano.it/Riso-alla-cantonese.html",30.0);
        Ingredients model14 = new Ingredients(res.getString(R.string.ingredient14),"https://ricette.giallozafferano.it/Riso-alla-cantonese.html",200.0);
        Ingredients model15 = new Ingredients(res.getString(R.string.ingredient15),"https://ricette.giallozafferano.it/Riso-alla-cantonese.html",0);
        Ingredients model16 = new Ingredients(res.getString(R.string.ingredient16),"https://ricette.giallozafferano.it/Riso-alla-cantonese.html",0);
        Ingredients model17 = new Ingredients(res.getString(R.string.ingredient17),"https://ricette.giallozafferano.it/Riso-alla-cantonese.html",50.0);
        Ingredients model18 = new Ingredients(res.getString(R.string.ingredient18),"https://ricette.giallozafferano.it/Riso-alla-cantonese.html",2.0);
        Ingredients model19 = new Ingredients(res.getString(R.string.ingredient19),"https://ricette.giallozafferano.it/Riso-alla-cantonese.html",25.0);
        Ingredients model20 = new Ingredients(res.getString(R.string.ingredient20),"https://ricette.giallozafferano.it/Riso-alla-cantonese.html",0);
        Ingredients model21 = new Ingredients(res.getString(R.string.ingredient21),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",320.0);
        Ingredients model22 = new Ingredients(res.getString(R.string.ingredient22),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",100.0);
        Ingredients model23 = new Ingredients(res.getString(R.string.ingredient23),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",80.0);
        Ingredients model24 = new Ingredients(res.getString(R.string.ingredient24),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",50.0);
        Ingredients model25 = new Ingredients(res.getString(R.string.ingredient25),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",600.0);
        Ingredients model26 = new Ingredients(res.getString(R.string.ingredient26),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",1.5);
        Ingredients model27 = new Ingredients(res.getString(R.string.ingredient27),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",60.0);
        Ingredients model28 = new Ingredients(res.getString(R.string.ingredient28),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",320.0);
        Ingredients model29 = new Ingredients(res.getString(R.string.ingredient29),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",15.0);
        Ingredients model30 = new Ingredients(res.getString(R.string.ingredient30),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",380.0);
        Ingredients model31 = new Ingredients(res.getString(R.string.ingredient31),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model32 = new Ingredients(res.getString(R.string.ingredient32),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",200.0);
        Ingredients model33 = new Ingredients(res.getString(R.string.ingredient33),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model34 = new Ingredients(res.getString(R.string.ingredient34),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",200.0);
        Ingredients model35 = new Ingredients(res.getString(R.string.ingredient35),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",1.5);
        Ingredients model36 = new Ingredients(res.getString(R.string.ingredient36),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model37 = new Ingredients(res.getString(R.string.ingredient37),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model38 = new Ingredients(res.getString(R.string.ingredient38),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model39 = new Ingredients(res.getString(R.string.ingredient39),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model40 = new Ingredients(res.getString(R.string.ingredient40),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",20.0);
        Ingredients model41 = new Ingredients(res.getString(R.string.ingredient41),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model42 = new Ingredients(res.getString(R.string.ingredient42),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model43 = new Ingredients(res.getString(R.string.ingredient43),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",300.0);
        Ingredients model44 = new Ingredients(res.getString(R.string.ingredient44),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model45 = new Ingredients(res.getString(R.string.ingredient45),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model46 = new Ingredients(res.getString(R.string.ingredient46),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model47 = new Ingredients(res.getString(R.string.ingredient47),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",2.0);
        Ingredients model48 = new Ingredients(res.getString(R.string.ingredient48),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model49 = new Ingredients(res.getString(R.string.ingredient49),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model50 = new Ingredients(res.getString(R.string.ingredient50),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model51 = new Ingredients(res.getString(R.string.ingredient51),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model52 = new Ingredients(res.getString(R.string.ingredient52),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model53 = new Ingredients(res.getString(R.string.ingredient53),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model54 = new Ingredients(res.getString(R.string.ingredient54),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model55 = new Ingredients(res.getString(R.string.ingredient55),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",0);
        Ingredients model56 = new Ingredients(res.getString(R.string.ingredient56),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",0);
        Ingredients model57 = new Ingredients(res.getString(R.string.ingredient57),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",0);
        Ingredients model58 = new Ingredients(res.getString(R.string.ingredient58),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",100.0);
        Ingredients model59 = new Ingredients(res.getString(R.string.ingredient59),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",0);
        Ingredients model60 = new Ingredients(res.getString(R.string.ingredient60),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",11.0);
        Ingredients model61 = new Ingredients(res.getString(R.string.ingredient61),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",5.0);
        Ingredients model62 = new Ingredients(res.getString(R.string.ingredient62),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",1.0);
        Ingredients model63 = new Ingredients(res.getString(R.string.ingredient63),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",0);
        Ingredients model64 = new Ingredients(res.getString(R.string.ingredient64),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",0);
        Ingredients model65 = new Ingredients(res.getString(R.string.ingredient65),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",0);
        Ingredients model66 = new Ingredients(res.getString(R.string.ingredient66),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",0);
        Ingredients model67 = new Ingredients(res.getString(R.string.ingredient67),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",5.0);
        Ingredients model68 = new Ingredients(res.getString(R.string.ingredient68),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",600.0);
        Ingredients model69 = new Ingredients(res.getString(R.string.ingredient69),"https://ricette.giallozafferano.it/Risotto-alla-zucca.html",40.0);
        Ingredients model70 = new Ingredients(res.getString(R.string.ingredient70),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model71 = new Ingredients(res.getString(R.string.ingredient71),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",240.0);
        Ingredients model72 = new Ingredients(res.getString(R.string.ingredient72),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model73 = new Ingredients(res.getString(R.string.ingredient73),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",20.0);
        Ingredients model74 = new Ingredients(res.getString(R.string.ingredient74),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",300.0);
        Ingredients model75 = new Ingredients(res.getString(R.string.ingredient75),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",200.0);
        Ingredients model76 = new Ingredients(res.getString(R.string.ingredient76),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",8.0);
        Ingredients model77 = new Ingredients(res.getString(R.string.ingredient77),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",1.0);
        Ingredients model78 = new Ingredients(res.getString(R.string.ingredient78),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",1.0);
        Ingredients model79 = new Ingredients(res.getString(R.string.ingredient79),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",4.0);
        Ingredients model80 = new Ingredients(res.getString(R.string.ingredient80),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",1.0);
        Ingredients model81 = new Ingredients(res.getString(R.string.ingredient81),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",1.0);
        Ingredients model82 = new Ingredients(res.getString(R.string.ingredient82),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",30.0);
        Ingredients model83 = new Ingredients(res.getString(R.string.ingredient83),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model84 = new Ingredients(res.getString(R.string.ingredient84),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model85 = new Ingredients(res.getString(R.string.ingredient85),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model86 = new Ingredients(res.getString(R.string.ingredient86),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model87 = new Ingredients(res.getString(R.string.ingredient87),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model88 = new Ingredients(res.getString(R.string.ingredient88),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model89 = new Ingredients(res.getString(R.string.ingredient89),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model90 = new Ingredients(res.getString(R.string.ingredient90),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model91 = new Ingredients(res.getString(R.string.ingredient91),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model92 = new Ingredients(res.getString(R.string.ingredient92),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model93 = new Ingredients(res.getString(R.string.ingredient93),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model94 = new Ingredients(res.getString(R.string.ingredient94),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model95 = new Ingredients(res.getString(R.string.ingredient95),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model96 = new Ingredients(res.getString(R.string.ingredient96),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model97 = new Ingredients(res.getString(R.string.ingredient97),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model98 = new Ingredients(res.getString(R.string.ingredient98),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model99 = new Ingredients(res.getString(R.string.ingredient99),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        Ingredients model100 = new Ingredients(res.getString(R.string.ingredient100),"https://ricette.giallozafferano.it/Penne-all-Arrabbiata.html",0);
        
        ingredientsArrayList.add(model1);
        ingredientsArrayList.add(model2);
        ingredientsArrayList.add(model3);
        ingredientsArrayList.add(model4);
        ingredientsArrayList.add(model5);
        ingredientsArrayList.add(model6);
        ingredientsArrayList.add(model7);
        ingredientsArrayList.add(model8);
        ingredientsArrayList.add(model9);
        ingredientsArrayList.add(model10);
        ingredientsArrayList.add(model11);
        ingredientsArrayList.add(model12);
        ingredientsArrayList.add(model13);
        ingredientsArrayList.add(model14);
        ingredientsArrayList.add(model15);
        ingredientsArrayList.add(model16);
        ingredientsArrayList.add(model17);
        ingredientsArrayList.add(model20);
        ingredientsArrayList.add(model21);
        ingredientsArrayList.add(model22);
        ingredientsArrayList.add(model23);
        ingredientsArrayList.add(model24);
        ingredientsArrayList.add(model25);
        ingredientsArrayList.add(model26);
        ingredientsArrayList.add(model27);
        ingredientsArrayList.add(model28);
        ingredientsArrayList.add(model29);
        ingredientsArrayList.add(model30);
        ingredientsArrayList.add(model31);
        ingredientsArrayList.add(model32);
        ingredientsArrayList.add(model33);
        ingredientsArrayList.add(model34);
        ingredientsArrayList.add(model35);
        ingredientsArrayList.add(model36);
        ingredientsArrayList.add(model37);
        ingredientsArrayList.add(model38);
        ingredientsArrayList.add(model39);
        ingredientsArrayList.add(model40);
        ingredientsArrayList.add(model41);
        ingredientsArrayList.add(model42);
        ingredientsArrayList.add(model43);
        ingredientsArrayList.add(model44);
        ingredientsArrayList.add(model45);
        ingredientsArrayList.add(model46);
        ingredientsArrayList.add(model47);
        ingredientsArrayList.add(model48);
        ingredientsArrayList.add(model49);
        ingredientsArrayList.add(model50);
        ingredientsArrayList.add(model51);
        ingredientsArrayList.add(model52);
        ingredientsArrayList.add(model53);
        ingredientsArrayList.add(model54);
        ingredientsArrayList.add(model55);
        ingredientsArrayList.add(model56);
        ingredientsArrayList.add(model57);
        ingredientsArrayList.add(model58);
        ingredientsArrayList.add(model59);
        ingredientsArrayList.add(model60);
        ingredientsArrayList.add(model61);
        ingredientsArrayList.add(model62);
        ingredientsArrayList.add(model63);
        ingredientsArrayList.add(model64);
        ingredientsArrayList.add(model65);
        ingredientsArrayList.add(model66);
        ingredientsArrayList.add(model67);
        ingredientsArrayList.add(model68);
        ingredientsArrayList.add(model69);
        ingredientsArrayList.add(model70);
        ingredientsArrayList.add(model71);
        ingredientsArrayList.add(model72);
        ingredientsArrayList.add(model73);
        ingredientsArrayList.add(model74);
        ingredientsArrayList.add(model75);
        ingredientsArrayList.add(model76);
        ingredientsArrayList.add(model77);
        ingredientsArrayList.add(model78);
        ingredientsArrayList.add(model79);
        ingredientsArrayList.add(model80);
        ingredientsArrayList.add(model81);
        ingredientsArrayList.add(model82);
        ingredientsArrayList.add(model83);
        ingredientsArrayList.add(model84);
        ingredientsArrayList.add(model85);
        ingredientsArrayList.add(model86);
        ingredientsArrayList.add(model87);
        ingredientsArrayList.add(model88);
        ingredientsArrayList.add(model89);
        ingredientsArrayList.add(model90);
        ingredientsArrayList.add(model91);
        ingredientsArrayList.add(model92);
        ingredientsArrayList.add(model93);
        ingredientsArrayList.add(model94);
        ingredientsArrayList.add(model95);
        ingredientsArrayList.add(model96);
        ingredientsArrayList.add(model97);
        ingredientsArrayList.add(model98);
        ingredientsArrayList.add(model99);
        ingredientsArrayList.add(model100);

        IngredientListAdapters adapters = new IngredientListAdapters(IngredientsScreen.this,ingredientsArrayList);
        binding.recyclerview.setAdapter(adapters);
        adapters.notifyDataSetChanged();

    }
}