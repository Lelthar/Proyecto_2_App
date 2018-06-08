package com.example.bryan.minnanokanji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

public class MainActivity extends AppCompatActivity {

    public EditText editTextEmail;
    public EditText editTextPass;
    public Button buttonInit;
    public Button butttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Iniciar Sesión");

        editTextEmail = findViewById(R.id.editTextMEmail);
        editTextPass  = findViewById(R.id.editTextMPass);
        buttonInit = findViewById(R.id.buttonMinit);
        butttonRegister = findViewById(R.id.buttonMRegister);

        MixpanelAPI mixpanel = MixpanelAPI.getInstance(this,"4b4d6b196066ba9a609c13fb5a11360c");
        mixpanel.track("Login",null);
        mixpanel.flush();

        butttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
