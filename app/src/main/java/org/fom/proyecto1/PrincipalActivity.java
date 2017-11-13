package org.fom.proyecto1;
//FALTAN LOS NOMBRES DE LAS ACTIVIDADSE CORRECTOS

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setTitle("title vbar");

      /*  toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PrincipalActivity.this, "Atrás", Toast.LENGTH_SHORT).show();
            }
        });*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_perfiles:
                Toast.makeText(this, "Servicios de formadores", Toast.LENGTH_SHORT).show();
                /*Intent i = new Intent(this, serviciosActivity.class);
                startActivity(i);*/
                return true;

            case R.id.action_demandas:
                Toast.makeText(this, "Ver demandas ", Toast.LENGTH_SHORT).show();
                 /* Intent i = new Intent(this, datosusuarioActivity.class);
                 startActivity(i);*/
                return true;
            case R.id.action_perfil:
                Toast.makeText(this, "Gestionar perfil ", Toast.LENGTH_SHORT).show();
                 /* Intent i = new Intent(this, demandasActivity.class);
                 startActivity(i);*/
                return true;
            case R.id.action_salir:
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;

            case R.id.action_settings:
                Toast.makeText(this, "Datos de usuario ", Toast.LENGTH_SHORT).show();
                 /* Intent i = new Intent(this, perfilActivity.class);
                 startActivity(i);*/
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void action(int resid) {
        Toast.makeText(this, getText(resid), Toast.LENGTH_SHORT).show();
    }
    public void lanzarServicios(View view) {
        Toast.makeText(this, "Servicios de formadores", Toast.LENGTH_SHORT).show();
        /*Intent i = new Intent(this, serviciosActivity.class);
        startActivity(i);*/
    }
    public void lanzarDemandas(View view) {
        Toast.makeText(this, "Ver demandas ", Toast.LENGTH_SHORT).show();
       /* Intent i = new Intent(this, demandasActivity.class);
        startActivity(i);*/
    }
    public void lanzarPerfil(View view) {
        Toast.makeText(this, "Gestionar perfil ", Toast.LENGTH_SHORT).show();
       /* Intent i = new Intent(this, perfilActivity.class);
        startActivity(i);*/
    }


}//fin clase