package com.example.toni.pruebatabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AvisoHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso_home);

        Toast.makeText(getApplicationContext(), "AvisoHome", Toast.LENGTH_LONG ).show();
    }
}
