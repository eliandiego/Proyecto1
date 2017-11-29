package org.fom.proyecto1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by FREDDY on 17/11/2017.
 */

public class DemandasActivity extends AppCompatActivity implements DemandaItemClickListener {

    RecyclerView lista;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demandas);

        lista = findViewById(R.id.ryv_demandas);
        configurarLista();
    }

    private void configurarLista() {

        lista.setLayoutManager(new LinearLayoutManager(this));
        DemandaAdapter adapter = new DemandaAdapter((new AlmacenDemandasArray()).listaPuntuaciones(1), this);
        lista.setAdapter(adapter);
    }

    @Override
    public void itemClickListener(int position, View view) {

        Toast.makeText(this, "text " + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void infoClickListener(String name) {

        startActivity(new Intent(this, AmpliarInfoActivity.class));
    }


    public void masinfo(View view) {

        startActivity(new Intent(this, AmpliarInfoActivity.class));
    }
    public void meinteresa(View view) {

        startActivity(new Intent(this, EnvioRespuestaPersonal.class));
    }
}