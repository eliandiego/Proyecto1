package org.fisk.findteacher;
//PANTALLA DE ENTRADA

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    public static AlmacenDemandas almacen = new AlmacenDemandasArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

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

                i = new Intent(this, ListadoCrearDemandas.class);
                startActivity(i,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;

            case R.id.action_demandas:

                i = new Intent(this, DemandasActivity.class);
                startActivity(i,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;

            case R.id.action_perfil:
                i = new Intent(this, ListadoGestionPerfilesActivity.class);
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
    private void action(int resid) {
        Toast.makeText(this, getText(resid), Toast.LENGTH_SHORT).show();
    }

    public void lanzarServicios(View view) {
        Intent i = new Intent(this, ListadoPerfilesActivity.class);
        startActivity(i,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void lanzarCrearDemanda(View view) {
        Intent i = new Intent(this, ListadoCrearDemandas.class);
        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void lanzarPerfil(View view) {
        Intent i = new Intent(this, ListadoGestionPerfilesActivity.class);
        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void lanzarVerDemandas(View view) {

        Intent i = new Intent(this, DemandasActivity.class);
        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}//fin clase