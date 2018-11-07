package com.inyomanw.myapplication.models;

public class SizeBarang {
    private String idsizebarang;
    private String idbarang;
    private int size;
    private int stock;


    public SizeBarang(){}
    public SizeBarang(String idsizebarang, String idbarang, int size, int stock)
    {
        this.setIdsizebarang(idsizebarang);
        this.setIdbarang(idbarang);
        this.setSize(size);
        this.setStock(stock);
    }

    public String getIdsizebarang() {
        return idsizebarang;
    }

    public void setIdsizebarang(String idsizebarang) {
        this.idsizebarang = idsizebarang;
    }

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
