package com.example.toni.pruebatabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TareasHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas_home);

        Toast.makeText(getApplicationContext(), "TareasHome", Toast.LENGTH_LONG ).show();
    }
}
