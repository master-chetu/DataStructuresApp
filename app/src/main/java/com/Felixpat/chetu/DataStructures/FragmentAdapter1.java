package com.Felixpat.chetu.DataStructures;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Chetu on 18-09-2017.
 */

public class FragmentAdapter1 extends FragmentPagerAdapter {

    String[] programms=new String[]{"  Lab Programms  ","Excercise Programms"};
    Context context;
    int propage=2;


    public FragmentAdapter1(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;

    }

    @Override
    public Fragment getItem(int position) {

                ProgrammsFragment programmsFragment=new ProgrammsFragment(position);

                return programmsFragment;

    }

    @Override
    public int getCount() {

            return propage;

    }

    @Override
    public CharSequence getPageTitle(int position) {


            return programms[position];



    }
}
