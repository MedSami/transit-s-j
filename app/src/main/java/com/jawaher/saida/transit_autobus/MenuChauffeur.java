package com.jawaher.saida.transit_autobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuChauffeur extends AppCompatActivity {
Button btnArrets;
String idChauffeur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_chauffeur);
    btnArrets=findViewById(R.id.btnGererArrets);


        Bundle data = getIntent().getExtras();
        if (data != null) {
            idChauffeur = data.getString("idUtilisateur");

        }

    btnArrets.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(MenuChauffeur.this,ListArrets.class);
            i.putExtra("idChauffeur",idChauffeur);
            startActivity(i);
        }
    });

    }
}
