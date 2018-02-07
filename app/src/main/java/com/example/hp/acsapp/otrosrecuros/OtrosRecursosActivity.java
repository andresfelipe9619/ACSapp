package com.example.hp.acsapp.otrosrecuros;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.motivaciones.MotivacionesActivity;

public class OtrosRecursosActivity extends AppCompatActivity {
    private Button btnMensajes, btnHistorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otros_recursos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnMensajes = findViewById(R.id.btn_motivaciones);
        btnHistorias = findViewById(R.id.btn_historias);

        btnMensajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MotivacionesActivity.class);
                startActivity(intent);
            }
        });

        btnHistorias.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=bKB66WjBHCQ")));
                Log.i("Video", "Video Playing....");
            }
        });

    }

}
