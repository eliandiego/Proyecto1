package org.fisk.findteacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class ListadoGestionPerfilesActivity extends AppCompatActivity implements ItemClickListener {


    List<Usuario> personList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenedor_mis_perfiles);
        //setContentView(R.layout.activity_main_mis_perfiles);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                addPerfil(null);
            }
        });

        ImageButton volver = findViewById(R.id.b_volver);
        volver.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                volverAPrincipal(null);
            }
        });



        llenardatos();

        recyclerView = findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdaptadorListaPerfiles adaptadorListaPerfiles = new AdaptadorListaPerfiles(this, personList, this);
        recyclerView.setAdapter(adaptadorListaPerfiles);
    }

    private void llenardatos() {

        personList = new ArrayList<>();

        Usuario u1 = new Usuario();
        u1.setName("Fortu Pérez");
        u1.setProfesion("Personal de limpieza");
        u1.setResourceId(R.drawable.cleaner);
        u1.setPrecio("Desde $20");
        u1.setDescripcion("Se ocupa de la limpieza y mantenimiento de inmuebles. " +
                "Para ello, emplea los productos y la maquinarias más adecuados y respeta las normas de utilización. ");
        personList.add(u1);

        Usuario u2 = new Usuario();
        u2.setName("Fortu Pérez");
        u2.setProfesion("Jardinera");
        u2.setResourceId(R.drawable.gardener);
        u2.setPrecio("Desde $15");
        u2.setDescripcion("Se dedica al cuidado de plantas como flores, arbustos, árboles y césped. " +
                "Pueden trabajar en un parque, reserva natural, parque público o privado, en rotondas de carretera, en campos de deportes," +
                " o en áreas verdes de edificios de oficinas de, por ejemplo.");
        personList.add(u2);


    }

    @Override
    public void onClickListener(Usuario usuario) {

        Intent intent = new Intent(this, DetalleMiPerfilActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

    public void addPerfil(View view){
        Intent i = new Intent(this, Perfil.class);
        i.putExtra("add",true);
        startActivity(i);

    }

    public void volverAPrincipal(View view){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
}
