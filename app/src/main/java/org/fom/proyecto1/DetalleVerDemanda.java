package org.fom.proyecto1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kelvin on 9/11/2017.
 */

public class DetalleVerDemanda extends AppCompatActivity {

    ImageView imagenPrincipal;
    TextView profesion;
    TextView descripcion;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_demanda);

        Bundle bundle = getIntent().getExtras();
        Usuario usuario = (Usuario) bundle.getSerializable("usuario");

        imagenPrincipal = findViewById(R.id.foto_principal);

        profesion = findViewById(R.id.profesion);
        descripcion = findViewById(R.id.txv_descripcion);

        imagenPrincipal.setImageResource(usuario.getResourceId());

        profesion.setText(usuario.getProfesion());
        descripcion.setText(usuario.getDescripcion());

        //Log.d("User", usuario.getNombre());
    }
}
