package edu.udb.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio2 extends AppCompatActivity {

    private EditText txtCandidatos, txtVotos;
    private TextView etResultadoVotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        txtCandidatos = (EditText) findViewById(R.id.inputCandidatos);
        txtVotos = (EditText) findViewById(R.id.inputVotos);
        etResultadoVotos = (TextView) findViewById(R.id.etiquetaResultadoVotos);
    }

    public void calculoVotos(View view){
        String candidatos = txtCandidatos.getText().toString();
        String votos = txtVotos.getText().toString();

        int cantidadVotos = 0;
        double cantidadPorcentaje = 0;

        //  Verificamos que los campos estén llenos
        if(candidatos.equals("") || votos.equals(""))
        {
            Toast.makeText(this, "Por favor llene los campos", Toast.LENGTH_SHORT).show();
            etResultadoVotos.setText("");
        }
        else {

            // Convirtiendo las cadenas de string a un arreglo
            String[] arregloCandidatos = candidatos.split(",");
            String[] arregloVotos = votos.split(",");

            int totalVotos = arregloVotos.length;

            String textoResultado = "";

            for (int i = 0; i < arregloCandidatos.length; i++) {
                for (int j = 0; j < arregloVotos.length; j++) {
                    if (arregloVotos[j].equals(arregloCandidatos[i])) {
                        cantidadVotos++;
                    }
                }
                cantidadPorcentaje = (cantidadVotos * 100) / totalVotos;
                textoResultado += "Candidato: " + arregloCandidatos[i] + " | Votos: " + cantidadVotos + " | Porcentaje: " + cantidadPorcentaje + "%\n";
                cantidadVotos = 0;
            }

            etResultadoVotos.setText(textoResultado);
        }
    }

    // Redireccionamiento a menú
    public void pantallaMenu(View view){
        Intent cambio = new Intent(this, Menu.class);
        startActivity(cambio);
    }
}