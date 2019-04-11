package com.jawaher.saida.transit_autobus.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jawaher.saida.transit_autobus.API.ApiRequest;
import com.jawaher.saida.transit_autobus.API.RetrofitServer;
import com.jawaher.saida.transit_autobus.Model.DataModel;
import com.jawaher.saida.transit_autobus.Model.ResponseDataModel;
import com.jawaher.saida.transit_autobus.R;
import com.jawaher.saida.transit_autobus.ReserverPlaces;
import com.jawaher.saida.transit_autobus.VoyageDescription;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ActorViewHolder> {
    String idClient,btnClicked;
    List<DataModel> items;
    private Context ctx;
    public ReservationAdapter(List<DataModel> items, Context ctx,String idClient,String btnClicked) {
        this.items = items;
        this.ctx=ctx;
        this.idClient=idClient;
        this.btnClicked=btnClicked;

    }

    @Override
    public ReservationAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_voyage,viewGroup,false);

        ReservationAdapter.ActorViewHolder Actionview = new ReservationAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(ReservationAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtRondonne.setText(dm.getTitre());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtRondonne;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtRondonne =  itemView.findViewById(R.id.txtRondonne);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnClicked.equals("supprimer")) {

                        AlertDialog.Builder adb = new AlertDialog.Builder(ctx);

                        adb.setTitle("Supprimer");
                        adb.setMessage("Ete vous sure de supprimer cette reservation!!");
                        adb.setIcon(android.R.drawable.ic_dialog_alert);
                        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
                                Call<ResponseDataModel> SuppReservation=api.SuppReservation(dm.getId());
                                SuppReservation.enqueue(new Callback<ResponseDataModel>() {
                                    @Override
                                    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                                        Toast.makeText(ctx, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                                        Toast.makeText(ctx, "Poblem Connexion", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        adb.show();

                    }

                }
            });

        }
    }

}
