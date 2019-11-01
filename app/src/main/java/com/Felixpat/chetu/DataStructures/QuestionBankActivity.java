package com.Felixpat.chetu.DataStructures;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class QuestionBankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tab_layout);

        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),getApplicationContext(),2));


    }
}
