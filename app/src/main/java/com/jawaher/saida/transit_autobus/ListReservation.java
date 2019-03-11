package com.jawaher.saida.transit_autobus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jawaher.saida.transit_autobus.API.ApiRequest;
import com.jawaher.saida.transit_autobus.API.RetrofitServer;
import com.jawaher.saida.transit_autobus.Adapter.ReservationAdapter;
import com.jawaher.saida.transit_autobus.Adapter.VoyageAdapter;
import com.jawaher.saida.transit_autobus.Model.DataModel;
import com.jawaher.saida.transit_autobus.Model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListReservation extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter reservationAdapter;
String idClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_reservation);
        RecycleLayout = findViewById(R.id.recyclerview);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idClient = data.getString("idClient");
        }
        ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> getReservation=api.getReservation(idClient);

        getReservation.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();
                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(ListReservation.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    reservationAdapter = new ReservationAdapter(item, ListReservation.this,idClient);

                    RecycleLayout.setAdapter(reservationAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(ListReservation.this, "Problem Connexion", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
