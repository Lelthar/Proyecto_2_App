package com.example.bryan.minnanokanji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.crashlytics.android.Crashlytics;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import io.fabric.sdk.android.Fabric;

public class menuKanji extends AppCompatActivity {

    private MixpanelAPI mixpanel; //Objeto de mixpanel
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kanji);
        getSupportActionBar().setTitle("Kanji 漢字");
        Fabric.with(this, new Crashlytics());
        mixpanel = MixpanelAPI.getInstance(this,"4b4d6b196066ba9a609c13fb5a11360c");
        mixpanel.track("Ventana de lecciones de Kanji",null); //Realiza la actividad de mixpanel
        mixpanel.flush();



        //creación del botón de acordeón
        //1
        final LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.listaLecciones1);
        final Button btnLec1 = (Button) findViewById(R.id.part1);
        btnLec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linearLayout1.getVisibility()==View.GONE){
                    linearLayout1.setVisibility(View.VISIBLE);
                    btnLec1.setText("Primera Parte ↑");

                }
                else{
                    linearLayout1.setVisibility(View.GONE);
                    btnLec1.setText("Primera Parte ↓");
                }
            }
            });


        //2

        final LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.listaLecciones2);
        final Button btnLec2 = (Button) findViewById(R.id.part2);
        btnLec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linearLayout2.getVisibility()==View.GONE){
                    linearLayout2.setVisibility(View.VISIBLE);
                    btnLec2.setText("Segunda Parte ↑");
                }
                else{
                    linearLayout2.setVisibility(View.GONE);
                    btnLec2.setText("Segunda Parte ↓");
                }
            }
        });



        //3

        final LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.listaLecciones3);
        final Button btnLec3 = (Button) findViewById(R.id.part3);
        btnLec3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linearLayout3.getVisibility()==View.GONE){
                    linearLayout3.setVisibility(View.VISIBLE);
                    btnLec3.setText("Tercera Parte ↑");
                }
                else{
                    linearLayout3.setVisibility(View.GONE);
                    btnLec3.setText("Tercera Parte ↓");
                }
            }
        });

        }
        public void leccion(){//implementar algún método para saber el número de parte y lección
            Intent intent= new Intent(menuKanji.this, ClaseKanji.class);
            startActivity(intent);
        }
}
