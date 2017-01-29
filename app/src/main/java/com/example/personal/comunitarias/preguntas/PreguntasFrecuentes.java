package com.example.personal.comunitarias.preguntas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.personal.comunitarias.R;

/**
 * Created by Janina Costa on 15/1/2017.
 */

public class PreguntasFrecuentes extends AppCompatActivity {

    LinearLayout tutorial;
    ImageButton close;

    String androidListViewStrings[] = {
            "¿Cómo puede ver una noticia?",
            "¿Cómo puedo ver un vídeo de CPCCS?",
            "¿Cómo puedo ver los tweets de CPCCS?",
            "Oficinas por provincia de CPCCS?"};

    Integer image_id[] = {R.drawable.d_flecha, R.drawable.d_flecha, R.drawable.d_flecha, R.drawable.d_flecha};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preguntas_frecuentes_lista);

        listAdapter androidListAdapter = new listAdapter(this, image_id, androidListViewStrings);
        ListView androidListView = (ListView) findViewById(R.id.custom_listview_example);
        androidListView.setAdapter(androidListAdapter);



        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //¿Cómo ver una noticia?
                if(position == 0){
                    Intent i = new Intent(PreguntasFrecuentes.this, Pregunta1.class);
                    startActivity(i);

                }
                //¿Como ver los videos
                if(position == 1){
                    Intent i = new Intent(PreguntasFrecuentes.this, Pregunta2.class);
                    startActivity(i);
                }

                //twitters
                if(position == 2){
                    Intent i = new Intent(PreguntasFrecuentes.this, Pregunta3.class);
                    startActivity(i);
                }

                //oficinas
                //twitters
                if(position == 3){
                    Intent i = new Intent(PreguntasFrecuentes.this, Pregunta4.class);
                    startActivity(i);
                }
            }
        });



    }

    public class listAdapter extends ArrayAdapter {
        String[] androidListViewStrings;
        Integer[] imagesId;
        Context context;

        public listAdapter(Activity context, Integer[] imagesId, String[] textListView) {
            super(context, R.layout.preguntas_frecuentes_item, textListView);
            this.androidListViewStrings = textListView;
            this.imagesId = imagesId;
            this.context = context;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewRow = layoutInflater.inflate(R.layout.preguntas_frecuentes_item, null,true);

            TextView mtextView = (TextView) viewRow.findViewById(R.id.text_view);
            ImageView mimageView = (ImageView) viewRow.findViewById(R.id.image_view);
            mtextView.setText(androidListViewStrings[i]);
            mimageView.setImageResource(imagesId[i]);


            //setContentView(R.layout.preguntas_frecuentes_lista);
            return viewRow;
        }

    }
    //Acciones del boton regresar

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();

        return super.onOptionsItemSelected(item);
    }

}
