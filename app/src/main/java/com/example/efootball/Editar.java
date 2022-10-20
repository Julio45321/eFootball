package com.example.efootball;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class Editar extends AppCompatActivity {

    EditText tveid,tveequipo,tvecampo,tvehorario,tvearbitro;
    Button editare;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        tveid = (EditText) findViewById(R.id.tveid);
        tveequipo = (EditText) findViewById(R.id.tveequipo);
        tvecampo = (EditText) findViewById(R.id.tvecampo);
        tvehorario = (EditText) findViewById(R.id.tvehorario);
        tvearbitro = (EditText) findViewById(R.id.tvearbitro);
        editare = (Button) findViewById(R.id.editare);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
        tveid.setText(MainActivity.partidosArrayList.get(position).getId());
        tveequipo.setText(MainActivity.partidosArrayList.get(position).getEquipo());
        tvecampo.setText(MainActivity.partidosArrayList.get(position).getCampo());
        tvehorario.setText(MainActivity.partidosArrayList.get(position).getHorario());
        tvearbitro.setText(MainActivity.partidosArrayList.get(position).getArbitro());

    }
    public void Update(View view){
        final String id=tveid.getText().toString().trim();
        final String equipo=tveequipo.getText().toString().trim();
        final String campo=tvecampo.getText().toString().trim();
        final String horario=tvehorario.getText().toString().trim();
        final String arbitro=tvearbitro.getText().toString().trim();

        StringRequest request = new StringRequest(Request.Method.POST,
                "https://gastroglobal.com.mx/webservicesefootball/update.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Editar.this, response, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Editar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String,String>getParams() throws AuthFailureError{
                Map<String,String> params = new HashMap<>();
                params.put("id",id);
                params.put("equipo",equipo);
                params.put("campo",campo);
                params.put("horario",horario);
                params.put("arbitro",arbitro);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(Editar.this);
        requestQueue.add(request);
    }
}