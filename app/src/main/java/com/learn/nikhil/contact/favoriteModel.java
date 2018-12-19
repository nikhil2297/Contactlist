package com.learn.nikhil.contact;

public class favoriteModel {
    String fav_contactname;
    String fav_contactnumber;
    String fav_contactid;
    String fav_status;

    public favoriteModel(String favname, String favnum, String id, String status) {
        this.fav_contactname = favname;
        this.fav_contactid = id;
        this.fav_contactnumber = favnum;
        this.fav_status = status;
    }

    public String getFav_contactname() {
        return fav_contactname;
    }

    public void setFav_contactname(String fav_contactname) {
        this.fav_contactname = fav_contactname;
    }

    public String getFav_contactnumber() {
        return fav_contactnumber;
    }

    public void setFav_contactnumber(String fav_contactnumber) {
        this.fav_contactnumber = fav_contactnumber;
    }

    public String getFav_contactid() {
        return fav_contactid;
    }

    public void setFav_contactid(String fav_contactid) {
        this.fav_contactid = fav_contactid;
    }

    public String getFav_status() {
        return fav_status;
    }

    public void setFav_status(String fav_status) {
        this.fav_status = fav_status;
    }
}
