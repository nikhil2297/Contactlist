package com.learn.nikhil.contact;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

@SuppressLint("ValidFragment")
public class Favorite extends Fragment {
    TextView text;
    String name;
    ArrayList<favoriteModel> getfav = new ArrayList<favoriteModel>(  );
    RecyclerView favRecycler;
    favoriteAdapter fAdapter;

    public Favorite() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_favorite, container, false );
        favRecycler = (RecyclerView) view.findViewById( R.id.favoriteRecycler );
        favRecycler.setLayoutManager( new LinearLayoutManager( getContext() ) );
        return view;
    }

    public void displayRecivedData(String favname, String id, String favnum, String status) {
        if(status.equals( "true" )){
            getfav.add( new favoriteModel( favname,favnum,id, status ));

        }else{
            for (int i = 0 ;i< getfav.size();i++){
                for (int j = 0; j<getfav.size();j++){
                    String temp = getfav.get( j ).getFav_contactid();
                    if (temp.equals( id )){
                        getfav.remove( j);

                    }
                }
            }
        }
        fAdapter = new favoriteAdapter(getContext(), getfav);
        favRecycler.setAdapter( fAdapter );
    }


}
