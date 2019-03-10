package com.jawaher.saida.transit_autobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jawaher.saida.transit_autobus.API.ApiRequest;
import com.jawaher.saida.transit_autobus.API.RetrofitServer;
import com.jawaher.saida.transit_autobus.Model.ResponseDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText identifiant,password;
    Button Login,btnInscrire;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        identifiant =findViewById(R.id.edtIdentifiant);
        password=findViewById(R.id.edtPassword);
        btnInscrire=findViewById(R.id.btnInscrire);
        Login=findViewById(R.id.btnLogin);
        // Spinner element
        Spinner spinner =  findViewById(R.id.spinner);


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Client");
        categories.add("Chauffeur");



        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //item = adapterView.getItemAtPosition(position).toString();
                index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnInscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Inscrire.class);
                startActivity(i);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(identifiant.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Remplir Champ Identifiant Svp", Toast.LENGTH_SHORT).show();
                }else if(password.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Remplir Champ Mot De Passe SVP", Toast.LENGTH_SHORT).show();
                }else {
                    ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
                    //Instance Call Methode
                    Call<ResponseDataModel> Login=api.Login(identifiant.getText().toString(),""+index);

                    Login.enqueue(new Callback<ResponseDataModel>() {
                        @Override
                        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {

                            if(response.isSuccessful()){
                                if(!response.body().getResult().isEmpty()) {
                                    if (response.body().getResult().get(0).getIdentifiant().equals(identifiant.getText().toString())) {
                                        if (response.body().getResult().get(0).getPassword().equals(password.getText().toString())) {

                                            if (index == 0) {

                                                Intent intent = new Intent(MainActivity.this, MenuClient.class);
                                                intent.putExtra("idClient", "" + response.body().getResult().get(0).getId());
                                                startActivity(intent);
                                            }
                                            if (index == 1) {

                                                Intent intent = new Intent(MainActivity.this, MenuChauffeur.class);
                                                intent.putExtra("idChauffeur", "" + response.body().getResult().get(0).getId());
                                                startActivity(intent);
                                            }


                                        } else {
                                            Toast.makeText(MainActivity.this, "Mot De Passe Incorrect", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {

                                        Toast.makeText(MainActivity.this, "Identifiant Incorrect", Toast.LENGTH_SHORT).show();

                                    }
                                }else {
                                    Toast.makeText(MainActivity.this, "Identifiant Incorrect", Toast.LENGTH_SHORT).show();

                                }
                            }else {
                                Toast.makeText(MainActivity.this, "Identifiant Incorrect", Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Problem Connexion", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}
