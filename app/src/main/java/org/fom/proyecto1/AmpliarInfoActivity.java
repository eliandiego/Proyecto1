package org.fom.proyecto1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AmpliarInfoActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEnviarInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_info);

        btnEnviarInfo = findViewById(R.id.btn_solicitar_info);
        btnEnviarInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_solicitar_info:

                enviarInfooAlDemandante();
                break;
            default:
        }
    }

    private void enviarInfooAlDemandante() {

        Toast.makeText(this, "Se envió la información al demandante", Toast.LENGTH_LONG).show();
        finish();
    }
}
