package com.example.hp.acsapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hp.acsapp.actividades.ActividadesFragment;
import com.example.hp.acsapp.estrategias.EstrategiasFragment;
import com.example.hp.acsapp.estrategias.EstrategiasPresenter;

/**
 * Created by HP on 1/9/2018.
 */

public class HomeActivity extends AppCompatActivity implements ActividadesFragment.OnFragmentInteractionListener,
        EstrategiasFragment.OnFragmentInteractionListener, ContactosFragment.OnFragmentInteractionListener {

    private EstrategiasPresenter presentadorEstrategias;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_actividad:
                    transaction.replace(R.id.content, new ActividadesFragment()).addToBackStack(null).commit();
                    return true;
                case R.id.navigation_estrategias:
                    transaction.replace(R.id.content, new EstrategiasFragment()).addToBackStack(null).commit();
                    return true;
                case R.id.navigation_contactos:
                    transaction.replace(R.id.content, new ContactosFragment()).addToBackStack(null).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        EstrategiasFragment fragmentoEstrategias = new EstrategiasFragment();
        presentadorEstrategias = new EstrategiasPresenter(fragmentoEstrategias);



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
