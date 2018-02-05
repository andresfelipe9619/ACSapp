package com.example.hp.acsapp.motivaciones;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import static android.support.v4.util.Preconditions.checkNotNull;

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
    private MotivacionesContract.Presenter mPresenter;
    private MotivacionesAdapter mAdapter;
    private RecyclerView mRecycler;

    public MotivacionesFragment() {
        // Required empty public constructor

    }

    public static MotivacionesFragment newInstance() {
    return new MotivacionesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        misMensajes.add(new MensajeMotivacional(1,"Animate!","No te mates way","antisuicidio"));
//        misMensajes.add(new MensajeMotivacional(2,"Animate!","No te mates way","antisuicidio"));
        mAdapter = new MotivacionesAdapter(new ArrayList<MensajeMotivacional>(0), this);

    }

    @Override
    public void onResume() {
        super.onResume();
//        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_motivaciones, container, false);
        mRecycler = (RecyclerView) root.findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);

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
    public void setPresenter(@NonNull MotivacionesContract.Presenter presenter) {
        mPresenter = presenter;
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
    public void showMotivacionSeen(String motivacionId) {

    }

    @Override
    public void showNoMotivaciones() {
        //SE OCULTA EL RECYCLER Y SE MUESTRA LA VISTA DE QUE NO HAY

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
