package com.pubg.sensitivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.os.Handler;

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
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

import java.util.ArrayList;

public class control extends AppCompatActivity {
    RecyclerView recyclerView;
    //firebase
    private DatabaseReference myref;

    // Variables
    private ArrayList<play> playList;
    private RecyclerAdpater recyclerAdpater;
    private AdView mAdView;
    String unityGameID = "3587723";
    Boolean testMode = false;
    private String interstitialAdPlacement = "controlinterstial";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        UnityAds.initialize(control.this,unityGameID,testMode);
        IUnityAdsListener unityAdsListener = new IUnityAdsListener() {
            @Override
            public void onUnityAdsReady(String s) {

            }

            @Override
            public void onUnityAdsStart(String s) {

            }

            @Override
            public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {

            }

            @Override
            public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {

            }
        };

        UnityAds.setListener(unityAdsListener);
        if (UnityAds.isInitialized()){
            UnityAds.load(interstitialAdPlacement);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    DisplayInterstitialAd();
                }
            },500);
        }else {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    UnityAds.load(interstitialAdPlacement);


                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            DisplayInterstitialAd();
                        }
                    },500);
                }
            },500);
        }


        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //firebase
        myref = FirebaseDatabase.getInstance().getReference();

        //Arraylist
        playList = new ArrayList<>();

        //clear arraylist
        ClearAll();

        //get data method
        GetDataFromFirebase();



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
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
    private void GetDataFromFirebase() {

        Query query = myref.child("Control");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                ClearAll();

                for(DataSnapshot snapshot:datasnapshot.getChildren()){
                    play play = new play();

                    play.setImage(snapshot.child("image").getValue().toString());
                    play.setName(snapshot.child("name").getValue().toString());

                    playList.add(play);

                }
                recyclerAdpater = new RecyclerAdpater(getApplicationContext(),playList);
                recyclerView.setAdapter(recyclerAdpater);
                recyclerAdpater.notifyDataSetChanged();
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


    }

    private void  ClearAll() {
        if (playList != null) {
            playList.clear();

            if (recyclerAdpater != null) {
                recyclerAdpater.notifyDataSetChanged();
            }
        }

        playList = new ArrayList<>();
    }
    private  void DisplayInterstitialAd () {
        if (UnityAds.isReady(interstitialAdPlacement)) {
            UnityAds.show(control.this, interstitialAdPlacement);
        }
    }

}
