package com.jawaher.saida.transit_autobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuClient extends AppCompatActivity {
Button btnConsulterVoyages,btnConsulterBus,btnReserverPlace;
String idClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_client);


        btnConsulterVoyages =findViewById(R.id.btnConsulterVoyages);
        btnConsulterBus=findViewById(R.id.btnConsulterBus);
        btnReserverPlace=findViewById(R.id.btnReserverPlace);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idClient = data.getString("idClient");
        }


        btnConsulterVoyages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuClient.this,ListVoyages.class);
                i.putExtra("btnClicked","voyage");
                i.putExtra("idClient",idClient);
                startActivity(i);
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
                Intent i=new Intent(MenuClient.this,ListVoyages.class);
                i.putExtra("btnClicked","reserver");
                i.putExtra("idClient",idClient);
                startActivity(i);
            }
        });

    }
}
