package com.example.toni.pruebatabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ListaHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_home);


        Toast.makeText(getApplicationContext(), "ListaHome", Toast.LENGTH_LONG ).show();
    }
}
