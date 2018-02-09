package com.example.hp.acsapp.motivaciones;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.model.MensajeMotivacional;

import java.util.ArrayList;
import java.util.List;

public class MotivacionesActivity extends AppCompatActivity
        implements  MotivacionesContract.View,MotivacionesAdapter.MotivacionItemListener {

        private MotivacionesContract.Presenter presentadorMotivaciones;
        private MotivacionesAdapter mAdapter;
        private List<MensajeMotivacional> misMensajes;
        private RecyclerView mRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivaciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecycler = (RecyclerView) findViewById(R.id.rv_motivaciones);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setHasFixedSize(true);
        misMensajes = new ArrayList<>(0);
        mAdapter = new MotivacionesAdapter(misMensajes, this);
        mRecycler.setAdapter(mAdapter);
        presentadorMotivaciones = new MotivacionesPresenter(this);
        presentadorMotivaciones.start();

        setSupportActionBar(toolbar);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
//        MotivacionesFragment fragmentoMotivaciones = new MotivacionesFragment();
//        presentadorMotivaciones = new MotivacionesPresenter(fragmentoMotivaciones);
    }

    @Override
    public void setPresenter(@NonNull MotivacionesContract.Presenter presenter) {
        presentadorMotivaciones = presenter;
    }


    @Override
    public void showMotivaciones(List<MensajeMotivacional> mensajes) {

        mAdapter.replaceData(mensajes);
        //SE DEBE OCULTAR LA VISTA DE QUE NO HAY Y MOSTRAR LA DEL RECYCLER
    }

    @Override
    public void showMotivacionDetail(String motivacionId) {

    }

    @Override
    public void showMotivacionSeen() {

    }

    @Override
    public void showNoMotivaciones() {
        //SE OCULTA EL RECYCLER Y SE MUESTRA LA VISTA DE QUE NO HAY

    }

    @Override
    public void onListItemClick(MensajeMotivacional clickedItem) {
        // presentador.openMotivacionDetails(clickedItem);

    }



}
