package com.example.bryan.minnanokanji;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.bryan.minnanokanji.GlobalClass.URL_HOST;
import static com.example.bryan.minnanokanji.GlobalClass.USER_LOGIN;

public class MainActivity extends AppCompatActivity {

    public EditText editTextEmail;
    public EditText editTextPass;
    public Button buttonInit;
    public Button butttonRegister;
    public Conexion conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Iniciar Sesión");

        editTextEmail = findViewById(R.id.editTextMEmail);
        editTextPass  = findViewById(R.id.editTextMPass);
        buttonInit = findViewById(R.id.buttonMinit);
        butttonRegister = findViewById(R.id.buttonMRegister);

        //MixpanelAPI mixpanel = MixpanelAPI.getInstance(this,"4b4d6b196066ba9a609c13fb5a11360c");
        //mixpanel.track("Login",null);
        //mixpanel.flush();

        butttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, Registrarse.class);
                startActivity(intent);
            }
        });

        buttonInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    iniciarSesion();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Metodo para iniciar sesión
     * @throws JSONException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void iniciarSesion() throws JSONException, ExecutionException, InterruptedException {
        String correo= editTextEmail.getText().toString();
        String pass= editTextPass.getText().toString();
        if(!correo.equals("")&&!pass.equals("")){
            conexion = new Conexion();
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("email", correo);
            jsonParam.put("password", pass);

            String  result = conexion.execute(URL_HOST+USER_LOGIN,"POST",jsonParam.toString()).get();

            if(result.equals("OK")) {
                Intent intent= new Intent(MainActivity.this, MenuPrincipal.class);
                startActivity(intent);
            }else{
                errorMessageDialog("Credenciales incorrectos.");
            }
        }else{
            errorMessageDialog("Para iniciar sesión debe de llenar todos los espacios.");
        }
    }

    /**
     * Cuadro de diálogo para mensajes de información.
     * @param message
     */
    private void infoMessageDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setIcon(R.drawable.ic_img_diag_info_icon)
                .setMessage(message).setTitle("Información").setPositiveButton("Aceptar",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) { return; }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }



    /**
     * Cuadro de diálogo para mensajes de error.
     * @param message
     */
    private void errorMessageDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setIcon(R.drawable.ic_img_diag_error_icon)
                .setMessage(message).setTitle("Error").setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) { return; }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
