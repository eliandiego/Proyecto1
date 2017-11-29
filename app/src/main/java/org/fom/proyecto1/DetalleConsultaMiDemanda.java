package org.fom.proyecto1;

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

public class DetalleConsultaMiDemanda extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_demanda);


    }

public void respuestaDemandante(View v){

    Intent i = new Intent(this, DetalleRespuesta.class);
    startActivity(i);
}


}
