package org.fisk.findteacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by FREDDY on 17/11/2017.
 * Modified by Isabel on 30/11/2017
 */

public class Perfil extends AppCompatActivity {

    Button b_guardar, b_eliminar;
    TextView titulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_perfil2);

        b_eliminar=  findViewById(R.id.b_eliminar);
        titulo= findViewById(R.id.tv_tit_gestion_perfil);
        if(getIntent().getExtras().getBoolean("add")==true){
            //b_eliminar.setVisibility(View.GONE);
            titulo.setText(getResources().getString(R.string.nuevo_perfil));
        }else{
            titulo.setText(getResources().getString(R.string.tit_gestion_perfil));
        }

        //Implementación del botón de guardado del perfil
        b_guardar= findViewById(R.id.b_guardar);
        b_guardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                guardarPerfil(null);
            }
        });


        //Implementación del botón de eliminación del perfil

        b_eliminar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                cancelarPerfil(null);
            }
        });




    }

public void guardarPerfil(View v) {

        Toast.makeText(this, getResources().getString(R.string.guardar_perfil), Toast.LENGTH_SHORT).show();
        //finish(); //Finaliza la actividad actual
        Intent i = new Intent(this, ListadoGestionPerfilesActivity.class);
        startActivity(i);
    }
    public void cancelarPerfil(View v) {

        Toast.makeText(this, getResources().getString(R.string.cancelar_perfil), Toast.LENGTH_SHORT).show();
        //finish(); //Finaliza la actividad actual
        Intent i = new Intent(this, ListadoGestionPerfilesActivity.class);
        startActivity(i);
    }


}
