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
        AdaptadorLista adaptadorLista = new AdaptadorLista(this, personList, this);
        recyclerView.setAdapter(adaptadorLista);
    }

    private void llenardatos() {

        personList = new ArrayList<>();

        Usuario u1 = new Usuario();
        u1.setProfesion("Solicitó: Jardinera");
        u1.setResourceId(R.drawable.rostro1);
        u1.setPrecio("Estatus: Pendiente");
        u1.setDescripcion("Fecha requerida: 12/12/2017 ; Horario requerido: 10 AM  " +
                "Decripción del servicio: Necesito clases de matemáticas referente a trigonometría ");
        personList.add(u1);

        Usuario u2 = new Usuario();
        u2.setProfesion("Solicitó: Limpieza");
        u2.setResourceId(R.drawable.rostro1);
        u2.setPrecio("Estatus: Atendido");
        u2.setDescripcion("Fecha requerida: 25/12/2017 ; Horario requerido: 9 AM  " +
                "Decripción del servicio: Necesito Jardinero");
        personList.add(u2);

        Usuario u3 = new Usuario();

        u3.setProfesion("Solicitó: Conductor");
        u3.setResourceId(R.drawable.rostro1);
        u3.setPrecio("Estatus: En Proceso");
        u3.setDescripcion("Fecha requerida:31/12/2017 ; Horario requerido: 14 PM  " +
                "Decripción del servicio: Necesito un conductor");
        personList.add(u3);

        Usuario u4 = new Usuario();

        u4.setProfesion("Solicitó: Cocinera");
        u4.setResourceId(R.drawable.rostro1);
        u4.setPrecio("Estatu: Cancelado");
        u4.setDescripcion("Fecha requerida:19/12/2017 ; Horario requerido: 17 PM  " +
                "Decripción del servicio: Necesito un conductor");
        personList.add(u4);

        Usuario u5 = new Usuario();

        u5.setProfesion("Solicitó: Jardinera");
        u5.setResourceId(R.drawable.rostro1);
        u5.setPrecio("Esatus: Cancelado");
        u5.setDescripcion("Fecha requerida:21/12/2017 ; Horario requerido: 19 PM  " +
                "Decripción del servicio: Necesito un Jardinero");
        personList.add(u5);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.action_perfiles:
                i = new Intent(this, ListadoPerfilesActivity.class);
                startActivity(i,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;
            case R.id.crear_demandas:

                i = new Intent(this,ListadoCrearDemandas.class);
                startActivity(i,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;

            case R.id.action_demandas:
                i = new Intent(this, Demandas.class);
                startActivity(i,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;

            case R.id.action_perfil:
                i = new Intent(this, Perfil.class);
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

            case R.id.action_settings:
                i = new Intent(this, RegistroDatosPersonales.class);
                startActivity(i,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //=========================================================

    @Override
    public void onClickListener(Usuario usuario) {

        Intent intent = new Intent(this, DetalleVerDemanda.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
