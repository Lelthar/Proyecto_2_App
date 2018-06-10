package com.example.bryan.minnanokanji;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class menuHirahana extends AppCompatActivity {

    public static ArrayList<String> lista_lecciones;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    public static final String POSICION  = "posicion_leccion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hirahana);
        getSupportActionBar().setTitle("Hirahana ひらがな");


        listView = findViewById(R.id.listaHiraganas);


        try {
            lista_lecciones = (cargarLecciones());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,lista_lecciones);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enviarLeccion(position);

            }

        });


    }


    public void enviarLeccion(int posicion){
        Intent intent = new Intent(menuHirahana.this,ClaseHiragana.class);
        intent.putExtra(POSICION,Integer.toString(posicion));
        startActivity(intent);

    }


    public ArrayList<String> cargarLecciones() throws JSONException, ExecutionException, InterruptedException {

        Conexion user_extendeds = new Conexion();
        String resultado_consulta_hiragana = user_extendeds.execute("http://minnanokanjibackend.miwwk5bepd.us-east-1.elasticbeanstalk.com/hiraganas.json", "GET").get();
        JSONArray datos_hiragana = new JSONArray(resultado_consulta_hiragana);
        List<String> leccion_hiragana = new ArrayList<>();

        JSONObject elemento;

        for(int i = 0; i < datos_hiragana.length(); i++){

            elemento = datos_hiragana.getJSONObject(i);

            leccion_hiragana.add("Lección No. "+ elemento.getString("leccion"));
        }

        return (ArrayList<String>) leccion_hiragana;


    }



}
