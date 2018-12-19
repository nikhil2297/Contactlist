package com.learn.nikhil.contact;
import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class Contact extends Fragment {
    ArrayList<contactModel> getdetails = new ArrayList<contactModel>();
    RecyclerView contactrecyler;
    contactAdapter contactAdapter;

    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate( R.layout.fragment_contact, container, false );
        contactrecyler = (RecyclerView) view.findViewById( R.id.contactRecycler );
        contactrecyler.setLayoutManager( new LinearLayoutManager(getContext()));
        getContact();
        return view;
    }




    private void getContact() {
        if (ActivityCompat.checkSelfPermission( getActivity(), Manifest.permission.READ_CONTACTS ) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions( getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, 1 );

        }
        Cursor cursor_contact = null;
        ContentResolver contentResolver = getContext().getContentResolver();
        try {
            cursor_contact = contentResolver.query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC" );

        } catch (Exception ex) {
            Log.e( "Error on contact", ex.getMessage() );
        }
        if (cursor_contact.getCount() > 0) {
            while (cursor_contact.moveToNext()) {
                String contactid = cursor_contact.getString( cursor_contact.getColumnIndex( ContactsContract.CommonDataKinds.Phone._ID ) );
                String contactname = cursor_contact.getString( cursor_contact.getColumnIndex( ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME ) );

                String contactnumber = cursor_contact.getString( cursor_contact.getColumnIndex( ContactsContract.CommonDataKinds.Phone.NUMBER ) );
                Log.e( TAG, "Contact details : " + contactname + " and " + contactnumber );
                getdetails.add( new contactModel( contactid, contactname, contactnumber ) );
            }
        }

        com.learn.nikhil.contact.contactAdapter.Sendcontact sendcontact= new contactAdapter.Sendcontact() {
            @Override
            public void OnItemclicked(String favname, String id, String favnum, String status) {
                String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
                Favorite favorite = (Favorite) getActivity().getSupportFragmentManager().findFragmentByTag(tag );
                favorite.displayRecivedData(favname,id,favnum,status);
            }
        };

        contactAdapter = new contactAdapter( getContext(), getdetails, sendcontact );
        contactrecyler.setAdapter( contactAdapter );
    }

}
