package com.example.hp.acsapp.emergencia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.model.CentroEmergencia;
import com.example.hp.acsapp.datasource.model.MensajeMotivacional;

import java.util.List;

/**
 * Created by HP on 2/5/2018.
 */

public class EmergenciaAdapter extends RecyclerView.Adapter<EmergenciaAdapter.EmergenciaViewHolder> {

    private List<CentroEmergencia> centrosEmergencia;
    private EmergenciaItemListener mListener;

    public EmergenciaAdapter(List<CentroEmergencia> emergencias, EmergenciaItemListener listener){
        centrosEmergencia = emergencias;
        mListener = listener;
        setList(emergencias);
    }

    @Override
    public EmergenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.emergencia_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        EmergenciaViewHolder viewHolder = new EmergenciaViewHolder(view);


        return viewHolder;
    }

    public void replaceData(List<CentroEmergencia> emergencias){
        setList(emergencias);
        notifyDataSetChanged();
    }

    private void setList(List<CentroEmergencia> emergencias){
        centrosEmergencia.addAll(emergencias);
    }
    @Override
    public void onBindViewHolder(EmergenciaViewHolder holder, int position) {
        holder.emergenciaName.setText(centrosEmergencia.get(position).getNombre());
        holder.emergenciaAddress.setText(centrosEmergencia.get(position).getDireccion());
        holder.emergenciaNumber.setText(centrosEmergencia.get(position).getTelefono());

    }

    @Override
    public int getItemCount() {
        return centrosEmergencia.size();
    }


    public class EmergenciaViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{

        TextView emergenciaName, emergenciaAddress, emergenciaNumber;

        public EmergenciaViewHolder(View itemView) {
            super(itemView);
            emergenciaAddress = (TextView) itemView.findViewById(R.id.tv_emergencia_address);
            emergenciaName = (TextView) itemView.findViewById(R.id.tv_emergencia_title);
            emergenciaNumber = (TextView) itemView.findViewById(R.id.tv_emergencia_number);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mListener.OnListItemClick(centrosEmergencia.get(clickedPosition));
        }
    }

    public interface EmergenciaItemListener{
        void OnListItemClick(CentroEmergencia emergencia);
    }
}
