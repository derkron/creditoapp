package com.example.credito;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CreditoActivity extends AppCompatActivity {
    EditText jetcodigo_credito,jetidentificacion;
    TextView jtvnombre,jtvprofesion,jtvsalario,jtvingresos_extras,jtvgastos,jtvvalor_prestamo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credito);
        getSupportActionBar().hide();
        jetcodigo_credito=findViewById(R.id.etcodigo_credito);
        jetidentificacion=findViewById(R.id.etidentificacion);
        jtvnombre=findViewById(R.id.tvnombre);
        jtvprofesion=findViewById(R.id.tvprofesion);
        jtvsalario=findViewById(R.id.tvsalario);
        jtvingresos_extras=findViewById(R.id.tvingresos_extras);
        jtvgastos=findViewById(R.id.tvgastos);
        jtvvalor_prestamo=findViewById(R.id.tvvalor_prestamo);
    }
}