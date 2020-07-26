package com.pubg.sensitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class privacy extends AppCompatActivity {
    WebView view;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);


        String url = "https://docs.google.com/document/d/1rE9HkLOqDdz5Jfx7mZHRDATlK4xs6FcIRXFhQZSMpUY/edit?usp=sharing";
        WebView view = (WebView) this.findViewById(R.id.web);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
        view.setWebViewClient(new MyBrowser());
    }

    private static class  MyBrowser extends WebViewClient implements com.pubg.sensitivity.MyBrowser {
        @Override
        public boolean shouldOverrideURLLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}