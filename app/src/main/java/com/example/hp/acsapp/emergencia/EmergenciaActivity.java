package com.example.hp.acsapp.emergencia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.model.CentroEmergencia;
import com.example.hp.acsapp.emergencia.emergenciadetails.EmergenciaDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 1/18/2018.
 */

public class EmergenciaActivity extends AppCompatActivity implements
        EmergenciaContract.View, EmergenciaAdapter.EmergenciaItemListener
    {
    private EmergenciaContract.Presenter mPresenter;
    private RecyclerView mRecycler;
    private EmergenciaAdapter mAdapter;
    private List<CentroEmergencia> mCentros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecycler = findViewById(R.id.rv_emergencias);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setHasFixedSize(true);
        mCentros = new ArrayList<>(0);
        mAdapter = new EmergenciaAdapter(mCentros,this);
        mRecycler.setAdapter(mAdapter);
        mPresenter = new EmergenciaPresenter(this);
        mPresenter.start();

        setSupportActionBar(toolbar);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//
//        EmergenciaFragment fragmentoEmergencia = new EmergenciaFragment();
//        presentadorEmergencia = new EmergenciaPresenter(fragmentoEmergencia);

    }
    @Override
    public void setPresenter(EmergenciaContract.Presenter presenter) {
        mPresenter = presenter;

    }


        @Override
        public void showCentrosEmergencia(List<CentroEmergencia> centros) {
            mAdapter.replaceData(centros);

        }

    @Override
    public void showLocalEmergencias(List<CentroEmergencia> centros) {
        mAdapter.replaceData(centros);
    }

    @Override
    public void showCentroEmergenciaDetail(String centro) {
        Intent intent = new Intent(this, EmergenciaDetailsActivity.class);
    }

    @Override
    public void showCallOption() {

    }

    @Override
    public void showMapsOption() {

    }

    @Override
    public void showNotFoundLocalCentros() {

    }

    @Override
    public void showLocalCountryCentros() {

    }

    @Override
    public void showNoCentrosEmergencia() {
    }


        @Override
        public void OnListItemClick(CentroEmergencia emergencia) {

        }
    }
