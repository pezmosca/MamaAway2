package com.example.toni.pruebatabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Tutorials extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);
        try{
            JSONObject varjson = new JSONObject();
            varjson.put("fun","tuto");

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.4.180.88")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            apis service = retrofit.create(apis.class);
            Call<ServerResponseJSON> call = service.result(varjson);
            call.enqueue(new Callback<ServerResponseJSON>() {
                public void onResponse(Call<ServerResponseJSON> call, Response<ServerResponseJSON> response) {

                    Log.d("TEST JSON", response.body().getRespuesta().get(0).getIDtutorial());
                }

                @Override
                public void onFailure(Call<ServerResponseJSON> call, Throwable t) {

                }
            });
        }catch (Exception e){
            Log.v("peta esto",e.getMessage());
        }
        Toast.makeText(getApplicationContext(), "Tutorials", Toast.LENGTH_LONG ).show();
    }
}
