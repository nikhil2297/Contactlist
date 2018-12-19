package com.learn.nikhil.contact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class contactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<contactModel> getdetails =new ArrayList<contactModel>(  );
    Context con;
    Boolean check = false;
    LayoutInflater layoutInflater;
    Sendcontact sendcontact;


    public contactAdapter(Context context, ArrayList<contactModel> getdetails, Sendcontact sendcontact) {
        this.con = context;
        this.getdetails = getdetails;
        this.sendcontact = sendcontact;
        layoutInflater = LayoutInflater.from( con);
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate( R.layout.contactlist, viewGroup, false );
        contactLayout layout = new contactLayout(view );
        return layout;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        contactLayout layout = (contactLayout) viewHolder;
        final contactModel details = getdetails.get( i );
        layout.contactname.setText( "  "+details.getContactname() );
        layout.contactnum.setText( "  "+details.getContactnumber() );
        layout.favcheck.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    String status = "true";
                    String id = details.contactid;
                    String favname = details.contactname;
                    String favnum = details.contactnumber;
                    if(sendcontact != null){
                        sendcontact.OnItemclicked(favname,id,favnum,status);
                    }else {
                        Log.e( TAG, "null" );
                    }
                }else{
                    String status = "false";
                    String id = details.contactid;
                    String favname = details.contactname;
                    String favnum = details.contactnumber;
                    if(sendcontact != null){
                        sendcontact.OnItemclicked(favname,id,favnum,status);
                    }else {
                        Log.e( TAG, "null" );
                    }
                }
            }
        } );


    }

    @Override
    public int getItemCount() {
        return getdetails.size();
    }

    public interface Sendcontact{
        void OnItemclicked(String favname, String id, String favnum, String status);
    }

    private class contactLayout extends RecyclerView.ViewHolder{
        TextView contactname, contactnum;
        CheckBox favcheck;
        public contactLayout(View view) {
            super(view);
            contactname = (TextView) view.findViewById( R.id.name );
            contactnum = (TextView) view.findViewById( R.id.phonenumber );
            favcheck = (CheckBox) view.findViewById( R.id.favcheck );
        }
    }
}

