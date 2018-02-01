package com.example.hp.acsapp.motivaciones;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.model.MensajeMotivacional;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MotivacionesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MotivacionesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MotivacionesFragment extends Fragment
        implements MotivacionesContract.View, MotivacionesAdapter.MotivacionItemListener
{
    private static final int NUM_LIST_ITEMS = 100;
    private OnFragmentInteractionListener mListener;
    private MotivacionesContract.Presenter presentador;
    private MotivacionesAdapter adapter;
    private RecyclerView numberList;
    private List<MensajeMotivacional> misMensajes;


    public MotivacionesFragment() {
        // Required empty public constructor

    }

    public static MotivacionesFragment newInstance() {
    return new MotivacionesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        misMensajes = new ArrayList<>();
        misMensajes.add(new MensajeMotivacional("1","Animate!","No te mates way","antisuicidio"));
        misMensajes.add(new MensajeMotivacional("2","Animate!","No te mates way","antisuicidio"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_motivaciones, container, false);
        numberList = (RecyclerView) root.findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new MotivacionesAdapter(misMensajes, this);

        numberList.setHasFixedSize(true);
        numberList.setLayoutManager(layoutManager);
        numberList.setAdapter(adapter);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
    public void setPresenter(MotivacionesContract.Presenter presenter) {
        presentador = presenter;
    }


    @Override
    public void showMotivaciones() {

    }

    @Override
    public void showMotivacionDetail(String motivacionId) {

    }

    @Override
    public void showMotivacionSeen(String motivacionId) {

    }


    @Override
    public void onListItemClick(MensajeMotivacional clickedItem) {
        // presentador.openMotivacionDetails(clickedItem);

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
