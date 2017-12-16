package org.fisk.findteacher;
//REGISTRO DE USUARIOS
// NO HAY CONTROL DE USUARIOS
//CONTROLES: campos vacios, Mostrar contraseña, coge los datos de registro
//REalmente con una pantalla nos podiamos registrar/logear

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class RegistroActivity extends AppCompatActivity {
    public Vector<String> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuarios = new Vector<String>();
        usuarios.add("Ana");

        Toast.makeText(this,
                "AVISO: Esta aplicación está hecha con fines didácticos, " +
                        "y no tiene una funcionalidad completa. ", Toast.LENGTH_SHORT).show();
    }

    public void mostrarContraseña(View v) {
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        CheckBox mostrar = (CheckBox) findViewById(R.id.mostrar_contraseña);
        EditText contraseña2 = (EditText) findViewById(R.id.contraseña2);

        if (mostrar.isChecked()) {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
            contraseña2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        } else {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            contraseña2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        }
    }

    public void acceder(View view) {
        boolean registrado = false;
        EditText usuario = (EditText) findViewById(R.id.usuario);
        EditText correo = (EditText) findViewById(R.id.correo);
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        EditText contraseña2 = (EditText) findViewById(R.id.contraseña2);
        TextView mensaje = (TextView) findViewById(R.id.mensaje);

        String u = usuario.getText().toString();
        String c = correo.getText().toString();
        String pa = contraseña.getText().toString();
        String pa2 = contraseña2.getText().toString();


        if ((u.length() != 0) && (c.length() != 0) && (pa.length() != 0) && (pa2.length() != 0)) {//rellenados
            if (pa.equals(pa2)) {
                EditText p1 = (EditText) findViewById(R.id.correo);
                EditText p2 = (EditText) findViewById(R.id.contraseña);
                Intent intent = new Intent(this, LoginActivity.class);
                intent.putExtra("correo", p1.getText().toString());
                intent.putExtra("contraseña", p2.getText().toString());
                startActivity(intent);
            } else {
                mensaje.setText("Las contraseñas han de ser iguales");
            }
        } else {
                mensaje.setText(R.string.rellenatodos);
        }

    }

    public void borrarCampos(View view) {
        EditText usuario = (EditText) findViewById(R.id.usuario);
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        usuario.setText("");
        contraseña.setText("");
        usuario.requestFocus();
    }
}
