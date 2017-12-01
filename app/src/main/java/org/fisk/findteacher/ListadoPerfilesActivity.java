package org.fisk.findteacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListadoPerfilesActivity extends AppCompatActivity implements ItemClickListener {


    List<Usuario> personList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_perfiles);

        llenardatos();

        recyclerView = findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdaptadorListaPerfiles adaptadorListaPerfiles = new AdaptadorListaPerfiles(this, personList, this);
        recyclerView.setAdapter(adaptadorListaPerfiles);
    }

    private void llenardatos() {

        personList = new ArrayList<>();

        Usuario u5 = new Usuario();
        u5.setName("Angélica López");
        u5.setProfesion("Profesora de Matemáticas");
        u5.setResourceId(R.drawable.profesora);
        u5.setPrecio("Desde $15/hora");
        u5.setDescripcion("La profesora trabaja a medio tiempo. En sus ratos libres enseña matemáticas a personas particulares. " +
                "La profesora conoce muchas áreas como Algebra y Aritmética");
        personList.add(u5);
        Usuario u3 = new Usuario();
        u3.setName("Daniel Salinas");
        u3.setProfesion("Profesor Conducción");
        u3.setResourceId(R.drawable.driver);
        u3.setPrecio("Desde $10/hora");
        u3.setDescripcion("Su función consiste en trasladar a las personalidades o visitantes comerciales o industriales" +
                " de una empresa desde el punto de llegada, por ejemplo, el aeropuerto o estación de trenes, hasta el lugar de destino, " +
                "por ejemplo, las instalaciones de la compañía. El chófer espera a sus clientes en un lugar acordado");
        personList.add(u3);

        Usuario u4 = new Usuario();
        u4.setName("Alex Martinez");
        u4.setProfesion("Profesor de Cocina");
        u4.setResourceId(R.drawable.cocinero);
        u4.setPrecio("Desde $50/hora");
        u4.setDescripcion("Conoce con propiedad los productos, la administración, la contabilidad, el derecho, la nutrición, " +
                "la enología, los costeos, la química, la historia y la geografía, entre otros muchos elementos. ");
        personList.add(u4);


        Usuario u2 = new Usuario();
        u2.setName("Ana María Ruiz");
        u2.setProfesion("Profesora Jardinería");
        u2.setResourceId(R.drawable.gardener);
        u2.setPrecio("Desde $15/hora");
        u2.setDescripcion("Se dedica al cuidado de plantas como flores, arbustos, árboles y césped. " +
                "Pueden trabajar en un parque, reserva natural, parque público o privado, en rotondas de carretera, en campos de deportes," +
                " o en áreas verdes de edificios de oficinas de, por ejemplo.");
        personList.add(u2);

        Usuario u1 = new Usuario();
        u1.setName("Fortu Pérez");
        u1.setProfesion("Profesor mantenimiento");
        u1.setResourceId(R.drawable.cleaner);
        u1.setPrecio("Desde $20/hora");
        u1.setDescripcion("Se ocupa de la limpieza y mantenimiento de inmuebles. " +
                "Para ello, emplea los productos y la maquinarias más adecuados y respeta las normas de utilización. ");
        personList.add(u1);


    }

    @Override
    public void onClickListener(Usuario usuario) {

        Intent intent = new Intent(this, DetalleUsuarioActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
