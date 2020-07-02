package com.pubg.sensitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    //variable
    Animation topAnim, bottomAnim;
    ImageView imagedown , imageup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Animation
        topAnim= AnimationUtils.loadAnimation(this,R.anim.down);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.up);

        //Hooks
        imageup = findViewById(R.id.upimage);
        imagedown = findViewById(R.id.downimage);


        imageup.setAnimation(topAnim);
        imagedown.setAnimation(bottomAnim);



        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, Home.class);
                startActivity(homeIntent);

                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}