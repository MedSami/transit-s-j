package com.jawaher.saida.transit_autobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jawaher.saida.transit_autobus.API.ApiRequest;
import com.jawaher.saida.transit_autobus.API.RetrofitServer;
import com.jawaher.saida.transit_autobus.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReserverPlaces extends AppCompatActivity {
String idClient,idVoyage;
Button btnAjouter,btnConsulter,btnReserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver_places);
        btnAjouter=findViewById(R.id.btnAjouter);
        btnConsulter=findViewById(R.id.btnConsulter);
        btnReserver=findViewById(R.id.btnSupprimer);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idClient = data.getString("id_client");
            idVoyage = data.getString("id_voyage");
        }
btnAjouter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
        //Instance Call Methode
        Call<ResponseDataModel> Resevation=api.Reservation(idClient,idVoyage);

        Resevation.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                Toast.makeText(ReserverPlaces.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(ReserverPlaces.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
});
btnConsulter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(ReserverPlaces.this,ListReservation.class);
        i.putExtra("idClient",idClient);
        startActivity(i);
    }
});
    }
}
