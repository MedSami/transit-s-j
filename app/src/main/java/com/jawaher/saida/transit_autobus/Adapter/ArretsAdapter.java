package com.jawaher.saida.transit_autobus.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jawaher.saida.transit_autobus.MainActivity;
import com.jawaher.saida.transit_autobus.Model.DataModel;
import com.jawaher.saida.transit_autobus.R;

import java.util.List;

public class ArretsAdapter extends RecyclerView.Adapter<ArretsAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    public ArretsAdapter(List<DataModel> items, Context ctx) {
        this.items = items;
        this.ctx=ctx;

    }

    @Override
    public ArretsAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_arrets,viewGroup,false);

        ArretsAdapter.ActorViewHolder Actionview = new ArretsAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(ArretsAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtArret.setText(" "+dm.getNom());
        holder.txtCoordonnee.setText(dm.getLongitude()+", "+dm.getLongitude());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtArret,txtCoordonnee;
        ImageView tvImage;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtArret =  itemView.findViewById(R.id.txtstation);
            txtCoordonnee =  itemView.findViewById(R.id.txtCoordonnee);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
/*
                    Uri gmmIntentUri = Uri.parse("google.streetview:cbll="+dm.getLatitude()+","+dm.getLongitude());
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    ctx.startActivity(mapIntent);*/
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr=35.6658971,10.0921316&daddr="+dm.getLatitude()+","+dm.getLongitude()));
                    ctx.startActivity(intent);


                }
            });

        }
    }


}