package com.example.bryan.minnanokanji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Iniciar Sesión");

        MixpanelAPI mixpanel = MixpanelAPI.getInstance(this,"4b4d6b196066ba9a609c13fb5a11360c");
        mixpanel.track("Login",null);
        mixpanel.flush();
    }
}
