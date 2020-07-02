package com.pubg.sensitivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.media.Image;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;


import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Home extends AppCompatActivity {
    private InterstitialAd mInterstitialAd1;
    private InterstitialAd mInterstitialAd2;
    private InterstitialAd mInterstitialAd3;
    private InterstitialAd mInterstitialAd4;
    TextView textView;

    Animation topAnim, leftanim , rigtanim;

    Button rambutton , playerbutton , controlbutton ,charbutton , aboutbutton;




    @SuppressLint({"ClickableViewAccessibility", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);





        leftanim= AnimationUtils.loadAnimation(this,R.anim.lefthome);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.up);
        rigtanim= AnimationUtils.loadAnimation(this,R.anim.righthome);




        textView = findViewById(R.id.linerar2);
        rambutton = findViewById(R.id.button1);
        playerbutton = findViewById(R.id.button2);
        controlbutton = findViewById(R.id.button3);
        charbutton = findViewById(R.id.button4);
        aboutbutton = findViewById(R.id.button5);


        rambutton.setAnimation(leftanim);
        playerbutton.setAnimation(rigtanim);
        controlbutton.setAnimation(leftanim);
        charbutton.setAnimation(rigtanim);
        aboutbutton.setAnimation(leftanim);
        textView.setAnimation(topAnim);

        final TextView tv=(TextView)findViewById(R.id.welcom);
        tv.setText("Welcome");
        tv.postDelayed(new Runnable() {
            public void run() {
                tv.setVisibility(View.INVISIBLE);
            }
        }, 1200);






        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mInterstitialAd1 = new InterstitialAd(this);
        mInterstitialAd1.setAdUnitId("ca-app-pub-2715877056545900/6500805222");
        mInterstitialAd1.loadAd(new AdRequest.Builder().build());

        mInterstitialAd2 = new InterstitialAd(this);
        mInterstitialAd2.setAdUnitId("ca-app-pub-2715877056545900/8196640632");
        mInterstitialAd2.loadAd(new AdRequest.Builder().build());

        mInterstitialAd3 = new InterstitialAd(this);
        mInterstitialAd3.setAdUnitId("ca-app-pub-2715877056545900/8771355706");
        mInterstitialAd3.loadAd(new AdRequest.Builder().build());

        mInterstitialAd4 = new InterstitialAd(this);
        mInterstitialAd4.setAdUnitId("ca-app-pub-2715877056545900/3716671274");
        mInterstitialAd4.loadAd(new AdRequest.Builder().build());




        rambutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {

                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 000000000));

                }


                return false;
            }
        });
        rambutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ramscreen.class);
                startActivity(intent);

                mInterstitialAd1.isLoaded();
                    mInterstitialAd1.show();
                mInterstitialAd1.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        mInterstitialAd1.loadAd(new AdRequest.Builder().build());
                        mInterstitialAd1.show();
                    }
                });
                    }
                });




        playerbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFC8CF00));

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {

                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 000000000));

                }


                return false;
            }
        });
        playerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, playerscreen.class);
                startActivity(intent);
                mInterstitialAd2.isLoaded();
                mInterstitialAd2.show();

                mInterstitialAd2.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        mInterstitialAd2.loadAd(new AdRequest.Builder().build());
                        mInterstitialAd2.show();
                    }
                });
                    }
                });

        controlbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFF783993));

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {

                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 000000000));

                }


                return false;
            }
        });
        controlbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, control.class);
                startActivity(intent);
                mInterstitialAd3.isLoaded();
                mInterstitialAd3.show();

                mInterstitialAd3.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        mInterstitialAd3.loadAd(new AdRequest.Builder().build());
                        mInterstitialAd3.show();
                    }
                });
                    }
                });

        charbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFF3D7CE6));

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {

                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 000000000));

                }


                return false;
            }
        });
        charbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, characterscreen.class);
                startActivity(intent);
                mInterstitialAd4.isLoaded();
                mInterstitialAd4.show();

                mInterstitialAd4.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        mInterstitialAd4.loadAd(new AdRequest.Builder().build());
                        mInterstitialAd4.show();
                    }
                });

                    }
                });

        aboutbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFF008000));

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {

                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 000000000));

                }


                return false;
            }
        });
        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, aboutscreen.class);
                startActivity(intent);


            }
        });

    }
    
}

