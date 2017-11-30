package org.fom.proyecto1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by FREDDY on 17/11/2017.
 */

public class Perfil extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_perfil);


    }

public void guardarPerfil(View v) {

        Toast.makeText(this, getResources().getString(R.string.guardar_perfil), Toast.LENGTH_SHORT).show();
        //finish(); //Finaliza la actividad actual
        Intent i = new Intent(this, PrincipalActivity.class);
        startActivity(i);
    }
    public void cancelarPerfil(View v) {

        Toast.makeText(this, getResources().getString(R.string.cancelar_perfil), Toast.LENGTH_SHORT).show();
        //finish(); //Finaliza la actividad actual
        Intent i = new Intent(this, PrincipalActivity.class);
        startActivity(i);
    }


}
