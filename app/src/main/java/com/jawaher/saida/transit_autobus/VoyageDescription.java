package com.jawaher.saida.transit_autobus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VoyageDescription extends AppCompatActivity {
TextView txtTitre,txtDescription;
String Titre,Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voyage_description);
            txtTitre=findViewById(R.id.txtTitre);
            txtDescription=findViewById(R.id.txtDescription);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            Titre = data.getString("titre");
            Description = data.getString("description");
            txtTitre.setText(Titre);
            txtDescription.setText(Description);
        }

    }
}
