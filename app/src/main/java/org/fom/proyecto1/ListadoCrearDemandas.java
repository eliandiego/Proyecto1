package org.fom.proyecto1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        AdaptadorLista adaptadorLista = new AdaptadorLista(this, personList, this);
        recyclerView.setAdapter(adaptadorLista);
    }

    private void llenardatos() {

        personList = new ArrayList<>();

        Usuario u1 = new Usuario();
        u1.setProfesion("Personal de limpieza");
        u1.setResourceId(R.drawable.cleaner);
        u1.setDescripcion("Se ocupa de la limpieza y mantenimiento de inmuebles. " +
                "Para ello, emplea los productos y la maquinarias más adecuados y respeta las normas de utilización. ");
        personList.add(u1);

        Usuario u2 = new Usuario();
        u2.setProfesion("Jardinera");
        u2.setResourceId(R.drawable.gardener);
        u2.setDescripcion("Se dedica al cuidado de plantas como flores, arbustos, árboles y césped. " +
                "Pueden trabajar en un parque, reserva natural, parque público o privado, en rotondas de carretera, en campos de deportes," +
                " o en áreas verdes de edificios de oficinas de, por ejemplo.");
        personList.add(u2);

        Usuario u3 = new Usuario();

        u3.setProfesion("Conductor");
        u3.setResourceId(R.drawable.driver);
        u3.setDescripcion("Su función consiste en trasladar a las personalidades o visitantes comerciales o industriales" +
                " de una empresa desde el punto de llegada, por ejemplo, el aeropuerto o estación de trenes, hasta el lugar de destino, " +
                "por ejemplo, las instalaciones de la compañía. El chófer espera a sus clientes en un lugar acordado");
        personList.add(u3);

        Usuario u4 = new Usuario();

        u4.setProfesion("Cocinero");
        u4.setResourceId(R.drawable.cocinero);
        u4.setDescripcion("Conoce con propiedad los productos, la administración, la contabilidad, el derecho, la nutrición, " +
                "la enología, los costeos, la química, la historia y la geografía, entre otros muchos elementos. ");
        personList.add(u4);

        Usuario u5 = new Usuario();

        u5.setProfesion("Profesora de Matemática");
        u5.setResourceId(R.drawable.profesora);
        u5.setDescripcion("La profesora trabaja a medio tiempo. En sus ratos libres enseña matemáticas a personas particulares. " +
                "La profesora conoce muchas áreas como Algebra y Aritmética");
        personList.add(u5);
    }

    @Override
    public void onClickListener(Usuario usuario) {

        Intent intent = new Intent(this, DetalleCrearDemanda.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
