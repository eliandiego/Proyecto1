package org.fom.proyecto1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by Kelvin on 21/11/2017.
 */

public class DemandaAdapter extends RecyclerView.Adapter<DemandaAdapter.ViewHolder> {

    Vector<String> demandantes;
    DemandaItemClickListener listener;

    public DemandaAdapter(Vector<String> d, DemandaItemClickListener listener) {
        demandantes = d;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demanda, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String nombre = demandantes.get(position);
        holder.bindItem(nombre, position);
    }

    @Override
    public int getItemCount() {
        return demandantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        View view;
        ImageView igvInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.demandate);
            igvInfo = itemView.findViewById(R.id.info);
            view = itemView;
        }

        void bindItem(final String nombre, final int position) {
            this.nombre.setText(nombre);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClickListener(position, view);
                }
            });

            igvInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.infoClickListener(nombre);
                }
            });
        }
    }
}
