package com.example.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class MiAdaptadorAverias extends ArrayAdapter<Averia> {
    Context ctx;
    int layoutTemplate;
    List<Averia> averiaList;
    public MiAdaptadorAverias(@NonNull Context context, int resource, @NonNull List<Averia> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.averiaList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        Averia elementoActual = averiaList.get(position);

        TextView textViewTitulo = v.findViewById(R.id.textViewTitulo);
        TextView textViewModeloCoche = v.findViewById(R.id.textViewModeloCoche);
        TextView textViewPresupuesto = v.findViewById(R.id.textViewPresupuesto);
        ImageView iviv = v.findViewById(R.id.imageViewFoto);
        textViewTitulo.setText(elementoActual.getTitulo());
        textViewModeloCoche.setText(elementoActual.getModeloCoche());
        textViewPresupuesto.setText(elementoActual.getNumeroPresupuesto() + " presupuestos");
       if(!elementoActual.getUrlFoto().isEmpty()){
           Glide.with(ctx).load(elementoActual.getUrlFoto()).into(iviv);

       }




        return v;
    }
}
