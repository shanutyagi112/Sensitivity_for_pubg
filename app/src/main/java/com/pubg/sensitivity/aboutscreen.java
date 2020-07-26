package com.pubg.sensitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.LightingColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class aboutscreen extends AppCompatActivity {

    RelativeLayout raterelative, feedback, privacy, description;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutscreen);



        TextView versionText = findViewById(R.id.version);

        raterelative = findViewById(R.id.raterelative);
         feedback = findViewById(R.id.feedback);
         privacy = findViewById(R.id.privacy);
         description = findViewById(R.id.description);

         try {
             PackageInfo pInfo = this.getApplicationContext().getPackageManager().getPackageInfo(this.getPackageName(),0);
             String version = pInfo.versionName;
             versionText.setText("V"+version);
         } catch (PackageManager.NameNotFoundException e) {
             e.printStackTrace();
         }


        raterelative.setOnTouchListener(new View.OnTouchListener() {
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


        raterelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateMe();
            }
        });






        privacy.setOnTouchListener(new View.OnTouchListener() {
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

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aboutscreen.this, privacy.class);
                startActivity(intent);
            }
        });








        description.setOnTouchListener(new View.OnTouchListener() {
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

        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aboutscreen.this, Description.class);
                startActivity(intent);
            }
        });


        feedback.setOnTouchListener(new View.OnTouchListener() {
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

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","shanutyagi181@gmail.com",null));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Theme of mail");
                startActivity(Intent.createChooser(intent,"Select post client"));
            }
        });


    }

    private void rateMe() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + this.getPackageName())));

        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }
}