package com.example.hp.acsapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hp.acsapp.actividades.ActividadesFragment;
import com.example.hp.acsapp.contactos.ContactoFragment;
import com.example.hp.acsapp.estrategias.EstrategiasFragment;
import com.example.hp.acsapp.estrategias.EstrategiasPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 1/9/2018.
 */

public class HomeActivity extends AppCompatActivity implements ActividadesFragment.OnFragmentInteractionListener,
        EstrategiasFragment.OnFragmentInteractionListener, ContactoFragment.OnFragmentInteractionListener {

    private EstrategiasPresenter presentadorEstrategias;
    private TextView mTextMessage;
    private EstrategiasFragment estrategiasFragment;
    private ContactoFragment contactoFragment;
    private ActividadesFragment actividadesFragment;
    private ViewPager viewPager;
    MenuItem prevMenuItem;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_actividad:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_estrategias:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_contactos:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        contactoFragment = new ContactoFragment();
        actividadesFragment =new ActividadesFragment();
        estrategiasFragment = new EstrategiasFragment();

        adapter.addFragment(actividadesFragment);
        adapter.addFragment(estrategiasFragment);
        adapter.addFragment(contactoFragment);
        viewPager.setAdapter(adapter);
    }


    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

    }
}



