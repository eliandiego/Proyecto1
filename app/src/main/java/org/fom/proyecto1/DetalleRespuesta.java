package org.fom.proyecto1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Kelvin on 9/11/2017.
 */

public class DetalleRespuesta extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta_consulta_demanda);


    }

public void respuestaEnviada(View v){

    Toast.makeText(this, getResources().getString(R.string.respuesta_dada), Toast.LENGTH_SHORT).show();
    Intent i = new Intent(this, PrincipalActivity.class);
    startActivity(i);
}


}
