package com.example.hp.acsapp.actividades;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.model.Actividad;
import java.util.List;

/**
 * Created by HP on 1/31/2018.
 */

public class ActividadesAdapter extends RecyclerView.Adapter<ActividadesAdapter.ActividadViewHolder> {

    List<Actividad> mActividades;
    ActividadItemListener mlistener;
    Context context;

    public ActividadesAdapter(List<Actividad> actividades, ActividadItemListener listener){
        setList(actividades);
        mlistener = listener;
    }

    @Override
    public ActividadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        int layoutIdForListItem = R.layout.actividad_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        ActividadViewHolder viewHolder = new ActividadViewHolder(view);

        return viewHolder;
    }


    private void setList(List<Actividad> actividades){mActividades = actividades;}

    @Override
    public void onBindViewHolder(ActividadViewHolder holder, int position) {
        holder.mImage.setImageResource(Integer.parseInt(mActividades.get(position).getIcon_url()));
    }

    @Override
    public int getItemCount() {
        return mActividades.size();
    }

    public class ActividadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView mImage;
        private ActividadViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.imageActividadItem);
            mImage.setAdjustViewBounds(true);
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
            mImage.setBackgroundResource(outValue.resourceId);
            mImage.setClickable(true);
            mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImage.setPadding(8, 8, 8, 8);
            mImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mlistener.onListItemClick(mActividades.get(clickedPosition));
        }
    }

    public interface ActividadItemListener {
        void onListItemClick(Actividad clickedItem);
    }

}
