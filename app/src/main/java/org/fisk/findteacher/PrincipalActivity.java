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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static java.lang.System.exit;

public class PrincipalActivity extends AppCompatActivity {
    public static AlmacenDemandas almacen = new AlmacenDemandasArray();
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        new RateMyApp(this).app_launched();
        MobileAds.initialize(this, "ca-app-pub-9780467258849720~7301799432");
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("3097747E039701F659335E42352CEB71").build();
        adView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.action_salir:
                finish();
                i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                return true;

            case R.id.action_share:
                compatirTexto("Encuentra un profesor cerca de ti. ---- " +
                        "Compartido por: http://play.google.com/store/apps/details?id=" +
                        getPackageName());
                return true;

            case R.id.action_settings:
                i = new Intent(this, RegistroDatosPersonales.class);
                startActivity(i);
                //  startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //=========================================================
    public void lanzarServicios(View view) {
        Intent i = new Intent(this, ListadoPerfilesActivity.class);
        startActivity(i);
        //  startActivity(i,                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void lanzarCrearDemanda(View view) {
        Intent i = new Intent(this, ListadoCrearDemandas.class);
        startActivity(i);
        //startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void lanzarPerfil(View view) {
        Intent i = new Intent(this, ListadoGestionPerfilesActivity.class);
        startActivity(i);
        // startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void lanzarVerDemandas(View view) {
        Intent i = new Intent(this, DemandasActivity.class);
        startActivity(i);
        //startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    void compatirTexto(String texto) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, texto);
        startActivity(Intent.createChooser(i, "Selecciona aplicación"));
    }

}//fin clase