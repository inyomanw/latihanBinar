package com.inyomanw.myapplication.models;

import java.util.ArrayList;

public class Barang {
    private int gambar;
    private String idbarang;
    private String namabarang;
    private String merk;
    private String deskripsi;
    private int harga;
    private int terjual;
    private ArrayList<Gambar> listGambar;
    private ArrayList<SizeBarang> listSizeBarang;


    public Barang(){

    }
    public Barang(int gambar,String idbarang, String namabarang, String merk, int harga,String deskripsi, int terjual)
    {
        this.setGambar(gambar);
        this.setIdbarang(idbarang);
        this.setNamabarang(namabarang);
        this.setMerk(merk);
        this.setHarga(harga);
        this.setDeskripsi(deskripsi);
        this.setTerjual(terjual);
    }

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTerjual() {
        return terjual;
    }

    public void setTerjual(int terjual) {
        this.terjual = terjual;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public ArrayList<Gambar> getListGambar() {
        return listGambar;
    }

    public void setListGambar(ArrayList<Gambar> listGambar) {
        this.listGambar = listGambar;
    }

    public ArrayList<SizeBarang> getListSizeBarang() {
        return listSizeBarang;
    }

    public void setListSizeBarang(ArrayList<SizeBarang> listSizeBarang) {
        this.listSizeBarang = listSizeBarang;
    }
}

