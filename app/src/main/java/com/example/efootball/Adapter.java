package com.example.efootball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Partidos> {
    Context context;
    List<Partidos> arrayEquipos;

    public Adapter(@NonNull Context context, List<Partidos> arrayEquipos){
        super(context, R.layout.lista_partidos,arrayEquipos);
        this.context=context;
        this.arrayEquipos=arrayEquipos;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_partidos,null,
                true);
        TextView tvId = view.findViewById(R.id.tvxxid);
        TextView tvequipo = view.findViewById(R.id.txxnombre);

        tvId.setText(arrayEquipos.get(position).getId());
        tvequipo.setText(arrayEquipos.get(position).getEquipo());

        return  view;

    }
}
