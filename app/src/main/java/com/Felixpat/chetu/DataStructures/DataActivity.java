package com.Felixpat.chetu.DataStructures;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class DataActivity extends AppCompatActivity {

    private TextView textView;

    int chapter,no;

    String title;
    private AdView mAdView;
    String url;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

           mAdView = (AdView) findViewById(R.id.adView);
           AdRequest adRequest = new AdRequest.Builder().build();
           mAdView.loadAd(adRequest);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent in=getIntent();


        Bundle extras=in.getExtras();
        title=extras.getString("title");
        chapter=extras.getInt("unit");
        no=extras.getInt("number");


        chapter=chapter+1;
        no=no+1;

        url=Integer.toString(chapter)+"-"+Integer.toString(no);
        TextView Title=(TextView)findViewById(R.id.textView);
        Title.setText(title);

        WebView output=(WebView)findViewById(R.id.webView);
        output.getSettings().setJavaScriptEnabled(true);
        output.getSettings();
        output.setBackgroundColor(Color.parseColor("#FF303030"));
        try {
            output.loadUrl("file:///android_asset/" + url + ".html");
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_SHORT).show();
        }
        output.setWebViewClient(new WebViewClient());




        }
    }

