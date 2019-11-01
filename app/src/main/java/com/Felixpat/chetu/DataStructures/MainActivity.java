package com.Felixpat.chetu.DataStructures;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private static int timeout=4000;
    ImageView imageView;
    TextView textView,name;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        name = (TextView)findViewById(R.id.name);
        imageView=(ImageView)findViewById(R.id.imageView);
        textView=(TextView)findViewById(R.id.textView);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.transition);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);
        name.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent nextActivity=new Intent(getApplicationContext() ,Notes_Activity.class);
                startActivity(nextActivity);
                finish();

             }
        },timeout);


    }
}
