package com.jawaher.saida.transit_autobus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jawaher.saida.transit_autobus.API.ApiRequest;
import com.jawaher.saida.transit_autobus.API.RetrofitServer;
import com.jawaher.saida.transit_autobus.Adapter.ArretsAdapter;
import com.jawaher.saida.transit_autobus.Model.DataModel;
import com.jawaher.saida.transit_autobus.Model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListArrets extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter arretsAdapter;
    String idChauffeur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_arrets);
        RecycleLayout = findViewById(R.id.recyclerView);


        Bundle data = getIntent().getExtras();
        if (data != null) {
            idChauffeur = data.getString("idChauffeur");

        }

        ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> getArrets=api.getArrets(idChauffeur);

        getArrets.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();
                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(ListArrets.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    arretsAdapter = new ArretsAdapter(item, ListArrets.this);

                    RecycleLayout.setAdapter(arretsAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(ListArrets.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
