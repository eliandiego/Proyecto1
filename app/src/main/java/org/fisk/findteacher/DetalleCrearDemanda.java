package org.fisk.findteacher;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Kelvin on 9/11/2017.
 */

public class DetalleCrearDemanda extends AppCompatActivity {
    private int x=1;

    ImageView imagenPrincipal;
    TextView profesion;
    TextView descripcion;

    private InterstitialAd interstitialAd; //anuncio Intersticial

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_demanda);

        //anuncio Intersticial
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-8547153403758959/9619838999");
        interstitialAd.loadAd(new AdRequest.Builder().addTestDevice("80E5189E21CEB5DB740CF86FFE4941CC").build());



        //fin anuncio Intersticial

        Bundle bundle = getIntent().getExtras();
        Usuario usuario = (Usuario) bundle.getSerializable("usuario");

        imagenPrincipal = findViewById(R.id.foto_principal);

        profesion = findViewById(R.id.profesion);
        descripcion = findViewById(R.id.txv_descripcion);

        imagenPrincipal.setImageResource(usuario.getResourceId());

        profesion.setText(usuario.getProfesion());
        descripcion.setText(usuario.getDescripcion());

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                interstitialAd.loadAd(new AdRequest.Builder().addTestDevice("ca-app-pub-8547153403758959/9619838999").build());

               // Log.d("anuncio","cerro anuncio" );

                Intent i = new Intent(DetalleCrearDemanda.this, PrincipalActivity.class);
                startActivity(i);
            }
        });

        //Log.d("User", usuario.getNombre());
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
                startActivity(i);
                //  startActivity(i,  ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
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

    public void demandaCreada(View v) {

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
            x=1;
           // Log.d("anuncio","salio anuncio" );
        } else {
            Toast.makeText(DetalleCrearDemanda.this, "El Anuncio no esta disponible aun", Toast.LENGTH_LONG).show();
        }

      Toast.makeText(this, getResources().getString(R.string.demanda_creada), Toast.LENGTH_SHORT).show();

    }


}
