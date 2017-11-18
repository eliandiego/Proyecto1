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


/**
 * Created by Isabel María on 16/11/2017.
 */

public class RegistroDatosPersonales extends AppCompatActivity {

    Button bGuardar;
    EditText et_nombre,et_apellido,et_email,et_telefono,et_localidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_personales);

        et_nombre= (EditText) findViewById(R.id.nombre);
        et_apellido= (EditText) findViewById(R.id.apellido);
        et_email= (EditText) findViewById(R.id.email);
        et_telefono= (EditText) findViewById(R.id.telefono);
        et_localidad= (EditText) findViewById(R.id.localidad);

        //Persistencia de datos (mecanismo de Preferencias) El nombre del fichero es "datos_usuario"
        SharedPreferences prefe=getSharedPreferences("datos_usuario", Context.MODE_PRIVATE);
        et_nombre.setText(prefe.getString("nombre",""));
        et_apellido.setText(prefe.getString("apellido",""));
        et_email.setText(prefe.getString("email",""));
        et_telefono.setText(prefe.getString("telefono",""));
        et_localidad.setText(prefe.getString("localidad",""));
        //*******************************************************


        //Implementación del botón de guardado
        bGuardar= (Button) findViewById(R.id.b_guardar);
        bGuardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if( !campoObligatorioVacio(et_nombre) &&
                    !campoObligatorioVacio(et_apellido) &&
                    !campoObligatorioVacio(et_email)){

                    guardarDatos(null);
                }

            }
        });


    }

    public void guardarDatos(View v) {
        SharedPreferences preferencias=getSharedPreferences("datos_usuario",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("nombre", et_nombre.getText().toString());
        editor.putString("apellido", et_apellido.getText().toString());
        editor.putString("email", et_email.getText().toString());
        editor.putString("telefono", et_telefono.getText().toString());
        editor.putString("localidad", et_localidad.getText().toString());
        editor.apply();
        Toast.makeText(this, getResources().getString(R.string.datos_guardados), Toast.LENGTH_SHORT).show();
        finish(); //Finaliza la actividad actual

        //Pruebas Isabel: Inicia actividad de prueba, para que yo pueda probar mis cambios en el proyecto
        //Intent i = new Intent(this, PagoServicio.class);
        //startActivity(i);
    }


    public boolean campoObligatorioVacio(EditText et){
        if( et.getText().toString().equalsIgnoreCase("")) {
            //et.setHint(getResources().getString(R.string.err_campo_vacio));
            et.setError(getResources().getString(R.string.err_campo_vacio));
            return true;
        }else return false;
    }


}
