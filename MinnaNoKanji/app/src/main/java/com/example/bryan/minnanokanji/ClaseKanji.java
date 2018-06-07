package com.example.bryan.minnanokanji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ClaseKanji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase_kanji);
        getSupportActionBar().setTitle("KANJI, Clase No. ");
    }
}
