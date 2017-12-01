package org.fisk.findteacher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class RespuestaActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton aceptar, rechazar;
    Button btnResponder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);

        aceptar = findViewById(R.id.rbtn_aceptar);
        rechazar = findViewById(R.id.rbtn_rechazar);
        btnResponder = findViewById(R.id.btn_responder);

        aceptar.setOnClickListener(this);
        rechazar.setOnClickListener(this);
        btnResponder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.rbtn_aceptar:
                rechazar.setChecked(false);
                break;

            case R.id.rbtn_rechazar:
                aceptar.setChecked(false);
                break;
            case R.id.btn_responder:
                responder();
                break;
            default:

        }
    }

    private void responder() {
        Toast.makeText(this, "Se ha enviado una notificación al ofertante", Toast.LENGTH_SHORT).show();
        finish();
    }
}
