package com.learn.nikhil.contact;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import static android.content.ContentValues.TAG;
public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Viewpagerfragment viewpagerfragment;
    String conname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        viewPager = (ViewPager) findViewById( R.id.viewPager );
        viewpagerfragment = new Viewpagerfragment( getSupportFragmentManager() );
        viewPager.setAdapter( viewpagerfragment );
        tabLayout = (TabLayout) findViewById( R.id.tabs );
        tabLayout.setupWithViewPager( viewPager );
    }
}
