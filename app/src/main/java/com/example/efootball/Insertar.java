package com.example.efootball;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class Insertar extends AppCompatActivity {

    TextView tvEquipo,tvCampo,tvHorario,tvArbitro;
    Button btGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        tvEquipo = (TextView) findViewById(R.id.tvEquipos);
        tvCampo = (TextView) findViewById(R.id.tvCampo);
        tvHorario = (TextView) findViewById(R.id.tvHorario);
        tvArbitro = (TextView) findViewById(R.id.tvArbitro);
        btGuardar = (Button) findViewById(R.id.btGuardar);

        // Accion para guardar los Datos//

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarDatos();
            }
        });

    }
           // Crear el AgregarDatos y conseguir datos
    private void AgregarDatos() {
        String equipo = tvEquipo.getText().toString().trim();
        String campo = tvCampo.getText().toString().trim();
        String horario = tvHorario.getText().toString().trim();
        String arbitro = tvArbitro.getText().toString().trim();

        if (equipo.isEmpty()) {
            Toast.makeText(this, "Ingresa los nombres de los equipos ", Toast.LENGTH_SHORT).show();
            return;
        } else if (campo.isEmpty()) {
            Toast.makeText(this, "Ingresa el nombre del campo ", Toast.LENGTH_SHORT).show();
            return;
        } else if (horario.isEmpty()) {
            Toast.makeText(this, "Ingresa el horario", Toast.LENGTH_SHORT).show();
            return;
        } else if (arbitro.isEmpty()) {
            Toast.makeText(this, "Ingresa el arbitro", Toast.LENGTH_SHORT).show();
            return;
        }else{
                 StringRequest request=new StringRequest(Request.Method.POST,
                         "https://gastroglobal.com.mx/webservicesefootball/insert.php",
                         new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         if (response.equalsIgnoreCase("Datos insertado")) {
                             Toast.makeText(Insertar.this, "Datos insertados", Toast.LENGTH_SHORT).show();
                             startActivity(new Intent(getApplicationContext(), MainActivity.class));
                             finish();
                         } else {
                             Toast.makeText(Insertar.this, response, Toast.LENGTH_SHORT).show();
                         }
                     }
                 }, new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error) {
                         Toast.makeText(Insertar.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                     }
                 }

                 ){
                     @Nullable
                     @Override
                     protected Map<String,String> getParams() throws AuthFailureError{
                         Map<String,String> params= new HashMap<String,String>();
                         params.put("equipo",equipo);
                         params.put("campo",campo);
                         params.put("horario",horario);
                         params.put("arbitro",arbitro);

                         return params;

                     }
                 };
            RequestQueue requestQueue = Volley.newRequestQueue(Insertar.this);
            requestQueue.add(request);
         }
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}