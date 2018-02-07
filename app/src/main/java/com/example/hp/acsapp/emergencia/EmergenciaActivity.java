package com.example.hp.acsapp.emergencia;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.motivaciones.MotivacionesFragment;
import com.example.hp.acsapp.motivaciones.MotivacionesPresenter;

/**
 * Created by HP on 1/18/2018.
 */

public class EmergenciaActivity extends AppCompatActivity implements MotivacionesFragment.OnFragmentInteractionListener {
    private EmergenciaPresenter presentadorEmergencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = this.getSupportActionBar();


        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        EmergenciaFragment fragmentoEmergencia = new EmergenciaFragment();
        presentadorEmergencia = new EmergenciaPresenter(this, fragmentoEmergencia);
        presentadorEmergencia.start();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
