package com.Felixpat.chetu.DataStructures;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class code extends AppCompatActivity {

    private AdView mAdView;

    int no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);


        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Intent in = getIntent();
        Bundle pass = in.getExtras();
        no = pass.getInt("no");
        WebView programmswebview = (WebView)findViewById(R.id.programmswebview);
        programmswebview.getSettings().setJavaScriptEnabled(true);
        programmswebview.getSettings();
        programmswebview.setBackgroundColor(Color.parseColor("#FF303030"));
        try {
            programmswebview.loadUrl("file:///android_asset/ds-" + no + ".html");
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();
        }
        programmswebview.setWebViewClient(new WebViewClient());


    }
}
