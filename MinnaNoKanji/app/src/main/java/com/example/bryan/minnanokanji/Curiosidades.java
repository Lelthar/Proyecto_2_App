package com.example.bryan.minnanokanji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Curiosidades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curiosidades);
        getSupportActionBar().setTitle("Curiosidades de Japón");


        Button btnFiltro = (Button) findViewById(R.id.btnFiltrar);
        btnFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* ACÁ SE HACE LA FILTRACIÓN */
            }
        });


        Button btnOrden = (Button) findViewById(R.id.btnOrdenar);
        btnOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* ACA SE HACE EL ORDENAMIENTO */
            }
        });


        final Button UpDown = (Button) findViewById(R.id.UpDown);
        UpDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UpDown.getText().toString()=="↑"){
                    UpDown.setText("↓");
                }
                else{
                    UpDown.setText("↑");
                }
            }
        });




    }
}
