package com.inyomanw.myapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Stock implements Parcelable{
    private String idStock;
    private int stock,size;

    public String getIdStock() {
        return idStock;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    protected Stock(Parcel in) {
        idStock = in.readString();
        stock = in.readInt();
        size = in.readInt();
    }

    public static final Creator<Stock> CREATOR = new Creator<Stock>() {
        @Override
        public Stock createFromParcel(Parcel in) {
            return new Stock(in);
        }

        @Override
        public Stock[] newArray(int size) {
            return new Stock[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idStock);
        parcel.writeInt(stock);
        parcel.writeInt(size);
    }
    public Stock(String idStock, int stock, int size)
    {
        this.idStock=idStock;
        this.stock=stock;
        this.size=size;
    }
}
