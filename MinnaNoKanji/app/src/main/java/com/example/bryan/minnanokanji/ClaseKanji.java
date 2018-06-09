package com.example.bryan.minnanokanji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ClaseKanji extends AppCompatActivity {

    private ListView lista_view_leccion;
    private String numero_leccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase_kanji);
        getSupportActionBar().setTitle("KANJI, Clase No. ");
        lista_view_leccion = findViewById(R.id.listViewKatakana);

        Intent i=getIntent();
        numero_leccion = i.getExtras().getString("leccion");
        try {
            MostrarLeccion();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void MostrarLeccion() throws ExecutionException, InterruptedException, JSONException {
        Conexion user_extendeds = new Conexion();
        String resultado_consulta_hiragana = user_extendeds.execute("http://minnanokanjibackend.miwwk5bepd.us-east-1.elasticbeanstalk.com/leccion_kanjis", "GET").get();
        JSONArray datos_hiragana = new JSONArray(resultado_consulta_hiragana);
        List<String> numeros_list = new ArrayList<>();
        List<String> significado_list = new ArrayList<>();
        List<String> imagen_kanji_list = new ArrayList<>();
        List<String> imagen_trazos_list = new ArrayList<>();
        List<String> explicacion_list = new ArrayList<>();
        List<String> extra_list = new ArrayList<>();

        JSONObject elemento;

        for(int i = 0; i < datos_hiragana.length(); i++){
            elemento = datos_hiragana.getJSONObject(i);

            if(elemento.getString("leccion").equals(this.numero_leccion)){
                numeros_list.add(elemento.getString("numero"));
                significado_list.add(elemento.getString("significado"));
                imagen_kanji_list.add(elemento.getString("imagen_kanji"));
                imagen_trazos_list.add(elemento.getString("imagen_trazos"));
                explicacion_list.add(elemento.getString("explicacion"));
                extra_list.add(elemento.getString("extra"));
            }
        }

        String[] numeros_adapter = numeros_list.toArray(new String[0]);
        String[] significado_adapter = significado_list.toArray(new String[0]);
        String[] imagen_kanji_adapter = imagen_kanji_list.toArray(new String[0]);
        String[] imagen_trazos_adapter = imagen_trazos_list.toArray(new String[0]);
        String[] explicacion_adapter = explicacion_list.toArray(new String[0]);
        String[] extra_adapter = extra_list.toArray(new String[0]);

        CustomListKanji adapter = new CustomListKanji(this,numeros_adapter,significado_adapter,imagen_kanji_adapter,imagen_trazos_adapter,explicacion_adapter,extra_adapter);

        if(adapter != null){
            lista_view_leccion.setAdapter(adapter);
        }
    }
}
