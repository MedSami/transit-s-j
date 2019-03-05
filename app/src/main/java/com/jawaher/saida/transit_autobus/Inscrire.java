package com.jawaher.saida.transit_autobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jawaher.saida.transit_autobus.API.ApiRequest;
import com.jawaher.saida.transit_autobus.API.RetrofitServer;
import com.jawaher.saida.transit_autobus.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inscrire extends AppCompatActivity {
EditText edtNom,edtPrenom,edtIdentifiant,edtEmail,edtPassword,edtTel;
Button btnInscrire,btnAnnuler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrire);

    edtNom=findViewById(R.id.edtNom);
    edtPrenom=findViewById(R.id.edtPrenom);
    edtIdentifiant=findViewById(R.id.edtIdentifiant);
    edtEmail=findViewById(R.id.edtEmail);
    edtPassword=findViewById(R.id.edtPassword);
    edtTel=findViewById(R.id.edtTel);
btnInscrire=findViewById(R.id.btnInscrire);
btnAnnuler=findViewById(R.id.btnAnnuler);
     btnInscrire.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            if(edtNom.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Nom SVP", Toast.LENGTH_SHORT).show();
            }else if(edtPrenom.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Prenom SVP", Toast.LENGTH_SHORT).show();
            }else if(edtIdentifiant.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Identifiant SVP", Toast.LENGTH_SHORT).show();
            }else if(edtPassword.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Mot De Passe SVP", Toast.LENGTH_SHORT).show();
            }else if(edtEmail.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Email SVP", Toast.LENGTH_SHORT).show();
            }else if(edtTel.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, " Saisir Numero Tel SVP", Toast.LENGTH_SHORT).show();
            }else if(edtTel.length() !=8){
                Toast.makeText(Inscrire.this, "Verifier Numero Tel SVP", Toast.LENGTH_SHORT).show();
            }else {
    ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
    //Instance Call Methode
    Call<ResponseDataModel> Inscription=api.Inscrire(edtNom.getText().toString(),edtPrenom.getText().toString()
    ,edtIdentifiant.getText().toString(),
            edtEmail.getText().toString(),edtPassword.getText().toString()
    ,edtTel.getText().toString());
    Inscription.enqueue(new Callback<ResponseDataModel>() {
        @Override
        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
            Toast.makeText(Inscrire.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(Call<ResponseDataModel> call, Throwable t) {
            Toast.makeText(Inscrire.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
        }
    });

}
         }
     });

     btnAnnuler.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             edtNom.setText("");
             edtPrenom.setText("");
             edtIdentifiant.setText("");
             edtPassword.setText("");
             edtEmail.setText("");
             edtTel.setText("");
         }
     });

    }
}
