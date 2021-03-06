package com.example.hp.acsapp.motivaciones;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.model.MensajeMotivacional;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by HP on 1/24/2018.
 */

public class MotivacionesAdapter extends RecyclerView.Adapter<MotivacionesAdapter.MotivacionViewHolder> {

//    final private ListItemClickListener onClickListener;
    private List<MensajeMotivacional> mensajes_motivacionales;
    private MotivacionItemListener mListener;
    private static String TAG = MotivacionesAdapter.class.getSimpleName();

    public MotivacionesAdapter(List<MensajeMotivacional> mensajes, MotivacionItemListener listener){
        mensajes_motivacionales = mensajes;
        mListener = listener;
        setList(mensajes);
    }

    @Override
    public MotivacionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.motivacion_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        MotivacionViewHolder viewHolder = new MotivacionViewHolder(view);

        return viewHolder;
    }

    public void replaceData(List<MensajeMotivacional> mensajes){
        setList(mensajes);
        Log.d(TAG,"REPLACE");
        notifyDataSetChanged();
    }

    private void setList(List<MensajeMotivacional> mensajes){
        mensajes_motivacionales.addAll(mensajes);
//        mensajes_motivacionales = mensajes;
    }

    @Override
    public void onBindViewHolder(MotivacionViewHolder holder, int position) {
        holder.motivacionTitle.setText(mensajes_motivacionales.get(position).getTitulo());
        holder.motivacionDescription.setText(mensajes_motivacionales.get(position).getDescripcion());
    }


    @Override
    public int getItemCount() {
        return mensajes_motivacionales.size();
    }


    class MotivacionViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView motivacionTitle, motivacionDescription;

        public MotivacionViewHolder(View itemView) {
            super(itemView);
            motivacionTitle = (TextView) itemView.findViewById(R.id.tv_motivacion_title);
            motivacionDescription = (TextView) itemView.findViewById(R.id.tv_motivacion_description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
           mListener.onListItemClick(mensajes_motivacionales.get(clickedPosition));
        }
    }

    /**
     * The interface that receives onClick messages.
     */
    public interface MotivacionItemListener {
        void onListItemClick(MensajeMotivacional clickedItem);
    }

}
