package org.fom.proyecto1;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kelvin on 8/11/2017.
 */

public class AdaptadorListaPerfiles extends RecyclerView.Adapter<AdaptadorListaPerfiles.ViewHolder> {

    private LayoutInflater inflador;
    private List<Usuario> usuarios;
    private ItemClickListener itemClickListener;
    private Context context;

    public AdaptadorListaPerfiles(Context context, List<Usuario> usuarios, ItemClickListener itemClickListener) {

        inflador = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.context = context;
        this.usuarios = usuarios;
        this.itemClickListener = itemClickListener;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflador.inflate(R.layout.item_lista_perfil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Usuario usuario = usuarios.get(position);
        holder.bindUsuario(usuario);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txvNombre;
        ImageView imagenUsuario;
        TextView txvPrecio;
        TextView txvProfesion;
        View view;


        public ViewHolder(View itemView) {
            super(itemView);

            txvNombre = itemView.findViewById(R.id.txv_nombre);
            imagenUsuario = itemView.findViewById(R.id.igv_foto);
            txvPrecio = itemView.findViewById(R.id.precio);
            txvProfesion = itemView.findViewById(R.id.txv_profesion);
            view = itemView;
        }

        public void bindUsuario(final Usuario usuario) {

            txvNombre.setText(usuario.getNombre());
            imagenUsuario.setImageDrawable(ContextCompat.getDrawable(context, usuario.getResourceId()));
            txvPrecio.setText(usuario.getPrecio());
            txvProfesion.setText(usuario.getProfesion());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClickListener(usuario);
                }
            });
        }
    }
}
