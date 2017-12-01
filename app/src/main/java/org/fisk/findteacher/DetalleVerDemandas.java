package org.fisk.findteacher;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kelvin on 9/11/2017.
 */

public class DetalleVerDemandas extends AppCompatActivity {

    ImageView imagenPrincipal;
    TextView profesion;
    TextView descripcion;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_demandas);

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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_anuncio, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {


            case R.id.mis_demandas:
                i = new Intent(this, DetalleConsultaMiDemanda.class);
                startActivity(i,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;


            case R.id.action_salir:
                finish();
                i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //=========================================================

    public void aceptar(View view){
        Toast.makeText(this, getResources().getString(R.string.servicio_aceptado), Toast.LENGTH_SHORT).show();
        Intent i= new Intent(this,PrincipalActivity.class);
        startActivity(i);
    }

    public void solicitarInformacion(View v) {


        //finish(); //Finaliza la actividad actual
        Intent i = new Intent(this, DetalleConsultaMiDemanda.class);
        startActivity(i);
    }

}
