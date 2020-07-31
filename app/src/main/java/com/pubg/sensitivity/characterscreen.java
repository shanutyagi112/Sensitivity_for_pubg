package com.pubg.sensitivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;


public class characterscreen extends AppCompatActivity {
    private charadapter charadapter;
    RecyclerView recyclerView;
    private ArrayList<charact> charactlist;
    private DatabaseReference myref;
    private EditText txt_Search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characterscreen);



        recyclerView = findViewById(R.id.recyclerView);
        txt_Search = (EditText) findViewById(R.id.txt_search);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //firebase
        myref = FirebaseDatabase.getInstance().getReference();

        //Arraylist
        charactlist = new ArrayList<>();

        //clear arraylist
        ClearAll();

        //get data method
        GetDataFromFirebase();




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView = findViewById(R.id.adView);
        AdSize adSize = new AdSize(320, 50);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

    }


    private void ClearAll() {
        if (charactlist != null) {
            charactlist.clear();

            if (charadapter != null) {
                charadapter.notifyDataSetChanged();
            }
        }

        charactlist = new ArrayList<>();
    }


    private void GetDataFromFirebase() {

        Query query = myref.child("Characterid");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                ClearAll();

                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    charact charact = new charact();

                    charact.setPlayer(snapshot.child("player").getValue().toString());
                    charact.setCharacter(snapshot.child("character").getValue().toString());
                    charact.setSearch(snapshot.child("search").getValue().toString());

                    charactlist.add(charact);

                }
                charadapter = new charadapter(getApplicationContext(), charactlist);
                recyclerView.setAdapter(charadapter);
                charadapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


        txt_Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }
        });

    }

        private void filter (String text){
            ArrayList<charact> filterlist = new ArrayList<>();
            for (charact item : charactlist) {
                if (item.getSearch().toLowerCase().contains(text.toLowerCase())) {
                    filterlist.add(item);

                }

            }
            charadapter.filteredlist(filterlist);

        }
    }