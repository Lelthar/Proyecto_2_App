package com.example.bryan.minnanokanji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnKanji = (Button) findViewById(R.id.btnKanji);
        Button btnKatakana = (Button) findViewById(R.id.btnKatakana);
        Button btnHiragana = (Button) findViewById(R.id.btnHiragana);
        Button btnJapon = (Button) findViewById(R.id.btnJapon);


        btnKanji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Menu.this, menuKanji.class);
                startActivity(intent);
            }
        });

        btnKatakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Menu.this, menuKatakana.class);
                startActivity(intent);
            }
        });

        btnHiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Menu.this, menuHirahana.class);
                startActivity(intent);
            }
        });

        btnJapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Menu.this, menuJapon.class);
                startActivity(intent);
            }
        });



    }
}
