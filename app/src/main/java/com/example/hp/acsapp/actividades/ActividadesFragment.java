package com.example.hp.acsapp.actividades;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.ActividadesAssets;
import com.example.hp.acsapp.datasource.model.Actividad;

import java.util.ArrayList;
import java.util.List;

public class ActividadesFragment extends Fragment implements ActividadesContract.View, ActividadesAdapter.ActividadItemListener{

    private OnFragmentInteractionListener mListener;
    private ActividadesContract.Presenter mPresenter;
    private ActividadesAdapter mAdapter;
    private RecyclerView defaultActividades;
    private List<Actividad> actividades;
    private ActividadesAssets mAssets;

    public ActividadesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ActividadesFragment newInstance() {
        ActividadesFragment fragment = new ActividadesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAssets = new ActividadesAssets();
        List<Integer> urls = mAssets.getDefaultActividades();
        actividades = new ArrayList<>();
        actividades.add(new Actividad( "Cocinar", "La mejor cociqna", String.valueOf(urls.get(0))));
        actividades.add(new Actividad( "Bailar", "El mejor baile", String.valueOf(urls.get(1))));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_actividades, container, false);
        defaultActividades = (RecyclerView) root.findViewById(R.id.rv_defaultActividades);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),4 );
        mAdapter = new ActividadesAdapter(actividades, this);

        defaultActividades.setHasFixedSize(true);
        defaultActividades.setLayoutManager(layoutManager);
        defaultActividades.setAdapter(mAdapter);
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
    public void setPresenter(ActividadesContract.Presenter presenter) {

    }

    @Override
    public void showAddActividad() {

    }

    @Override
    public void showActividadDetail(String actividadId) {

    }

    @Override
    public void showBaseActividades(List<Actividad> actividades) {

    }

    @Override
    public void showUserActividades(List<Actividad> actividads) {

    }

    @Override
    public void showNoUserActividades() {

    }

    @Override
    public void showActividadMarkedComplete() {

    }

    @Override
    public void onListItemClick(Actividad clickedItem) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
