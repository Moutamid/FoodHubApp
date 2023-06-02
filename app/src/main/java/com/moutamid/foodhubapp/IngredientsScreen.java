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
import android.widget.Button;
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
    ArrayList<Ingredients> recipeArrayList = new ArrayList<>();
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

    ArrayList<String> prodList = new ArrayList<>();

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

        ingr5.add("Penne rigate 320 g");
        ingr5.add("Aglio 1 spicchio");
        ingr5.add("Prezzemolo q.b.");
        ingr5.add("Burro 50g");
        ingr5.add("Sale fino q.b.");
        ingr5.add("Pomodorini pelati 380 g");
        ingr5.add("Peperoncino secco 3 ");
        ingr5.add("Olio extravergine d’oliva 20g");


        Ingredients recipe5 = new Ingredients("Penne all'arrabiata",ingr5,R.drawable.penne_all_arrabiata,
                res.getString(R.string.recipe5));
        ingredientsArrayList.add(recipe5);

        ingr6.add("Riso carnaroli 240 g");
        ingr6.add("Funghi champignon 200g");
        ingr6.add("Burro 80g");
        ingr6.add("Sale fino q.b.");
        ingr6.add("Vino bianco 50g");
        ingr6.add("Pepe bianco q.b.");
        ingr6.add("Funghi chiodini 200g");
        ingr6.add("Cipolle 1 o 2");
        ingr6.add("Parmigiano reggiano DOP 60 g");
        ingr6.add("Prezzemolo q.b.");
        ingr6.add("Acqua 1L");
        ingr6.add("Olio extravergine d’oliva q.b.");

        Ingredients recipe6 = new Ingredients("Risotto ai funghi",ingr6,R.drawable.risotto_ai_funghi,
                res.getString(R.string.recipe6));
        ingredientsArrayList.add(recipe6);

        ingr7.add("Zucchero 210 g");
        ingr7.add("Acqua tiepida 500g");
        ingr7.add("Sale fino 2g");
        ingr7.add("Farina 00 500g");
        ingr7.add("Lievito di birra secco 3g");
        ingr7.add("Uva sultanina 100g");
        ingr7.add("Olio di semi 800g");

        Ingredients recipe7 = new Ingredients("Sfinci siciliani",ingr7,R.drawable.sfinci_siciliani,
                res.getString(R.string.recipe7));
        ingredientsArrayList.add(recipe7);

        ingr8.add("Gocce di cioccolato fondente 100 g");
        ingr8.add("Arancia candita (facoltativo) 50 g");
        ingr8.add("Ricotta di pecora 1,2 kg");
        ingr8.add("Zucchero a velo 280 g");
        ingr8.add("Uova medie 10");
        ingr8.add("Farina 00 300 g");
        ingr8.add("Zucchero 300 g");
        ingr8.add("Sale fino 1 pizzico");
        ingr8.add("Zucchero (per la bagna) 50 g");
        ingr8.add("Acqua (per la bagna) 150 ml");
        ingr8.add("Maraschino ½ bicchierino");
        ingr8.add("Scorza di limone ½");
        ingr8.add("Zucchero a velo 350g");
        ingr8.add("Acqua q.b.");
        ingr8.add("Frutta candita q.b.");
        ingr8.add("Marzapane 200g");
        ingr8.add("Pasta di pistacchi 20g");
        ingr8.add("Albumi 1");
        ingr8.add("Zucchero a velo vanigliato 150g");

        Ingredients recipe8 = new Ingredients("Cassata siciliana",ingr8,R.drawable.cassata_siciliana,
                res.getString(R.string.recipe8));
        ingredientsArrayList.add(recipe8);

        ingr9.add("Farina 00 260 g");
        ingr9.add("Zucchero 20 g");
        ingr9.add("Strutto freddo di frigorifero 30 g");
        ingr9.add("Cacao amaro in polvere 5 g");
        ingr9.add("Sale fino 1 cucchiaino");
        ingr9.add("Uova 20 g");
        ingr9.add("Aceto di vino bianco 10 g");
        ingr9.add("Marsala 60 g");
        ingr9.add("Ricotta di pecora (scolata per almeno 1 notte in frigo) 1 kg");
        ingr9.add("Zucchero 130 g");
        ingr9.add("Gocce di cioccolato fondente 80g");
        ingr9.add("Uova q.b.");
        ingr9.add("Olio di semi 1 l");
        ingr9.add("Ciliegie candite q.b.");
        ingr9.add("Zucchero a velo q.b.");
        ingr9.add("Granella di pistacchi q.b.");
        ingr9.add("Arancia candita q.b.");


        Ingredients recipe9 = new Ingredients("Cannoli siciliani",ingr9,R.drawable.cannoli_siciliani,
                res.getString(R.string.recipe9));
        ingredientsArrayList.add(recipe9);

        ingr10.add("Farina 00 500 g");
        ingr10.add("Latte intero tiepido 250 ml");
        ingr10.add("Strutto 50 g");
        ingr10.add("Zucchero 50 g");
        ingr10.add("Sale fino 8 g");
        ingr10.add("Lievito di birra secco 3 g");
        ingr10.add("Uova medio 1");
        ingr10.add("Olio di semi di arahide 1,5 l");
        ingr10.add("Ricotta di pecora asciutta 400 g");
        ingr10.add("Zucchero 200 g");
        ingr10.add("Gocce di cioccolato fondente 80g");
        ingr10.add("Zucchero q.b.");
        ingr10.add("Olio di semi di arachide q.b");

        Ingredients recipe10 = new Ingredients("Cartocci siciliani fritti",ingr10,R.drawable.cartocci_siciliani_fritti,
                res.getString(R.string.recipe10));
        ingredientsArrayList.add(recipe10);


        ingr11.add("Farina 00 500 g");
        ingr11.add("Uova 2");
        ingr11.add("Latte intero 125 g");
        ingr11.add("Burro a temperatura ambiente 100 g");
        ingr11.add("Zucchero 75 g");
        ingr11.add("Scorza di limone 1");
        ingr11.add("Ammoniaca per dolci 1 cucchiaino");
        ingr11.add("Lievito in polvere per dolci 1 bustina");
        ingr11.add("Sale fino 1 pizzico");
        ingr11.add("Zucchero a velo 250 g");
        ingr11.add("Acqua 25 ml");
        ingr11.add("Succo di limone 1");


        Ingredients recipe11 = new Ingredients("Taralli siciliani",ingr11,R.drawable.taralli_siciliani,
                res.getString(R.string.recipe11));
        ingredientsArrayList.add(recipe11);


        ingr12.add("Zucchero 160 g");
        ingr12.add("Scorza d'arancia 2");
        ingr12.add("Zucca polpa 500 g");
        ingr12.add("Uova medie 3");
        ingr12.add("Lievito in polvere per dolci 8 g");
        ingr12.add("Farina 0 250 g");
        ingr12.add("Olio di semi di girasole q.b.");
        ingr12.add("Zucchero a velo q.b.");

        Ingredients recipe12 = new Ingredients("Frittelle dolci alla zucca",ingr12,R.drawable.frittelle_dolci_alla_zucca,
                res.getString(R.string.recipe12));
        ingredientsArrayList.add(recipe12);


        ingr13.add("Zafferano 1 bustina");
        ingr13.add("Riso Vialone Nano 500 g");
        ingr13.add("Acqua 1,2 l");
        ingr13.add("Burro 30 g");
        ingr13.add("Sale Fino 1 pizzico");
        ingr13.add("Caciocavallo stagionato da grattugiare 100 g");
        ingr13.add("Sale Fino q.b.");
        ingr13.add("Cipolle mezza");
        ingr13.add("Maiale macinato 100 g");
        ingr13.add("Passata di Pomodoro 200 g");
        ingr13.add("Caciocavallo Fresco 50 g");
        ingr13.add("Pepe Nero q.b.");
        ingr13.add("Burro 25 g");
        ingr13.add("Olio Extravergine d'Oliva q.b.");
        ingr13.add("Pisellini 80 g");
        ingr13.add("Vino Rosso 50 ml");

        Ingredients recipe13 = new Ingredients("Arancino di Riso",ingr13,R.drawable.arachidi,
                res.getString(R.string.recipe13));
        ingredientsArrayList.add(recipe13);


        ingr14.add("Fettine di Manzo 1 kg");
        ingr14.add("Alloro 24 foglie");
        ingr14.add("Olio Extravergine d'Oliva q.b.");
        ingr14.add("Cipolle Rosse 1 bustina");
        ingr14.add("Pinoli 50 g");
        ingr14.add("Pepe Nero q.b.");
        ingr14.add("Olio Extravergine d'Oliva 50 ml");
        ingr14.add("Pangrattato 150 g");
        ingr14.add("Sale Fino q.b.");
        ingr14.add("Uva Passa 50 g");
        ingr14.add("Caciocavallo 150 g");
        ingr14.add("Cipolle Rosse 1 bustina");

        Ingredients recipe14 = new Ingredients("Involtini alla Siciliana",ingr14,R.drawable.involtini_alla_siciliana,
                res.getString(R.string.recipe14));
        ingredientsArrayList.add(recipe14);

        ingr15.add("Manzo macinato 100 g");
        ingr15.add("Manzo 600 g");
        ingr15.add("Pecorino da grattugiare 20 g");
        ingr15.add("Pangrattato 30 g");
        ingr15.add("Uova Sode 3");
        ingr15.add("Caciocavallo 40 g");
        ingr15.add("Mortadella 50 g");
        ingr15.add("Lardo 30 g");
        ingr15.add("Olio Extravergine d'Oliva q.b.");
        ingr15.add("Cipolle 1");
        ingr15.add("Sedano 1 costa");
        ingr15.add("Sale Fino q.b.");
        ingr15.add("Vino Rosso 50 ml");
        ingr15.add("Triplo Concentrato di Pomodoro 1 cucchiaio");
        ingr15.add("Carote 1");
        ingr15.add("Pepe Nero q.b.");
        ingr15.add("Passata di Pomodoro 500 g");

        Ingredients recipe15 = new Ingredients("Falsomagro",ingr15,R.drawable.falsomagro,
                res.getString(R.string.recipe15));
        ingredientsArrayList.add(recipe15);

        ingr16.add("Pesce Spada a fette 300 g");
        ingr16.add("Olive Verdi denocciolate 50 g");
        ingr16.add("Aglio 1 spicchio");
        ingr16.add("Origano q.b.");
        ingr16.add("Pepe Nero q.b.");
        ingr16.add("Pomodorini 300 g");
        ingr16.add("Olio Extravergine d'Oliva 30 g");
        ingr16.add("Pinoli 10 g");
        ingr16.add("Sale Fino q.b.");

        Ingredients recipe16 = new Ingredients("Pesce Spada alla Siciliana",ingr16,R.drawable.pesce_spada_alla_siciliana,
                res.getString(R.string.recipe16));
        ingredientsArrayList.add(recipe16);

        ingr17.add("Cous Cous precotto 300 g");
        ingr17.add("Vongole 1 kg");
        ingr17.add("Gamberi 400 g");
        ingr17.add("Vino Bianco secco 40 g");
        ingr17.add("Peperoncino fresco 2");
        ingr17.add("Pepe Nero q.b.");
        ingr17.add("Pomodorini Ciliegino 450 g");
        ingr17.add("Cozze 1 kg");
        ingr17.add("Calamari 500 g");
        ingr17.add("Olio Extravergine d'Oliva 50 g");
        ingr17.add("Aglio 3 spicchi");
        ingr17.add("Sale Fino q.b.");
        ingr17.add("Menta tritata al coltello q.b.");

        Ingredients recipe17 = new Ingredients("CousCous ai Frutti di Mare",ingr17,R.drawable.couscous_ai_frutti_di_mare,
                res.getString(R.string.recipe17));
        ingredientsArrayList.add(recipe17);

        ingr18.add("Sarde già pulite 520 g");
        ingr18.add("Alloro q.b.");
        ingr18.add("Pangrattato 50 g");
        ingr18.add("Prezzemolo 10 g");
        ingr18.add("Acciughe sott'olio 15 g");
        ingr18.add("Sale Fino q.b.");
        ingr18.add("Olio Extravergine d'Oliva 20 g");
        ingr18.add("Uvetta 25 g");
        ingr18.add("Pinoli 25 g");
        ingr18.add("Zucchero 15 g");
        ingr18.add("Pepe Nero q.b.");
        ingr18.add("Miele di Acacia 35 g");
        ingr18.add("Succo d'Arancia 35 g");

        Ingredients recipe18 = new Ingredients("Sarde a Beccafico",ingr18,R.drawable.sarde_a_beccafico,
                res.getString(R.string.recipe18));
        ingredientsArrayList.add(recipe18);

        ingr19.add("Filetto di merluzzo 700g");
        ingr19.add("Mollica di pane 100g");
        ingr19.add("Prezzemolo 1 ciuffo");
        ingr19.add("Timo q.b.");
        ingr19.add("Uova 2");
        ingr19.add("Aglio 1 spicchio");
        ingr19.add("Sale fino q.b.");
        ingr19.add("Pepe nero q.b.");
        ingr19.add("Parmiggiano reggiano DOP 80g");
        ingr19.add("Farina 00 q.b.");
        ingr19.add("Olio di semi di arachidi q.b.");

        Ingredients recipe19 = new Ingredients("Polpette di pesce",ingr19,R.drawable.polpette_di_pesce,
                res.getString(R.string.recipe19));
        ingredientsArrayList.add(recipe19);

        ingr20.add("4 fette di pesce spada da 50g");
        ingr20.add("Basilico 11 foglie");
        ingr20.add("Pomodorini ramati 240g");
        ingr20.add("Peperoncino in polvere");
        ingr20.add("Aglio 1 o 2 spicchi");
        ingr20.add("Olive verdi 20 g");
        ingr20.add("Capperi sotto sale 20g");
        ingr20.add("Pangrattato 40 g");
        ingr20.add("Olio extravergine d’oliva 30g");
        ingr20.add("Sale q.b.");

        Ingredients recipe20 = new Ingredients("Involtini di pesce spada",ingr20,R.drawable.involtini_di_pesce_spada,
                res.getString(R.string.recipe20));
        ingredientsArrayList.add(recipe20);


        ingr21.add("Pesce spada 300g");
        ingr21.add("Salmone 200g");
        ingr21.add("Seppioline 200g");
        ingr21.add("Gamberi 8");
        ingr21.add("Peperoni rossi e gialli 1 e 1");
        ingr21.add("Zucchine medie 2");
        ingr21.add("Olio extravergine d’oliva 3 cucchiai");
        ingr21.add("Vino bianco mezzo bicchiere");
        ingr21.add("Sale fino q.b.");
        ingr21.add("Pepe nero q.b.");
        ingr21.add("Alloro 1 rametto");
        ingr21.add("Timo 5 rametti");
        ingr21.add("Aneto 1 ciuffo");
        ingr21.add("Rosmarino 1 rametto");
        ingr21.add("Salvia q.b.");

        Ingredients recipe21 = new Ingredients("Spiedini di pesce",ingr21,R.drawable.spiedini_di_pesce,
                res.getString(R.string.recipe21));
        ingredientsArrayList.add(recipe21);

        ingr22.add("Filetto di merluzzo 600 g");
        ingr22.add("Scorza di limone grattugiata 1 cucchiaio");
        ingr22.add("Timo 1 cucchiaio");
        ingr22.add("Prezzemolo 1 cucchiaio");
        ingr22.add("Sale fino q.b.");
        ingr22.add("Pepe nero q.b.");
        ingr22.add("Uova 2");
        ingr22.add("Farina 00 q.b.");
        ingr22.add("Sale fino q.b.");
        ingr22.add("Pepe nero q.b.");
        ingr22.add("Olio di semi di girasole q.b.");

        Ingredients recipe22 = new Ingredients("Burger di pesce",ingr22,R.drawable.burger_di_pesce,
                res.getString(R.string.recipe22));
        ingredientsArrayList.add(recipe22);

        ingr23.add("Pesce spada 2 fette");
        ingr23.add("Pangrattato 150g");
        ingr23.add("Pecorino 30g");
        ingr23.add("Olio extravergine d’oliva 50g");
        ingr23.add("Prezzemolo 1 ciuffo");
        ingr23.add("Sale fino q.b.");
        ingr23.add("Pepe nero q.b.");

        Ingredients recipe23 = new Ingredients("Pesce spada impanato",ingr23,R.drawable.pesce_spada_impanato,
                res.getString(R.string.recipe23));
        ingredientsArrayList.add(recipe23);


        ingr24.add("Pesce spada 600 g");
        ingr24.add("Pomodorini perini maturi 400g");
        ingr24.add("Mozzarella di bufala grossa 1");
        ingr24.add("Aglio 2 spicchi");
        ingr24.add("Origano q.b.");
        ingr24.add("Pepe nero q.b.");
        ingr24.add("Capperi sotto sale 15g");
        ingr24.add("Olive nero denocciolate 60g");
        ingr24.add("Olio extravergine d’oliva 5 cucchiai");

        Ingredients recipe24 = new Ingredients("Pesce spada alla pizzaiola",ingr24,R.drawable.pesce_spada_alla_pizzaiola,
                res.getString(R.string.recipe24));
        ingredientsArrayList.add(recipe24);

        ingr25.add("Filetto di salmone 400g");
        ingr25.add("Pesce spada 350g");
        ingr25.add("Gamberoni argentini 500g");
        ingr25.add("Succo d’arancia 60g");
        ingr25.add("Succo di limone 30g");
        ingr25.add("Erba cipollina q.b.");
        ingr25.add("Sale fino q.b.");
        ingr25.add("Pepe nero q.b.");
        ingr25.add("Zucchine 250g");
        ingr25.add("Semi di sesamo q.b.");
        ingr25.add("Olio extravergine d’oliva q.b.");
        ingr25.add("Prezzemolo q.b.");

        Ingredients recipe25 = new Ingredients("Spiedini di pesce al forno",ingr25,R.drawable.spiedini_di_pesce_al_forno,
                res.getString(R.string.recipe25));
        ingredientsArrayList.add(recipe25);


        ingr26.add("Sgombro 4");
        ingr26.add("Scorza d’arancia 1");
        ingr26.add("Olio extravergine d’oliva q.b. + Succo d’arancia 2");
        ingr26.add("Aneto 4 rametti");
        ingr26.add("Aglio 3 spicchi");
        ingr26.add("Pepe nero in grani 1 cucchiaio");
        ingr26.add("Sale fino 1 cucchiaio");

        Ingredients recipe26 = new Ingredients("Sgombro all'arancia",ingr26,R.drawable.sgombro_all_arancia,
                res.getString(R.string.recipe26));
        ingredientsArrayList.add(recipe26);

        ingr27.add("Sgombro filetti 550g");
        ingr27.add("Pomodorini in ciliegino 250g");
        ingr27.add("Passata di pomodoro 50g");
        ingr27.add("Uvetta 30g");
        ingr27.add("Pinoli 20g");
        ingr27.add("Capperi sotto sale 10g");
        ingr27.add("Olive nere 8");
        ingr27.add("Aglio 1 spicchio");
        ingr27.add("Prezzemolo 1 ciuffo");
        ingr27.add("Origano q.b.");
        ingr27.add("Vino bianco secco 70g");
        ingr27.add("Olio extravergine d’oliva q.b");
        ingr27.add("Sale fino q.b.");

        Ingredients recipe27 = new Ingredients("Sgombro in padella",ingr27,R.drawable.sgombro_in_padella,
                res.getString(R.string.recipe27));
        ingredientsArrayList.add(recipe27);

        ingr28.add("Rombo 1,5 kg");
        ingr28.add("Mollica 130g");
        ingr28.add("Acciughe sott’olio 2 filetti");
        ingr28.add("Succo di limone ½");
        ingr28.add("Olio extravergine d’oliva q.b.");
        ingr28.add("Sale fino q.b.");
        ingr28.add("Pepe nero q.b.");
        ingr28.add("Prezzemolo q.b.");
        ingr28.add("Basilico q.b.");
        ingr28.add("Timo q.b.");
        ingr28.add("Rosmarino q.b.");
        ingr28.add("Menta q.b.");
        ingr28.add("Carote 120g");
        ingr28.add("Zucchine 150g");
        ingr28.add("Cavolfiore verde 120g");
        ingr28.add("Fagioli 50g");
        ingr28.add("Alloro 2 foglie");

        Ingredients recipe28 = new Ingredients("Rombo gratinato con verdure",ingr28,R.drawable.rombo_gratinato_con_verdure,
                res.getString(R.string.recipe28));
        ingredientsArrayList.add(recipe28);

        ingr29.add("Manzo (carne macinata) 220 g");
        ingr29.add("Salsiccia 165 g");
        ingr29.add("Pane raffermo mollica 30 g");
        ingr29.add("Parmigiano Reggiano DOP grattugiato 25 g");
        ingr29.add("Uova 1");
        ingr29.add("Prezzemolo tritato 1 cucchiaio");
        ingr29.add("Origano secco 1 pizzico");
        ingr29.add("Noce moscata grattugiata 1 pizzico");
        ingr29.add("Sale fino q.b.");
        ingr29.add("Pepe nero q.b.");
        ingr29.add("Olio extravergine d'oliva q.b.");
        ingr29.add("Passata di pomodoro 350 g");
        ingr29.add("Acqua 50 g");
        ingr29.add("Sale fino 5 g");
        ingr29.add("Origano secco q.b.");
        ingr29.add("Pepe nero q.b.");

        Ingredients recipe29 = new Ingredients("POLPETTE AL SUGO",ingr29,R.drawable.polpette,
                res.getString(R.string.recipe29));
        ingredientsArrayList.add(recipe29);

        ingr30.add("Manzo 800g");
        ingr30.add("Pisellini sgranati 400 g");
        ingr30.add("Sedano 30 g");
        ingr30.add("Carote 30 g");
        ingr30.add("Cipolle dorate 65 g");
        ingr30.add("Farina 00 q.b.");
        ingr30.add("Vino bianco secco 80 g");
        ingr30.add("Brodo vegetale 500 g");
        ingr30.add("Sale fino q.b.");
        ingr30.add("Pepe nero q.b.");
        ingr30.add("Olio extravergine d'oliva q.b.");
        ingr30.add("Triplo concentrato di pomodoro 10 g");

        Ingredients recipe30 = new Ingredients("Spezzatino con piselli",ingr30,R.drawable.spezzatino_con_piselli,
                res.getString(R.string.recipe30));
        ingredientsArrayList.add(recipe30);

        ingr31.add("Fettine di vitello (300 g di Noce)");
        ingr31.add("Prosciutto crudo (sottili) 4 fette");
        ingr31.add("Salvia 4 foglie");
        ingr31.add("Burro 50 g");
        ingr31.add("Vino bianco 100 g");
        ingr31.add("Pepe nero q.b.");
        ingr31.add("Farina 00 50 g");
        ingr31.add("Olio extravergine d'oliva 20 g");
        ingr31.add("Acqua 20 g");

        Ingredients recipe31 = new Ingredients("Saltimbocca alla Romana",ingr31,R.drawable.saltimbocca_alla_romana,
                res.getString(R.string.recipe31));
        ingredientsArrayList.add(recipe31);

        ingr32.add("Vitello (magatello o girello) 800 g");
        ingr32.add("Sedano 1 costa");
        ingr32.add("Carote 1");
        ingr32.add("Cipolle dorate 1");
        ingr32.add("Aglio 1 spicchio");
        ingr32.add("Vino bianco 250 g");
        ingr32.add("Acqua 1,5 l");
        ingr32.add("Alloro 1 foglia");
        ingr32.add("Chiodi di garofano q.b.");
        ingr32.add("Olio extravergine d'oliva 3 cucchiai");
        ingr32.add("Pepe nero in grani q.b.");
        ingr32.add("Sale fino q.b. PER LA SALSA");
        ingr32.add("Uova 2");
        ingr32.add("Tonno sott'olio sgocciolato 100 g");
        ingr32.add("Acciughe sott'olio 3 filetti");
        ingr32.add("Capperi sotto sale 5 g");
        ingr32.add("Frutti di cappero per decorare q.b.");
        ingr32.add(" Brodo di carne 150 g");

        Ingredients recipe32 = new Ingredients("Vitello tonnato",ingr32,R.drawable.vitello_tonnato,
                res.getString(R.string.recipe32));
        ingredientsArrayList.add(recipe32);


        ingr33.add("Peperoni (4 peperoni grandi) 1100 g");
        ingr33.add("Vitello macinato 300 g");
        ingr33.add("Salsiccia 150 g");
        ingr33.add("Pane raffermo mollica 100 g");
        ingr33.add("Grana Padano DOP da grattugiare 50 g");
        ingr33.add("Provolone 200 g");
        ingr33.add("Latte intero 150 g");
        ingr33.add("Uova 2");
        ingr33.add("Prezzemolo da tritare 10 g");
        ingr33.add("Sale fino q.b.");
        ingr33.add("Pepe nero q.b.");
        ingr33.add("Grana Padano DOP da grattugiare 20 g");
        ingr33.add("Provolone da grattugiare 20 g");

        Ingredients recipe33 = new Ingredients("Peperoni ripieni di carne e salsiccia",ingr33,R.drawable.peperoni,
                res.getString(R.string.recipe33));
        ingredientsArrayList.add(recipe33);

        ingr34.add("Macinato di manzo 600");
        ingr34.add("Macinato di maiale 400 g");
        ingr34.add("Uova 1");
        ingr34.add("Grana Padano DOP (da grattugiare) 150 g");
        ingr34.add("Timo 4 rametti");
        ingr34.add("Sale fino q.b.");
        ingr34.add("Pepe nero q.b.");
        ingr34.add("Provolone a fette 150 g");
        ingr34.add("Prosciutto cotto a fette 150 g");
        ingr34.add("Cavoletti di Bruxelles 500 g");
        ingr34.add("Aglio 2 spicchi");
        ingr34.add("Sale fino q.b.");
        ingr34.add("Pepe nero q.b.");
        ingr34.add("Timo 4 rametti");
        ingr34.add("Olio extravergine d'oliva q.b.");


        Ingredients recipe34 = new Ingredients("Polpettone ripieno",ingr34,R.drawable.polpettone,
                res.getString(R.string.recipe34));
        ingredientsArrayList.add(recipe34);

        ingr35.add("Costine di maiale 1 kg");
        ingr35.add("Patate novelle 1 kg");
        ingr35.add("Rosmarino 1 rametto");
        ingr35.add("Aglio 2 spicchi");
        ingr35.add("Paprika 1 cucchiaino");
        ingr35.add("Sale fino q.b.");
        ingr35.add("Pepe nero q.b.");
        ingr35.add("Olio extravergine d'oliva 20 g");

        Ingredients recipe35 = new Ingredients("Costine al forno",ingr35,R.drawable.costine_al_forno,
                res.getString(R.string.recipe35));
        ingredientsArrayList.add(recipe35);

        ingr36.add("Sottofesa di vitello ( 8 fettine) 400 g");
        ingr36.add("Prosciutto cotto 100 g");
        ingr36.add("Provola affumicata 100 g");
        ingr36.add("Salvia q.b.");
        ingr36.add("Olio extravergine d'oliva circa 30 g");
        ingr36.add("Pepe nero q.b.");
        ingr36.add("Burro 30 g");
        ingr36.add("Sale fino q.b.");
        ingr36.add("Vino bianco 40 g");
        ingr36.add("Timo q.b.");
        ingr36.add("Rosmarino q.b.");
        ingr36.add("Farina 00 50 g");
        ingr36.add("Acqua 40 g");

        Ingredients recipe36 = new Ingredients("Involtini di vitello con prosciutto e formaggio",ingr36,
                R.drawable.involtini,
                res.getString(R.string.recipe36));
        ingredientsArrayList.add(recipe36);


        ingr37.add("Maiale lombo 250 g");
        ingr37.add("Peperoni verdi 120 g");
        ingr37.add("Pomodori ramati 120 g");
        ingr37.add("Ananas sciroppato 4 fette");
        ingr37.add("Olio di semi di girasole 1 cucchiaio");
        ingr37.add("Vino di riso 1 cucchiaio");
        ingr37.add("Uova ½");
        ingr37.add("Sale fino q.b.");
        ingr37.add("Pepe nero q.b.");
        ingr37.add("Acqua 100 g");
        ingr37.add("Farina 00 100 g");
        ingr37.add("Fecola di patate 20 g");
        ingr37.add("Lievito istantaneo per preparazioni salate 8 g");
        ingr37.add("Concentrato di pomodoro 130 g");
        ingr37.add("Zucchero 125 g");
        ingr37.add("Aceto di vino bianco 125 g");
        ingr37.add("Acqua 500 g");
        ingr37.add("Fecola di patate 35 g");
        ingr37.add("Acqua 4 cucchiai");

        Ingredients recipe37 = new Ingredients("Maiale in agrodolce",ingr37,R.drawable.maiale_in_agrodolce,
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
        Button submitBtn = (Button) dialogView.findViewById(R.id.done);
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

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showList();
                alertDialog.dismiss();
            }
        });



        alertDialog.show();

    }


    private void loadData(AlertDialog alertDialog) {
        productArrayList = handler.getAllProducts();
        prodList.clear();
        adapter = new SelectedProductListAdapter(IngredientsScreen.this,productArrayList);
        listView.setAdapter(adapter);
        adapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Product products = productArrayList.get(position);
                prodList.add(products.getProductName());

            //    Toast.makeText(IngredientsScreen.this, products.getProductName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showList() {
        recipeArrayList.clear();
        for (int i = 0;i < ingredientsArrayList.size();i++){
            for (int j = 0; j < prodList.size(); j++){
                String productModel = prodList.get(j);
                for (String model : ingredientsArrayList.get(i).getIngredients()){
                    if (model.contains(productModel)){
                        recipeArrayList.add(ingredientsArrayList.get(i));
                    }
                }
            }
        }

        IngredientListAdapters ingredientListAdapters = new IngredientListAdapters(IngredientsScreen.this,recipeArrayList);
        binding.recyclerview.setAdapter(ingredientListAdapters);
        ingredientListAdapters.notifyDataSetChanged();
    }


}