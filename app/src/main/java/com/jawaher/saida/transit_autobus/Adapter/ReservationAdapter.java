package com.jawaher.saida.transit_autobus.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jawaher.saida.transit_autobus.Model.DataModel;
import com.jawaher.saida.transit_autobus.R;
import com.jawaher.saida.transit_autobus.ReserverPlaces;
import com.jawaher.saida.transit_autobus.VoyageDescription;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ActorViewHolder> {
    String idClient;
    List<DataModel> items;
    private Context ctx;
    public ReservationAdapter(List<DataModel> items, Context ctx,String idClient) {
        this.items = items;
        this.ctx=ctx;
        this.idClient=idClient;


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
                   /* if(btnClicked.equals("voyage")) {
                        Intent intent = new Intent(ctx, VoyageDescription.class);
                        intent.putExtra("titre", dm.getTitre());
                        intent.putExtra("description", dm.getDescription());
                        ctx.startActivity(intent);
                    }else {
                        Intent intent = new Intent(ctx, ReserverPlaces.class);
                        intent.putExtra("id_voyage", dm.getId());
                        intent.putExtra("id_client", idClient);
                        ctx.startActivity(intent);
                    }*/

                }
            });

        }
    }

}
