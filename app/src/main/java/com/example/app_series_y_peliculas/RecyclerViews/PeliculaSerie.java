package com.example.app_series_y_peliculas.RecyclerViews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PeliculaSerie {
    public String color;
    public String nombrepeli;
    public String status;
    public  String tipopeli;
    public ArrayList<String> genre;

    public PeliculaSerie(String color, String nombrepeli, String status, String tipopeli/*String genre*/) {
        this.color = color;
        this.nombrepeli = nombrepeli;
        this.status = status;
        this.tipopeli = tipopeli;

       // this.genre = getGenreFronNum(genre);
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombrepeli() {
        return nombrepeli;
    }

    public void setNombrepeli(String nombrepeli) {
        this.nombrepeli = nombrepeli;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipopeli() {
        return tipopeli;
    }

    public void setTipopeli(String tipopeli) {
        this.tipopeli = tipopeli;
    }


    public ArrayList<String> getGenreFronNum(String num){

        Map<String,String> mapa= new HashMap<>();
        mapa.put("28","");
        mapa.put("14","");
        mapa.put("12","");

        //genre = mapa.get(num);
        return genre;
    }
}
