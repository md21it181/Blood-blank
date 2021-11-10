package com.myapp.idonor.donor_list;

public class Donor_Data {
    String bg,number,city,state,name;

    public Donor_Data(String bg, String number, String city, String name) {
        this.bg = bg;
        this.number = number;
        this.city = city;

        this.name = name;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
