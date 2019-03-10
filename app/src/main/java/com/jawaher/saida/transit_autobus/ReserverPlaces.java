package com.jawaher.saida.transit_autobus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ReserverPlaces extends AppCompatActivity {
String idClient,idVoyage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver_places);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            idClient = data.getString("idClient");
            idVoyage = data.getString("id_voyage");
            Toast.makeText(this, idClient+"-"+idVoyage, Toast.LENGTH_SHORT).show();
        }
    }
}
