package com.jawaher.saida.transit_autobus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jawaher.saida.transit_autobus.API.ApiRequest;
import com.jawaher.saida.transit_autobus.API.RetrofitServer;
import com.jawaher.saida.transit_autobus.Adapter.VoyageAdapter;
import com.jawaher.saida.transit_autobus.Model.DataModel;
import com.jawaher.saida.transit_autobus.Model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListVoyageBus extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter voyageBusAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_voyage_bus);
        RecycleLayout = findViewById(R.id.recyclerview);


        ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> getVoyageBus=api.getVoyageBus();

    getVoyageBus.enqueue(new Callback<ResponseDataModel>() {
        @Override
        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {

            String code = response.body().getCode();
            List<DataModel> item = response.body().getResult();
            if (code.equals("1")) {
                RecycleManager = new LinearLayoutManager(ListVoyageBus.this, LinearLayoutManager.VERTICAL, false);

                RecycleLayout.setLayoutManager(RecycleManager);

                voyageBusAdapter = new VoyageBusAdapter(item, ListVoyageBus.this);

                RecycleLayout.setAdapter(voyageBusAdapter);
            }
        }

        @Override
        public void onFailure(Call<ResponseDataModel> call, Throwable t) {
            Toast.makeText(ListVoyageBus.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
        }
    });
    }
}
