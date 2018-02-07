package com.example.hp.acsapp.emergencia;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.model.CentroEmergencia;
import com.example.hp.acsapp.emergencia.emergenciadetails.EmergenciaDetailsActivity;

import java.util.List;



public class EmergenciaFragment extends Fragment implements EmergenciaContract.View{

    private EmergenciaContract.Presenter mPresenter;
    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecycler;
    private EmergenciaAdapter mAdapter;

    public EmergenciaFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EmergenciaFragment newInstance() {
        EmergenciaFragment fragment = new EmergenciaFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_emergencia, container, false);
        RecyclerView mRecycler = root.findViewById(R.id.rv_emergencias);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);

        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setPresenter(EmergenciaContract.Presenter presenter) {
        mPresenter = presenter;

    }

    @Override
    public void showLocalEmergencias(List<CentroEmergencia> centros) {
        mAdapter.replaceData(centros);
    }

    @Override
    public void showCentroEmergenciaDetail(String centro) {
        Intent intent = new Intent(getContext(), EmergenciaDetailsActivity.class);
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
    public void showCentrosEmergencia(List<CentroEmergencia> centros) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
