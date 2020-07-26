package com.pubg.sensitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;


import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

public class Home extends AppCompatActivity {

    String unityGameID = "3587723";
    Boolean testMode = true;


    TextView textView;
    RelativeLayout home, netcheck;

    Animation topAnim, leftanim, rigtanim;

    Button rambutton, playerbutton, controlbutton, charbutton, aboutbutton, tryagain;


    @SuppressLint({"ClickableViewAccessibility", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        UnityAds.initialize(Home.this,unityGameID,testMode);


        //Relative layout
        home = findViewById(R.id.home);
        netcheck = findViewById(R.id.netcheck);
        //Animation
        leftanim = AnimationUtils.loadAnimation(this, R.anim.lefthome);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.up);
        rigtanim = AnimationUtils.loadAnimation(this, R.anim.righthome);

        //TextView And Buttons

        textView = findViewById(R.id.linerar2);
        rambutton = findViewById(R.id.button1);
        playerbutton = findViewById(R.id.button2);
        controlbutton = findViewById(R.id.button3);
        charbutton = findViewById(R.id.button4);
        tryagain = findViewById(R.id.tryagain);
        aboutbutton = findViewById(R.id.button5);

        //Animation set
        rambutton.setAnimation(leftanim);
        playerbutton.setAnimation(rigtanim);
        controlbutton.setAnimation(leftanim);
        charbutton.setAnimation(rigtanim);
        aboutbutton.setAnimation(leftanim);
        textView.setAnimation(topAnim);

        final TextView tv = (TextView) findViewById(R.id.welcom);
        tv.setText("Welcome");
        tv.postDelayed(new Runnable() {
            public void run() {
                tv.setVisibility(View.INVISIBLE);
            }
        }, 1200);





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


        tryagain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFF0041C2));

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {

                    v.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 000000000));

                }


                return false;
            }
        });
        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ConnectionManager.checkConnection(getBaseContext())) {
                    // disable layout
                    home.setVisibility(View.VISIBLE);
                    netcheck.setVisibility(View.INVISIBLE);
                } else {
                    // enable layout
                    home.setVisibility(View.INVISIBLE);
                    netcheck.setVisibility(View.VISIBLE);
                }


            }
        });


        if (ConnectionManager.checkConnection(getBaseContext())) {
            // disable layout
            home.setVisibility(View.VISIBLE);
            netcheck.setVisibility(View.INVISIBLE);
        } else {
            // enable layout
            home.setVisibility(View.INVISIBLE);
            netcheck.setVisibility(View.VISIBLE);
        }


    }
    }

