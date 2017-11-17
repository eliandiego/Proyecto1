package org.fom.proyecto1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnvioRespuestaPersonal extends AppCompatActivity{

    Button bEnviar;
    EditText et_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envio_respuesta_personal);


        et_mensaje=(EditText) findViewById(R.id.et_respuesta);
        //Implementación del botón de envío
        bEnviar= (Button) findViewById(R.id.b_enviar);
        bEnviar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if( et_mensaje.getText().toString().equalsIgnoreCase("") ){
                    et_mensaje.setError(getResources().getString(R.string.err_campo_vacio));
                }else{
                    enviarRespuesta(null);
                }

            }
        });
    }

    public void enviarRespuesta(View v) {

        Toast.makeText(this, getResources().getString(R.string.respuesta_enviada), Toast.LENGTH_SHORT).show();
        finish(); //Finaliza la actividad actual
    }
}
