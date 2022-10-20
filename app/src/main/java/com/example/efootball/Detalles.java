package com.example.efootball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    TextView tvxid, tvxEquipo, tvxCampo, tvxHorario, tvxArbitro;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        tvxid = (TextView) findViewById(R.id.tvxid);
        tvxEquipo = (TextView) findViewById(R.id.tvxEquipo);
        tvxCampo = (TextView) findViewById(R.id.tvxCampo);
        tvxHorario = (TextView) findViewById(R.id.tvxNumHorario);
        tvxArbitro = (TextView) findViewById(R.id.tvxArbitro);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
        tvxid.setText("Id: "+MainActivity.partidosArrayList.get(position).getId());
        tvxEquipo.setText("Equipo: "+MainActivity.partidosArrayList.get(position).getEquipo());
        tvxCampo.setText("Campo: "+MainActivity.partidosArrayList.get(position).getCampo());
        tvxHorario.setText("Horario: "+MainActivity.partidosArrayList.get(position).getHorario());
        tvxArbitro.setText("Arbitro: "+MainActivity.partidosArrayList.get(position).getArbitro());
    }
}