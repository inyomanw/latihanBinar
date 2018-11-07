package com.inyomanw.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.inyomanw.myapplication.models.Gambar;
import com.inyomanw.myapplication.models.Mahasiswa;
import com.inyomanw.myapplication.models.Stock;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView txtEmail, txtPassword;
    Button btnLogin,btnMaps, btnYoutube, btnTest;

    private static final  String TAG = "MapsActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail=findViewById(R.id.txtEmail);
        txtPassword=findViewById(R.id.txtPassword);
        btnLogin =findViewById(R.id.btnLogin);
        btnYoutube = findViewById(R.id.btn_youtube);

        btnTest = findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String a = "rhandy";
                if(email.equals(a))
                {
                    Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this,email+"   gagal",Toast.LENGTH_SHORT).show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ScrollingActivity.class);
                //intent.putExtra(Constant.IntentKey.namaKey,"nyoman");
                Bundle bundle = new Bundle();
                //bundle.putSerializable("model_area",namamodel); cara menggunakan bundle u/ parsing data antar activity
                //i.putExtra("model_area",namamodel); dengan cara intent parsing objek kelas

                //Serializable
                Mahasiswa mahasiswa = new Mahasiswa(1234,"Ridho","asdasdf","UII");
                bundle.putSerializable(Constant.IntentKey.mahasiswa,mahasiswa);
                intent.putExtra(Constant.IntentKey.mahasiswa,mahasiswa);

                //Parcelable
                Stock stock = new Stock("STOCK", 1, 43);
                bundle.putParcelable(Constant.IntentKey.keyStock,stock);
                intent.putExtra(Constant.IntentKey.keyStock,stock);

//                Bundle bundle = new Bundle();
//                bundle.putSerializable(Constant.IntentKey.keyGambar, gambar);
//                intent.putExtra(Constant.IntentKey.keyGambar,gambar);


                startActivity(intent);
            }
        });
        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,YoutubeActivity.class);
                startActivity(intent);
            }
        });

        if(isServicesOK())
        {
            init();
        }

        isExit();
    }

    private void isExit() {
        boolean exit = getIntent().getBooleanExtra("exit", false);
        if (exit) finish();
    }

    private void init(){
        btnMaps = findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean isServicesOK(){
        Log.d(TAG,"isServiceOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map request
            Log.d(TAG,"isServiceOK: Google Play Service is Working");
            return true;
        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(available))
        {
            //an error occured but we can resolve it
            Log.d(TAG,"isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else
        {
            Toast.makeText(this,"You can't make map request ",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
