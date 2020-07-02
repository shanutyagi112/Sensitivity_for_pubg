package com.pubg.sensitivity;

import android.webkit.WebView;

public interface MyBrowser {
    boolean shouldOverrideURLLoading(WebView view, String url);
}
