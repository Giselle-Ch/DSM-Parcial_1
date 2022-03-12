package edu.udb.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Ejercicio3 extends AppCompatActivity {

    private EditText txtNombreE1, txtApellidoE1, txtHorasE1;
    private EditText txtNombreE2, txtApellidoE2, txtHorasE2;
    private EditText txtNombreE3, txtApellidoE3, txtHorasE3;
    private Spinner txtCargoE1, txtCargoE2, txtCargoE3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        txtNombreE1 = (EditText) findViewById(R.id.inputNombreE1);
        txtApellidoE1 = (EditText) findViewById(R.id.inputApellidoE1);
        txtHorasE1 = (EditText) findViewById(R.id.inputHorasE1);

        txtNombreE2 = (EditText) findViewById(R.id.inputNombreE2);
        txtApellidoE2 = (EditText) findViewById(R.id.inputApellidoE2);
        txtHorasE2 = (EditText) findViewById(R.id.inputHorasE2);

        txtNombreE3 = (EditText) findViewById(R.id.inputNombreE3);
        txtApellidoE3 = (EditText) findViewById(R.id.inputApellidoE3);
        txtHorasE3 = (EditText) findViewById(R.id.inputHorasE3);

        // Relacionando variables de cargo a spinner
        txtCargoE1 = (Spinner) findViewById(R.id.spinnerE1);
        txtCargoE2 = (Spinner) findViewById(R.id.spinnerE2);
        txtCargoE3 = (Spinner) findViewById(R.id.spinnerE3);

        //  Creando las opciones en los spinner
        String []opciones = {"Gerente", "Asistente", "Secretaria", "Otro"};
        ArrayAdapter <String>adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_ejercicio3, opciones);

        //  Haciendo referencia al objeto adapter
        txtCargoE1.setAdapter(adapter);
        txtCargoE2.setAdapter(adapter);
        txtCargoE3.setAdapter(adapter);
    }

    //  Redireccionamiento a pantalla de resultados del ejercicio

    public void pantallaResultados(View view){

        // Validación que todos los campos estén completos
        if(txtNombreE1.getText().toString().equals("") || txtApellidoE1.getText().toString().equals("") || txtHorasE1.getText().toString().equals("") || txtNombreE2.getText().toString().equals("") || txtApellidoE2.getText().toString().equals("") || txtHorasE2.getText().toString().equals("") || txtNombreE3.getText().toString().equals("") || txtApellidoE3.getText().toString().equals("") || txtHorasE3.getText().toString().equals(""))
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
        else {
            int horasE1 = Integer.parseInt(txtHorasE1.getText().toString());
            int horasE2 = Integer.parseInt(txtHorasE2.getText().toString());
            int horasE3 = Integer.parseInt(txtHorasE3.getText().toString());

            if (horasE1 <= 0 || horasE2 <= 0 || horasE3 <= 0) {
                Toast.makeText(this, "Las horas no deben ser negativas o 0", Toast.LENGTH_SHORT).show();
            } else {
                Intent cambio = new Intent(this, Ejercicio3Resultados.class);

                cambio.putExtra("txtNombreE1", txtNombreE1.getText().toString());
                cambio.putExtra("txtApellidoE1", txtApellidoE1.getText().toString());
                cambio.putExtra("txtHorasE1", txtHorasE1.getText().toString());
                cambio.putExtra("txtCargoE1", txtCargoE1.getSelectedItem().toString());

                cambio.putExtra("txtNombreE2", txtNombreE2.getText().toString());
                cambio.putExtra("txtApellidoE2", txtApellidoE2.getText().toString());
                cambio.putExtra("txtHorasE2", txtHorasE2.getText().toString());
                cambio.putExtra("txtCargoE2", txtCargoE2.getSelectedItem().toString());

                cambio.putExtra("txtNombreE3", txtNombreE3.getText().toString());
                cambio.putExtra("txtApellidoE3", txtApellidoE3.getText().toString());
                cambio.putExtra("txtHorasE3", txtHorasE3.getText().toString());
                cambio.putExtra("txtCargoE3", txtCargoE3.getSelectedItem().toString());

                startActivity(cambio);
            }
        }
    }

    //  Redireccionamiento a pantalla de Menu

    public void pantallaMenu(View view){
        Intent cambio = new Intent(this, Menu.class);
        startActivity(cambio);
    }
}