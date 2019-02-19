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

public class MainActivity extends AppCompatActivity {
    EditText identifiant,password;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        identifiant =findViewById(R.id.edtIdentifiant);
        password=findViewById(R.id.edtPassword);
        Login=findViewById(R.id.btnLogin);

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
                    Call<ResponseDataModel> Login=api.Login(identifiant.getText().toString());

                    Login.enqueue(new Callback<ResponseDataModel>() {
                        @Override
                        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {

                            if(response.isSuccessful()){
                                if(response.body().getResult().get(0).getIdentifiant().equals(identifiant.getText().toString())){
                                    if(response.body().getResult().get(0).getPassword().equals(password.getText().toString())){

                                        if(response.body().getResult().get(0).getType().equals("2")){

                                            Intent intent=new Intent(MainActivity.this,MenuClient.class);
                                            intent.putExtra("idUtilisateur",""+response.body().getResult().get(0).getId());
                                            startActivity(intent);
                                        }
                                        if(response.body().getResult().get(0).getType().equals("3")){

                                            Intent intent=new Intent(MainActivity.this,MenuChauffeur.class);
                                            intent.putExtra("idUtilisateur",""+response.body().getResult().get(0).getId());
                                            startActivity(intent);
                                        }




                                    }else {
                                        Toast.makeText(MainActivity.this, "Mot De Passe Incorrect", Toast.LENGTH_SHORT).show();
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
