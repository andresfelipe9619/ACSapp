package com.example.hp.acsapp.estrategias;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.model.TecnicaRelajacion;
import com.example.hp.acsapp.emergencia.EmergenciaActivity;
import com.example.hp.acsapp.otrosrecuros.OtrosRecursosActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EstrategiasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EstrategiasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EstrategiasFragment extends Fragment implements EstrategiasContract.View {

    private EstrategiasContract.Presenter presentador;
    private Button btn_tecnicas;
    private Button btn_mensajes;
    private Button btn_emergencia;
    private FrameLayout content;
    private OnFragmentInteractionListener mListener;

    public EstrategiasFragment() {
        // Required empty public constructor
    }


    public static EstrategiasFragment newInstance() {
        return new EstrategiasFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_estrategias, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_tecnicas = view.findViewById(R.id.btn_tecnicas_relajacion);
        btn_emergencia = view.findViewById(R.id.btn_centros_emergencia);
        btn_mensajes = view.findViewById(R.id.btn_otros_recursos);
        content = view.findViewById(R.id.content);
        btn_tecnicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presentador.openTecnicasRelajacion();
            }
        });

        btn_mensajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presentador.openMensajesMotivacionales();
            }
        });

        btn_emergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presentador.openCentrosAtencion();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
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
        OnFragmentInteractionListener mListener = this.mListener;
        mListener = null;
    }

    @Override
    public void showMensajesMotivacionales() {
        Intent intent = new Intent(getContext(), OtrosRecursosActivity.class);
        startActivity(intent);
    }

    @Override
    public void showCentrosAtencion() {
        Intent intent = new Intent(getContext(), EmergenciaActivity.class);
        startActivity(intent);
    }

    @Override
    public void showTecnicasRelajacion() {
        Intent intent = new Intent(getContext(), TecnicaRelajacion.class);
        startActivity(intent);
    }


    @Override
    public void setPresenter(EstrategiasContract.Presenter presenter) {
        presentador = presenter;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
