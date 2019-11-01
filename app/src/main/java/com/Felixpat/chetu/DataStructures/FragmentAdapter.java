package com.Felixpat.chetu.DataStructures;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Chetu on 21-08-2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {


    String[] titles=new String[]{"Unit-I","Unit-II","Unit-III","Unit-IV","Unit-V"};

    Context context;
    int pagecount=5;

    int type=0;

    public FragmentAdapter(FragmentManager fm,Context context,int type) {
        super(fm);
        this.context=context;
        this.type=type;
    }

    @Override
    public Fragment getItem(int position) {
        switch(type){
            case 1:
                FirstUnitFragment unitFragment=new FirstUnitFragment(position);
                return unitFragment;

            case 2:
                QuestionBankFragment questionBankFragment=new QuestionBankFragment(position);

                return questionBankFragment;


        }
       return null;
    }

    @Override
    public int getCount() {

            return pagecount;
    }

    @Override
    public CharSequence getPageTitle(int position) {


            return titles[position];


    }
}
