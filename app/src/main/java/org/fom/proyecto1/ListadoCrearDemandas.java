package org.fom.proyecto1;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ListadoCrearDemandas extends AppCompatActivity implements ItemClickListener {


    List<Usuario> personList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_perfiles);

        llenardatos();

        recyclerView = findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdaptadorListaPerfiles adaptadorLista =
                new AdaptadorListaPerfiles(this, personList, this);
        recyclerView.setAdapter(adaptadorLista);
    }

    private void llenardatos() {

        personList = new ArrayList<>();

        Usuario u5 = new Usuario();
        u5.setProfesion("Un Profesora de Matemáticas");
        u5.setResourceId(R.drawable.profesora);
        u5.setDescripcion("");
        personList.add(u5);


        Usuario u3 = new Usuario();
        u3.setProfesion("Un  Profesor de Conducción");
        u3.setResourceId(R.drawable.driver);
        u3.setDescripcion("");
        personList.add(u3);

        Usuario u4 = new Usuario();
        u4.setProfesion("Un Profesor de Cocina");
        u4.setResourceId(R.drawable.cocinero);
        u4.setDescripcion("");
        personList.add(u4);

               Usuario u2 = new Usuario();
        u2.setProfesion("Un Profesor de Jardinería");
        u2.setResourceId(R.drawable.gardener);
        u2.setDescripcion("");
        personList.add(u2);
        Usuario u1 = new Usuario();

        u1.setProfesion("Un Especialista mantenimiento");
        u1.setResourceId(R.drawable.cleaner);
        u1.setDescripcion("");
        personList.add(u1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_crear_demanda, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {


            case R.id.mis_demandas:
                i = new Intent(this, ListadoVerMisDemandas.class);
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

    @Override
    public void onClickListener(Usuario usuario) {

        Intent intent = new Intent(this, DetalleCrearDemanda.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
