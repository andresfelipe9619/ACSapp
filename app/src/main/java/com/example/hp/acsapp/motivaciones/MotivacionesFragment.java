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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MotivacionesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MotivacionesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MotivacionesFragment extends Fragment implements MotivacionesContract.View
{

   private OnFragmentInteractionListener mListener;
    private MotivacionesContract.Presenter presentador;
    private MotivacionesAdapter adapter;
    private RecyclerView numberList;
   // private MotivacionAdapter listAdapter;
   private static final int NUM_LIST_ITEMS = 100;


    public MotivacionesFragment() {
        // Required empty public constructor
    }


    public static MotivacionesFragment newInstance() {
    return new MotivacionesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MotivacionesAdapter(NUM_LIST_ITEMS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_motivaciones, container, false);
        numberList = (RecyclerView) root.findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

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


//    @Override
//    public void onListItemClick(int clickedItemIndex) {
//
//    }

    @Override
    public void showMotivaciones() {

    }

//    MotivacionItemListener itemListener = new MotivacionItemListener() {
//        @Override
//        public void onMotivacionClick(Mensajes_motivacionales clicked) {
//            presentador.openMotivacionDetails(clicked);
//        }
//    };

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

//
//    private static class MotivacionAdapter extends BaseAdapter{
//
//        private List<Mensajes_motivacionales> motivaciones;
//        private MotivacionItemListener motivacionItemListener;
//
//        public MotivacionAdapter(List<Mensajes_motivacionales> motivaciones, MotivacionItemListener itemListener){
//            this.motivaciones = motivaciones;
//            motivacionItemListener = itemListener;
//        }
//
//
//        public void replaceData(List<Mensajes_motivacionales> motivaciones){
//
//            setList(motivaciones);
//            notifyDataSetChanged();
//        }
//
//        public void setList(List<Mensajes_motivacionales> motivaciones){ this.motivaciones = motivaciones;}
//
//
//        @Override
//        public int getCount() {
//            return motivaciones.size();
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return motivaciones.get(i);
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return i;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            View rowView = view;
//            if (rowView == null) {
//                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//                rowView = inflater.inflate(R.layout.motivation_item, viewGroup, false);
//            }
//
//            final Mensajes_motivacionales motivacion = (Mensajes_motivacionales) getItem(i);
////
////            TextView titleTV = (TextView) rowView.findViewById(R.id.title);
////            titleTV.setText(task.getTitleForList());
//            rowView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    motivacionItemListener.onMotivacionClick(motivacion);
//                }
//            });
//
//            return rowView;
//        }
//
//
//    }
//
//
//
//    public interface MotivacionItemListener{
//
//        void onMotivacionClick(Mensajes_motivacionales clicked);
//    }
}
