package org.fisk.findteacher;

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

public class ListadoVerDemandas extends AppCompatActivity implements ItemClickListener {


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
        u1.setProfesion("José");
        u1.setResourceId(R.drawable.rostro1);
        u1.setPrecio("Ver detalle");
        u1.setDescripcion("Fecha requerida: 12/12/2017 ; Horario requerido: 10 AM  " +
                "Decripción del servicio: Necesito clases de matemáticas ");
        personList.add(u1);

        Usuario u2 = new Usuario();
        u2.setProfesion("María");
        u2.setResourceId(R.drawable.rostro2);
        u2.setPrecio("Ver detalle");
        u2.setDescripcion("Fecha requerida: 25/12/2017 ; Horario requerido: 9 AM  " +
                "Decripción del servicio: Necesito Jardinero");
        personList.add(u2);

        Usuario u3 = new Usuario();

        u3.setProfesion("Pedro");
        u3.setResourceId(R.drawable.rostro3);
        u3.setPrecio("Ver Detalle");
        u3.setDescripcion("Fecha requerida:31/12/2017 ; Horario requerido: 14 PM  " +
                "Decripción del servicio: Necesito un conductor");
        personList.add(u3);

        /*   Usuario u4 = new Usuario();

        u4.setProfesion("Luis");
        u4.setResourceId(R.drawable.rostro4);
        u4.setPrecio("Ver Detalle");
        u4.setDescripcion("Fecha requerida:19/12/2017 ; Horario requerido: 17 PM  " +
                "Decripción del servicio: Necesito un conductor");
        personList.add(u4);

        Usuario u5 = new Usuario();

        u5.setProfesion("Juan");
        u5.setResourceId(R.drawable.rostro5);
        u5.setPrecio("Ver detalle");
        u5.setDescripcion("Fecha requerida:21/12/2017 ; Horario requerido: 19 PM  " +
                "Decripción del servicio: Necesito un Jardinero");
        personList.add(u5);*/
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
                startActivity(i);
              //  startActivity(i,  ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;
            case R.id.crear_demandas:

                i = new Intent(this, ListadoCrearDemandas.class);
                startActivity(i);
                //startActivity(i,ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;

            case R.id.action_demandas:
                i = new Intent(this, DemandasActivity.class);
                startActivity(i);
                //startActivity(i,                   ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;

            case R.id.action_perfil:
                i = new Intent(this, Perfil.class);
                startActivity(i);
              // startActivity(i,               ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
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
                startActivity(i);
               // startActivity(i,                  ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //=========================================================

    @Override
    public void onClickListener(Usuario usuario) {

        Intent intent = new Intent(this, DetalleVerDemandas.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
