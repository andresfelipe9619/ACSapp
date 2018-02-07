package com.example.hp.acsapp.motivaciones;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.hp.acsapp.R;

public class MotivacionesActivity extends AppCompatActivity implements MotivacionesFragment.OnFragmentInteractionListener {

    private MotivacionesPresenter presentadorMotivaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivaciones);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = this.getSupportActionBar();
//
//
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }

        MotivacionesFragment fragmentoMotivaciones = new MotivacionesFragment();
        presentadorMotivaciones = new MotivacionesPresenter(fragmentoMotivaciones);
        presentadorMotivaciones.start();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
