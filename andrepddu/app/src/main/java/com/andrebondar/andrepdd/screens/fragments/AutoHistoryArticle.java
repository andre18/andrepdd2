package com.andrebondar.andrepdd.screens.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.andrebondar.andrepdd.Constants;
import com.andrebondar.andrepdd.R;

/**
 * Created by Andre on 03.03.2017.
 */

public class AutoHistoryArticle extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.auto_history_text, null);

        Bundle bundle = getArguments();
        int currentCardView = bundle.getInt(Constants.CURRENT_CARD_VIEW);

        WebView webView = (WebView) v.findViewById(R.id.auto_history_text_web_view);
        webView.getSettings().setLoadsImagesAutomatically(true);

        if (currentCardView == 0) {
            webView.loadUrl("file:///android_asset/first.html");
        }
        if (currentCardView == 1) {
            webView.loadUrl("file:///android_asset/second.html");
        }
        if (currentCardView == 2) {
            webView.loadUrl("file:///android_asset/third.html");
        }
        if (currentCardView == 3) {
            webView.loadUrl("file:///android_asset/fourth.html");
        }
        if (currentCardView == 4) {
            webView.loadUrl("file:///android_asset/fifth.html");
        }
        if (currentCardView == 5) {
            webView.loadUrl("file:///android_asset/sixth.html");
        }

        return v;
    }
}
