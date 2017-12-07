package org.fisk.findteacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListadoVerMisDemandas extends AppCompatActivity implements ItemClickListener {


    List<Usuario> personList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_perfiles);

        llenardatos();

        recyclerView = findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdaptadorListaPerfiles adaptadorLista = new AdaptadorListaPerfiles(this, personList, this);
        recyclerView.setAdapter(adaptadorLista);
    }

    private void llenardatos() {

        personList = new ArrayList<>();

        Usuario u1 = new Usuario();
        u1.setProfesion("Solicitado: Profesor de Matemáticas");
        u1.setResourceId(R.drawable.fotodemandante3);
        u1.setPrecio("Estado: PENDIENTE");
        u1.setDescripcion("Fecha requerida: 12/12/2017; Horario requerido: 10 AM  " +
                "Descripción del servicio: Necesito clases de matemáticas referente a trigonometría ");
        personList.add(u1);

        Usuario u2 = new Usuario();
        u2.setProfesion("Solicitado: Jardinera");
        u2.setResourceId(R.drawable.fotodemandante3);
        u2.setPrecio("EStado: ACEPTADA");
        u2.setDescripcion("Fecha requerida: 25/12/2017; Horario requerido: 9 AM  " +
                "Descripción del servicio: Necesito Jardinero/a");
        personList.add(u2);

      Usuario u3 = new Usuario();

        u3.setProfesion("Solicitado: Conductor");
        u3.setResourceId(R.drawable.fotodemandante3);
        u3.setPrecio("Estado: EN PROCESO");
        u3.setDescripcion("Fecha requerida: 31/12/2017; Horario requerido: 14 PM  " +
                "Descripción del servicio: Necesito un conductor/a");
        personList.add(u3);

      /*  Usuario u4 = new Usuario();

        u4.setProfesion("Solicitado: Conductor");
        u4.setResourceId(R.drawable.rostro1);
        u4.setPrecio("Estado: CANCELADO");
        u4.setDescripcion("Fecha requerida: 19/12/2017; Horario requerido: 17 PM  " +
                "Descripción del servicio: Necesito un conductor/a");
        personList.add(u4);

        Usuario u5 = new Usuario();

        u5.setProfesion("Solicitado: Jardinera");
        u5.setResourceId(R.drawable.rostro1);
        u5.setPrecio("Estado: CANCELADO");
        u5.setDescripcion("Fecha requerida: 21/12/2017; Horario requerido: 19 PM  " +
                "Descripción del servicio: Necesito un Jardinero/a");
        personList.add(u5);*/
    }




    //=========================================================

    @Override
    public void onClickListener(Usuario usuario) {

        Intent intent = new Intent(this, DetalleVerDemanda.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
