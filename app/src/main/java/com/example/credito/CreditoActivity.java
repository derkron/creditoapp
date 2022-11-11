package com.example.credito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CreditoActivity extends AppCompatActivity {
    EditText jetcodigo_credito, jetidentificacion;
    TextView jtvnombre, jtvprofesion, jtvsalario, jtvingresos_extras, jtvgastos, jtvvalor_prestamo;
    String identificacion,salario,gastos,valor_prestamo,ingresos;

    ClsOpenHelper admin = new ClsOpenHelper(this, "Banco.bd", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credito);
        getSupportActionBar().hide();
        jetcodigo_credito = findViewById(R.id.etcodigo_credito);
        jetidentificacion = findViewById(R.id.etidentificacion);
        jtvnombre = findViewById(R.id.tvnombre);
        jtvprofesion = findViewById(R.id.tvprofesion);
        jtvsalario = findViewById(R.id.tvsalario);
        jtvingresos_extras = findViewById(R.id.tvingresos_extras);
        jtvgastos = findViewById(R.id.tvgastos);
        jtvvalor_prestamo = findViewById(R.id.tvvalor_prestamo);
    }

    public void Buscar(View view) {
        identificacion = jetidentificacion.getText().toString();
        if (identificacion.isEmpty()) {
            Toast.makeText(this, "Identificacion es requerida para la consulta", Toast.LENGTH_SHORT).show();
            jetidentificacion.requestFocus();
        }
        else {
            SQLiteDatabase fila = admin.getReadableDatabase();
            Cursor dato = fila.rawQuery("select * from TblCliente where identificacion='" + identificacion + "'", null);
            if (dato.moveToNext()) {
                jtvnombre.setText(dato.getString(1));
                jtvprofesion.setText(dato.getString(2));
                jtvsalario.setText(dato.getString(4));
                jtvingresos_extras.setText(dato.getString(5));
                jtvgastos.setText(dato.getString(6));


            }
            else{
                Toast.makeText(this, "Cliente no registrado", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void Ejecutar(View view){
        identificacion = jetidentificacion.getText().toString();
        salario=jtvsalario.getText().toString();
        ingresos=jtvingresos_extras.getText().toString();
        gastos=jtvgastos.getText().toString();



        if (identificacion.isEmpty()) {
            Toast.makeText(this, "Identificacion es requerida para la consulta", Toast.LENGTH_SHORT).show();
            jetidentificacion.requestFocus();
        }
        else{
            int  ogastos, osalario,oingresos;
            float ngastos,nsalario,ningresos;
            ogastos=Integer.parseInt(gastos);
            osalario=Integer.parseInt(salario);
            oingresos=Integer.parseInt(ingresos);

        }

    }
    public void Regresar(View view){
        Intent intmenu=new Intent(this,MenuActivity.class);
        startActivity(intmenu);
    }
}