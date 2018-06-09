package com.example.bryan.minnanokanji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuJapon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_japon);
        getSupportActionBar().setTitle("Acerca de Japón");

        Button btnCuriosidades = (Button) findViewById(R.id.btnCuriosidad);
        Button btnConvertidor= (Button) findViewById(R.id.btnConvertidor);
        Button btnEmbajada= (Button) findViewById(R.id.btnEmbajada);

        btnCuriosidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(menuJapon.this, Curiosidades.class);
                startActivity(intent);
            }
        });

        btnConvertidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(menuJapon.this, Convertidor.class);
                startActivity(intent);
            }
        });

        btnEmbajada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(menuJapon.this, Embajada.class);
                startActivity(intent);
            }
        });
    }
}
