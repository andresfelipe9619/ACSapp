package com.example.hp.acsapp.emergencia.emergenciadetails;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.acsapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class EmergenciaDetailsActivityFragment extends Fragment {

    public EmergenciaDetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_emergencia_details, container, false);
    }
}
