package com.inyomanw.myapplication.models;

import java.io.Serializable;

public class Mahasiswa implements Serializable {
    long nim;
    String nama;
    String jurusan;
    String kampus;

    public Mahasiswa(long nim, String nama, String jurusan, String kampus) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.kampus = kampus;
    }

    public long getNim() {
        return nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKampus() {
        return kampus;
    }

    public void setKampus(String kampus) {
        this.kampus = kampus;
    }
}
