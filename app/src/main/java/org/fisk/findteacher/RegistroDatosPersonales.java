package org.fisk.findteacher;

import android.*;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;


/**
 * Created by Isabel María on 16/11/2017.
 */

public class RegistroDatosPersonales extends AppCompatActivity {

    private static final int SOLICITUD_PERMISO_ALMACENAMIENTO = 0; //NECESARIO PARA GUARDAR FOTO

    private ImageView iv_foto;
    private Uri uriFoto;
    final static int RESULTADO_GALERIA=2;
    final static int RESULTADO_FOTO=3;
    private Usuario usuario;

    private ImageView logocamara,logogaleria, eliminarfoto;

    Button bGuardar;
    EditText et_nombre,et_apellido,et_email,et_telefono,et_localidad;
    private String foto;


    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //Guardamos el esto del usuario al cambiar la orientación del dispositivo
        savedInstanceState.putSerializable("usuario", usuario);

        if(usuario.getFoto()==null)
            iv_foto.setImageResource(R.drawable.usuario_defecto);
        else ponerFoto(iv_foto, usuario.getFoto());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_personales);

        et_nombre= findViewById(R.id.nombre);
        et_apellido=  findViewById(R.id.apellido);
        et_email=  findViewById(R.id.email);
        et_telefono=  findViewById(R.id.telefono);
        et_localidad=  findViewById(R.id.localidad);

        iv_foto= (ImageView) findViewById(R.id.foto);


        if (savedInstanceState != null) {
            //Recuperar el valor de la imagen
            usuario= (Usuario) savedInstanceState.get("usuario");
        }else{
            //Dar valor a la imagen
            usuario= new Usuario();
        }

        //Implementación del botón de guardado
        bGuardar=  findViewById(R.id.b_guardar);
        bGuardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if( !campoObligatorioVacio(et_nombre) &&
                    !campoObligatorioVacio(et_apellido) &&
                    !campoObligatorioVacio(et_email)){

                    guardarDatos(null);
                }

            }
        });

        //Código para la foto de usuario
        //usuario= new Usuario();



        logocamara = findViewById(R.id.camara);
        logocamara.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                tomarFoto(null);

            }
        });

        logogaleria = findViewById(R.id.galeria);
        logogaleria.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                galeria(null);

            }
        });

        eliminarfoto = findViewById(R.id.eliminarfoto);
        eliminarfoto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                eliminarFoto(null);
            }
        });


        //Persistencia de datos (mecanismo de Preferencias) El nombre del fichero es "datos_usuario"
        SharedPreferences prefe=getSharedPreferences("datos_usuario", Context.MODE_PRIVATE);
        et_nombre.setText(prefe.getString("nombre",""));
        et_apellido.setText(prefe.getString("apellido",""));
        et_email.setText(prefe.getString("email",""));
        et_telefono.setText(prefe.getString("telefono",""));
        et_localidad.setText(prefe.getString("localidad",""));

        //*******************************************************


        actualizarVistas();


    }


    public void galeria(View view){
        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULTADO_GALERIA);
    }

    private void tomarFoto(View view){
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            uriFoto= Uri.fromFile(new File(
                    Environment.getExternalStorageDirectory()+
                            File.separator + "img_" +
                            (System.currentTimeMillis()/1000) +
                            ".jpg"));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uriFoto);
            startActivityForResult(intent, RESULTADO_FOTO);

        }else{
            solicitarPermiso(android.Manifest.permission.READ_EXTERNAL_STORAGE, getString(R.string.permiso_almacenamiento)
                    ,SOLICITUD_PERMISO_ALMACENAMIENTO,this);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {

        if (requestCode==RESULTADO_GALERIA){ //Cuando cargamos foto desde la galería (pag.182)
            if(resultCode== Activity.RESULT_OK){
                usuario.setFoto(data.getDataString());
                ponerFoto(iv_foto, usuario.getFoto());

            }else{
                Toast.makeText(this, getString(R.string.error_foto_no_cargada), Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode==RESULTADO_FOTO){
            if(resultCode== Activity.RESULT_OK && usuario!=null && uriFoto!=null){
                usuario.setFoto(uriFoto.toString());
                ponerFoto(iv_foto, usuario.getFoto());

            }else{
                Toast.makeText(this, getString(R.string.error_en_captura), Toast.LENGTH_SHORT).show();
            }
        }
    }

    protected void ponerFoto(ImageView imageView, String uri){
        if(uri !=null && !uri.isEmpty() && !uri.equals("null")){
            //imageView.setImageURI(Uri.parse(uri));
            imageView.setImageBitmap(reduceBitmap(this, uri, 1024, 1024));
        }else{
            imageView.setImageBitmap(null);
        }
    }


    public void eliminarFoto(View view) {
        usuario.setFoto(null);
        ponerFoto(iv_foto, null);
    }


    protected void actualizarVistas(){
        if(usuario.getFoto()==null)
            iv_foto.setImageResource(R.drawable.usuario_defecto);
        else ponerFoto(iv_foto, usuario.getFoto());
    }

    public  Bitmap reduceBitmap(Context contexto, String uri,
                                      int maxAncho, int maxAlto) {
        try {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(contexto.getContentResolver()
                      .openInputStream(Uri.parse(uri)), null, options);
            options.inSampleSize = (int) Math.max(
                    Math.ceil(options.outWidth / maxAncho),
                    Math.ceil(options.outHeight / maxAlto));
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream(contexto.getContentResolver()
                    .openInputStream(Uri.parse(uri)), null, options);
        } catch (FileNotFoundException e) {
            Toast.makeText(contexto, getString(R.string.error_fichero_no_encontrado),
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return null;
        }
    }

    public void solicitarPermiso(final String permiso, String
            justificacion, final int requestCode, final Activity actividad) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(actividad,
                permiso)){
            new AlertDialog.Builder(actividad)
                    .setTitle(getString(R.string.solicitud_permiso))
                    .setMessage(justificacion)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ActivityCompat.requestPermissions(actividad,
                                    new String[]{permiso}, requestCode);
                        }})
                    .show();
        } else {
            ActivityCompat.requestPermissions(actividad,
                    new String[]{permiso}, requestCode);
        }
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
        //editor.commit();
        Toast.makeText(this, getResources().getString(R.string.datos_guardados), Toast.LENGTH_SHORT).show();
        finish(); //Finaliza la actividad actual

        //Pruebas Isabel: Inicia actividad de prueba, para que yo pueda probar mis cambios en el proyecto
        /*Intent i = new Intent(this, EnvioRespuestaPersonal.class);
        startActivity(i);*/
    }


    public boolean campoObligatorioVacio(EditText et){
        if( et.getText().toString().equalsIgnoreCase("")) {
            //et.setHint(getResources().getString(R.string.err_campo_vacio));
            et.setError(getResources().getString(R.string.err_campo_vacio));
            return true;
        }else return false;
    }


}
