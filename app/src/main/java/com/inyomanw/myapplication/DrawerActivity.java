package com.inyomanw.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.inyomanw.myapplication.Adapter.BarangAdapter;
import com.inyomanw.myapplication.models.Barang;
import com.inyomanw.myapplication.models.Gambar;
import com.inyomanw.myapplication.models.SizeBarang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BarangAdapter.ItemListener {

    private static final String TAG = MainActivity.class.getName();
    RecyclerView recyclerView;
    ArrayList<Barang> baranglist;
    BarangAdapter barangAdapter;

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private final String JSON_URL = "http://inyomanw.com/WarungSepatu/api/v1/Barang";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Barang> lstBarang;
    private List<Gambar> lstGambar;
    private List<SizeBarang> lstSizeBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baranglist.add(new Barang(R.drawable.canvas_era_bw,"sd2353","Canvas Era Black White dfdgfdghtgdg","Vans",650000,"Barang Bagus bro",4));
                barangAdapter.notifyDataSetChanged();
// Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                //sendAndRequestResponse();
            }
        });

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        Button btnExit = findViewById(R.id.btnExit);
//        btnExit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppExit();
//            }
//        });

        baranglist=new ArrayList<>();
        baranglist.add(new Barang(R.drawable.slip_on_pro,"sd2353","Slip On Pro","Vans",550000,"Barang Bagus bro",4));
        baranglist.add(new Barang(R.drawable.canvas_era_bw,"sd2353","Canvas Era Black White dfdgfdghtgdg","Vans",650000,"Barang Bagus bro",4));
        baranglist.add(new Barang(R.drawable.canvas_auth_black,"sd2353","Canvas Authentic Black","Vans",750000,"Barang Bagus bro",4));
        baranglist.add(new Barang(R.drawable.canvas_era_navy,"sd2353","Canvas Era Navy","Vans",850000,"Barang Bagus bro",4));
        baranglist.add(new Barang(R.drawable.flame_os_bw,"sd2353","Flame Old Skool","Vans",1550000,"Barang Bagus bro",4));


        recyclerView = findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        barangAdapter = new BarangAdapter(DrawerActivity.this,baranglist,this);
        recyclerView.setAdapter(barangAdapter);


    }
    private void sendAndRequestResponse() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG,"Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }
//    private void loadBarangs() {
//
//        /*
//         * Creating a String Request
//         * The request type is GET defined by first parameter
//         * The URL is defined in the second parameter
//         * Then we have a Response Listener and a Error Listener
//         * In response listener we will get the JSON response as a String
//         * */
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            //converting the string to json array object
//                            JSONArray array = new JSONArray(response);
//
//                            //traversing through all the object
//
//                            for (int i = 0; i < array.length(); i++) {
//
//                                //getting product object from json array
//                                JSONObject barang = array.getJSONObject(i);
//
//                                //adding the product to product list
//                                baranglist.add(new Barang(
//                                        barang.getInt("harga") ,
//                                        barang.getString("idbarang"),
//                                        barang.getString("namabarang"),
//                                        barang.getString("merk"),
//                                        barang.getInt("harga"),
//                                        barang.getString("deskripsi"),
//                                        barang.getInt("terjual")
//                                ));
//                            }
//
//                            //creating adapter object and setting it to recyclerview
//                            adapter = new BarangAdapter(this, barangList);
//                            recyclerView.setAdapter(adapter);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//
//
//        //adding our stringrequest to queue
//        Volley.newRequestQueue(getActivity()).add(stringRequest);
//    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void AppExit()
    {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("exit", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        this.finish();
    /*int pid = android.os.Process.myPid();=====> use this if you want to kill your activity. But its not a good one to do.
    android.os.Process.killProcess(pid);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(int position) {
        Barang barang = barangAdapter.getBarangList().get(position);
        Intent intent = new Intent(DrawerActivity.this,ProdukDetailActivity.class);
        intent.putExtra("namabarang",barang.getNamabarang());

        startActivity(intent);

    }
}
