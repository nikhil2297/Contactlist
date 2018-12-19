package com.learn.nikhil.contact;

public class contactModel {

    String contactname;
    String contactnumber;
    String contactid;

    public contactModel(String contactid, String contactname, String contactnumber) {
        this.contactid = contactid;
        this.contactname = contactname;
        this.contactnumber = contactnumber;
    }

    public String getContactid() {
        return contactid;
    }

    public void setContactid(String contactid) {
        this.contactid = contactid;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

}
