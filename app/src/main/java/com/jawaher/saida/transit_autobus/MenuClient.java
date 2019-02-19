package com.jawaher.saida.transit_autobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuClient extends AppCompatActivity {
Button btnGererPlace,btnConsulterStation,btnConsulterBus,btnReserverPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_client);

        btnGererPlace=findViewById(R.id.btnGererPlace);
        btnConsulterStation=findViewById(R.id.btnConsulterStation);
        btnConsulterBus=findViewById(R.id.btnConsulterBus);
        btnReserverPlace=findViewById(R.id.btnReserverPlace);

        btnGererPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuClient.this,GererPlaces.class);
                startActivity(i);
            }
        });


        btnConsulterStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnConsulterBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnReserverPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuClient.this,ReserverPlaces.class);
                startActivity(i);
            }
        });

    }
}
