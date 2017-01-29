package com.example.personal.comunitarias.oficinas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.personal.comunitarias.R;

public class OfficeDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog);
        Oficina oficina = OficinasActivity.select;
        TextView provincia = (TextView) findViewById(R.id.tittle);
        TextView ciudad = (TextView) findViewById(R.id.ciudadtil);
        TextView direccion = (TextView) findViewById(R.id.direcciontil);
        TextView telefono = (TextView) findViewById(R.id.telefonotil);
        provincia.setText(oficina.getProvincia());
        ciudad.setText(oficina.getCiudad());
        direccion.setText(oficina.getDireccion());
        telefono.setText(oficina.getTelefono());


    }

    public void onClickClose(View view) {
        finish();
    }
}
