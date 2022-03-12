package edu.udb.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {

    private EditText txtNumeroA, txtNumeroB, txtNumeroC;
    private TextView numeroX1, numeroX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        txtNumeroA = (EditText) findViewById(R.id.inputValorA);
        txtNumeroB = (EditText) findViewById(R.id.inputValorB);
        txtNumeroC = (EditText) findViewById(R.id.inputValorC);

        numeroX1 = (TextView) findViewById(R.id.etiquetaNumero1);
        numeroX2 = (TextView) findViewById(R.id.etiquetaNumero2);

    }

    public void calcular(View view){

        //  Verificamos que los campos estén llenos
        if(txtNumeroA.getText().toString().equals("") || txtNumeroB.getText().toString().equals("") || txtNumeroC.getText().toString().equals(""))
        {
            Toast.makeText(this, "Por favor llene los campos", Toast.LENGTH_SHORT).show();

            numeroX1.setText("");
            numeroX2.setText("");
        }
        else {
            double valorA = Double.parseDouble(txtNumeroA.getText().toString());
            double valorB = Double.parseDouble(txtNumeroB.getText().toString());
            double valorC = Double.parseDouble(txtNumeroC.getText().toString());

            double op1 = Math.pow(valorB, 2) - (4 * valorA * valorC);

            //  Verificamos que la operación dentro de la raíz no sea un número negativo
            if(op1 < 0)
            {
                Toast.makeText(this, "No es posible calcular la raíz cuadrada de un número negativo", Toast.LENGTH_SHORT).show();

                numeroX1.setText("0");
                numeroX2.setText("0");
            }
            else {
                double op2 = Math.sqrt(op1);
                double op3 = 2 * valorA;

                //  Verificamos que el denominador no sea 0
                if(op3 == 0)
                {
                    Toast.makeText(this, "No es posible dividir entre 0", Toast.LENGTH_SHORT).show();
                    numeroX1.setText("0");
                    numeroX2.setText("0");
                }
                else {
                    double valorX1 = ((-1 * valorB) + op2) / op3;
                    double valorX2 = ((-1 * valorB) - op2) / op3;

                    numeroX1.setText(Double.toString(valorX1));
                    numeroX2.setText(Double.toString(valorX2));
                }
            }
        }

    }


    // Redireccionamiento al menú
    public void pantallaMenu(View view){
        Intent cambio = new Intent(this, Menu.class);
        startActivity(cambio);
    }
}