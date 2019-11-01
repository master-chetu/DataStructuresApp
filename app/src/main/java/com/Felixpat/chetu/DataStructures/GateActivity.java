package com.Felixpat.chetu.DataStructures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

public class GateActivity extends AppCompatActivity implements OnPageChangeListener,OnLoadCompleteListener {



    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String SAMPLE_FILE = "Gate.pdf";
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;
    private AdView mAdView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        pdfView= (PDFView) findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);

    }
    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .load();
    }


    @Override
    public void loadComplete(int nbPages) {



    }

    @Override
    public void onPageChanged(int page, int pageCount) {

        pageNumber = page;
        setTitle(String.format("%s %s / %s", "Gate Questions", page + 1, pageCount));
    }

}
