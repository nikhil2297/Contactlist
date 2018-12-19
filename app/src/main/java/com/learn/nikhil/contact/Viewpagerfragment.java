package com.learn.nikhil.contact;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Viewpagerfragment extends FragmentPagerAdapter {
    String conname;
    public Viewpagerfragment(FragmentManager fm) {
        super( fm );

    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        if( i == 0){
            fragment = new Contact();
        }else if(i == 1){
            fragment = new Favorite();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String tittle = null;
        if( position == 0){
            tittle = "My Contacts";
        }else if(position == 1) {
            tittle = "Favorite";
        }
        return tittle;
    }


}
