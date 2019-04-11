package com.jawaher.saida.transit_autobus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BusDescription extends AppCompatActivity {
TextView txtMatricule,txtDescription;
String matricule,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_description);
    txtDescription=findViewById(R.id.txtDescription);
    txtMatricule=findViewById(R.id.txtMatricule);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            matricule = data.getString("matricule");
            description = data.getString("description");

        txtMatricule.setText("Matricule : "+matricule);
        txtDescription.setText(description);
        }

    }
}
