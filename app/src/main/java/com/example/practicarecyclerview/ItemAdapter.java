package com.example.practicarecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private List<Campeon> listaCampeones;

    public ItemAdapter(List<Campeon> listaCampeones){
        this.listaCampeones = listaCampeones;
    }

    //Este metodo infla la vista
    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    //Este metodo le da los valores apropiados al item del viewholder que esta en pantalla segun su posicion
    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        String nombre = listaCampeones.get(position).getNombreCampeon();
        holder.txtArticulo.setText(nombre);

        int imagen = listaCampeones.get(position).getImagenCampeon();
        holder.imgvCampeon.setImageResource(imagen);

        String fecha = listaCampeones.get(position).getFechaMundial();
        holder.txtFecha.setText(fecha);
    }

    //Este metodo recibe el numero de items
    @Override
    public int getItemCount() {
        return listaCampeones.size();
    }

    //Esta clase interna sirve para crear los elementos de cada item que luego seran modificados
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtArticulo;
        private ImageView imgvCampeon;
        private TextView txtFecha;

        public ViewHolder(@NonNull View v) {
            super(v);
            txtArticulo = v.findViewById(R.id.txtArticulo);
            imgvCampeon = v.findViewById(R.id.imgvCampeon);
            txtFecha = v.findViewById(R.id.txtFecha);
        }
    }
}
