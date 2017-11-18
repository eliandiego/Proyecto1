package org.fom.proyecto1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PagoServicio extends AppCompatActivity {

    Button bPagar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pago_servicio);

        //Implementación del botón de envío
        bPagar= (Button) findViewById(R.id.b_pagar);
        bPagar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                    pagarServicio(null);


            }
        });
    }

    public void pagarServicio(View v) {

        Toast.makeText(this, getResources().getString(R.string.pago_realizado), Toast.LENGTH_SHORT).show();
        //finish(); //Finaliza la actividad actual
        Intent i = new Intent(this, PrincipalActivity.class);
        startActivity(i);
    }
}
