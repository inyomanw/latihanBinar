package com.inyomanw.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ProdukDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_detail);

        String nama = getIntent().getStringExtra("namabarang");
        Toast.makeText(this,nama,Toast.LENGTH_SHORT).show();
        Log.d("namabarang",nama);
    }
}
