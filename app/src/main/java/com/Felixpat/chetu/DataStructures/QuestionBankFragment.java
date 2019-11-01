package com.Felixpat.chetu.DataStructures;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionBankFragment extends Fragment {


    String url,furl;
    int place;
    WebView webView;
    Button parta,partb;

    public QuestionBankFragment(int place){
        this.place=place;
        this.place=this.place+1;
    }

    public QuestionBankFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_question_bank, container, false);



        setRetainInstance(true);

        url=Integer.toString(place);
        webView=(WebView)v.findViewById(R.id.qwebview);
        parta=(Button)v.findViewById(R.id.partA);
        partb=(Button)v.findViewById(R.id.partB);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setBackgroundColor(Color.parseColor("#303030"));

        webView.loadUrl("file:///android_asset/"+url+"-a.html");

        parta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("file:///android_asset/"+url+"-a.html");
            }
        });
        partb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("file:///android_asset/"+url+"-b.html");
            }
        });

        webView.setWebViewClient(new WebViewClient());


        return v;
    }

}
