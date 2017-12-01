package org.fom.proyecto1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kelvin on 9/11/2017.
 */

public class DetalleMiPerfilActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imagenPrincipal;
    TextView nombre;
    TextView profesion;
    TextView descripcion;
    Button btnContactar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil_detalle);

        Bundle bundle = getIntent().getExtras();
        Usuario usuario = (Usuario) bundle.getSerializable("usuario");

        imagenPrincipal = findViewById(R.id.foto_principal);
        nombre = findViewById(R.id.nombre);
        profesion = findViewById(R.id.profesion);
        descripcion = findViewById(R.id.txv_descripcion);
        btnContactar = findViewById(R.id.btn_contactar);

        imagenPrincipal.setImageResource(usuario.getResourceId());
        nombre.setText(usuario.getNombre());
        profesion.setText(usuario.getProfesion());
        descripcion.setText(usuario.getDescripcion());
        btnContactar.setOnClickListener(this);

        Log.d("User", usuario.getNombre());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_contactar:
                contactarServicio();
                break;


            default:

        }
    }

    private void contactarServicio() {



        Intent intent = new Intent(this, Perfil.class);
        intent.putExtra("add",false);
        startActivity(intent);



        finish();
    }

    public void eliminarPerfil(View v) {

        Toast.makeText(this, getResources().getString(R.string.eliminar_perfil), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, PrincipalActivity.class);

        startActivity(intent);


        finish();
    }
}
