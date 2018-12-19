package com.learn.nikhil.contact;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class favoriteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<favoriteModel> getfav = new ArrayList<favoriteModel>(  );
    LayoutInflater layoutInflater;
    public favoriteAdapter(Context context, ArrayList<favoriteModel> getfav) {
        this.context = context;
        this.getfav = getfav;
        layoutInflater = LayoutInflater.from( context );
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate( R.layout.favorite_list, viewGroup, false );
        favoritelayout layout = new favoritelayout(view );
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        favoritelayout layout = (favoritelayout) viewHolder;
        favoriteModel fav_details = getfav.get( i );
        String flag = fav_details.getFav_status();
        String id = fav_details.getFav_contactid();
        String tempname = fav_details.getFav_contactname();

        layout.contactnum.setText( "   " + fav_details.getFav_contactnumber() );
        layout.contactname.setText( "   " + fav_details.getFav_contactname() );
        if (flag.equals( "false" )){
            Toast.makeText( context, "hello", Toast.LENGTH_SHORT ).show();
            for (int k = 0 ;k< getfav.size();k++){
                for (int j = 0; j<getfav.size();j++){
                    String temp = getfav.get( j ).getFav_contactid();
                    if (temp.equals( id )){
                        getfav.remove( temp );
                        getfav.remove( getfav.get( j ).getFav_contactname() );
                        getfav.remove( getfav.get( j ).getFav_contactnumber() );

                    }
                }
            }

        }
    }


    @Override
    public int getItemCount() {
        return getfav.size();
    }

    private class favoritelayout extends RecyclerView.ViewHolder {
        TextView contactname, contactnum;
        public favoritelayout(View view) {
            super(view);
            contactname = (TextView) view.findViewById( R.id.fav_name );
            contactnum = (TextView) view.findViewById( R.id.fav_phonenumber );
        }
    }
}
