package com.inyomanw.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.inyomanw.myapplication.models.Mahasiswa;
import com.inyomanw.myapplication.models.Stock;

import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Bundle bundle = getIntent().getExtras();
//        NamaModel namamodel = bundle.getParcelable("model_area"); cara getdata parsing bundle

//        Namamodel areamodel = getIntent().getParcelableExtra("model_area");
//        areamodel.getID(); cara getdata parsing intent.
//        areamodel.get.....();
        //String nama = getIntent().getStringExtra(Constant.IntentKey.namaKey);

        Mahasiswa mahasiswa = (Mahasiswa) getIntent().getSerializableExtra(Constant.IntentKey.mahasiswa);
        //Mahasiswa mhs = (Mahasiswa) bundle.getSerializable(Constant.IntentKey.mahasiswa);
        Log.d("Mahasiswa Serializable:", mahasiswa.getNama());


        Stock stock = getIntent().getParcelableExtra(Constant.IntentKey.keyStock);
        //Stock stok = bundle.getParcelable(Constant.IntentKey.keyStock);
        Log.d("STOCK Parcelable:",stock.getIdStock());



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() !=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent i = new Intent(ScrollingActivity.this,DrawerActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
