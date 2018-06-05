package com.example.bryan.minnanokanji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class menuKanji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kanji);
        getSupportActionBar().setTitle("Kanji 漢字");
    }
}
