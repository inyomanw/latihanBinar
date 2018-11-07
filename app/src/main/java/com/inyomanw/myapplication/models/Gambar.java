package com.inyomanw.myapplication.models;

import java.io.Serializable;

public class Gambar implements Serializable {
    private String idgambar;
    private String idbarang;
    private String gambar;


    public Gambar(String idgambar, String idbarang, String gambar)
    {
        this.idgambar=idgambar;
        this.idbarang=idbarang;
        this.gambar=gambar;
    }

    public String getIdgambar() {
        return idgambar;
    }

    public void setIdgambar(String idgambar) {
        this.idgambar = idgambar;
    }

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
