package org.fom.proyecto1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class RespuestaActivity extends AppCompatActivity implements RadioButton.OnClickListener {

    RadioButton aceptar, rechazar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);

        aceptar = findViewById(R.id.rbtn_aceptar);
        rechazar = findViewById(R.id.rbtn_rechazar);

        aceptar.setOnClickListener(this);
        rechazar.setOnClickListener(this);
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
        }
    }
}
