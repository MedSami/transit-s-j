package com.jawaher.saida.transit_autobus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jawaher.saida.transit_autobus.Model.DataModel;

import java.util.List;

public class VoyageBusAdapter extends RecyclerView.Adapter<VoyageBusAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    public VoyageBusAdapter(List<DataModel> items, Context ctx) {
        this.items = items;
        this.ctx=ctx;


    }

    @Override
    public VoyageBusAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_voyage,viewGroup,false);
        VoyageBusAdapter.ActorViewHolder Actionview = new VoyageBusAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(VoyageBusAdapter.ActorViewHolder holder, int position) {
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

                        Intent intent = new Intent(ctx, VoyageDescription.class);
                        intent.putExtra("matricule", dm.getMatricule());
                        intent.putExtra("description", dm.getDescription());
                        ctx.startActivity(intent);


                }
            });

        }
    }

}
