package org.fom.proyecto1;
//LOGIN DE USUARIOS;
// NO HAY CONTROL DE USUARIOS
//CONTROLES: campos vacios, Mostrar contraseña, coge los datos de registro
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

public class LoginActivity extends AppCompatActivity {
    public Vector<String> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarios = new Vector<String>();
        usuarios.add("Ana");
        Bundle extras = getIntent().getExtras();
        String p1 = extras.getString("correo");
        String p2 = extras.getString("contraseña");
        EditText usuario = (EditText) findViewById(R.id.usuario);
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        usuario.setText(p1);
        contraseña.setText(p2);
    }

    public void mostrarContraseña(View v) {
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        CheckBox mostrar = (CheckBox) findViewById(R.id.mostrar_contraseña);
        if (mostrar.isChecked()) {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        } else {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    public void acceder(View view) {
        boolean registrado = false;
        EditText usuario = (EditText) findViewById(R.id.usuario);
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        TextView mensaje = (TextView) findViewById(R.id.mensaje);
        String u = usuario.getText().toString();
        String c = contraseña.getText().toString();
         if ((u.length() != 0) && (c.length() != 0)) {//rellenados
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.elementAt(i) == u) {
                    registrado = true;
                    break;
                }
            }
            if (registrado != true) {
                usuarios.add(usuario.getText().toString());
                Intent intent = new Intent(this, PrincipalActivity.class);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                finish();
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
