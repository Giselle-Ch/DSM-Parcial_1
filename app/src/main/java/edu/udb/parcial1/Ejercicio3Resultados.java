package edu.udb.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio3Resultados extends AppCompatActivity {

    private TextView etNombreE1, etCargoE1, etISSSE1, etAFPE1, etRentaE1, etSueldoTotalE1;
    private TextView etNombreE2, etCargoE2, etISSSE2, etAFPE2, etRentaE2, etSueldoTotalE2;
    private TextView etNombreE3, etCargoE3, etISSSE3, etAFPE3, etRentaE3, etSueldoTotalE3;
    private TextView etMayorSueldo, etMenorSueldo, etCantidad, etBonos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3_resultados);

        etNombreE1 = (TextView) findViewById(R.id.etiquetaEmpleado1);
        etCargoE1 = (TextView) findViewById(R.id.etiquetaCargoE1);
        etISSSE1 = (TextView) findViewById(R.id.etiquetaISSSE1);
        etAFPE1 = (TextView) findViewById(R.id.etiquetaAFPE1);
        etRentaE1 = (TextView) findViewById(R.id.etiquetaRentaE1);
        etSueldoTotalE1 = (TextView) findViewById(R.id.etiquetaSueldoTotalE1);

        etNombreE2 = (TextView) findViewById(R.id.etiquetaEmpleado2);
        etCargoE2 = (TextView) findViewById(R.id.etiquetaCargoE2);
        etISSSE2 = (TextView) findViewById(R.id.etiquetaISSSE2);
        etAFPE2 = (TextView) findViewById(R.id.etiquetaAFPE2);
        etRentaE2 = (TextView) findViewById(R.id.etiquetaRentaE2);
        etSueldoTotalE2 = (TextView) findViewById(R.id.etiquetaSueldoTotalE2);

        etNombreE3 = (TextView) findViewById(R.id.etiquetaEmpleado3);
        etCargoE3 = (TextView) findViewById(R.id.etiquetaCargoE3);
        etISSSE3 = (TextView) findViewById(R.id.etiquetaISSSE3);
        etAFPE3 = (TextView) findViewById(R.id.etiquetaAFPE3);
        etRentaE3 = (TextView) findViewById(R.id.etiquetaRentaE3);
        etSueldoTotalE3 = (TextView) findViewById(R.id.etiquetaSueldoTotalE3);

        etMayorSueldo = (TextView) findViewById(R.id.etiquetaMayorSueldo);
        etMenorSueldo = (TextView) findViewById(R.id.etiquetaMenorSueldo);
        etCantidad = (TextView) findViewById(R.id.etiquetaCantidad);
        etBonos = (TextView) findViewById(R.id.etiquetaBonos);

        //  Extracción de datos de pantalla Ejercicio3
        Bundle bundle = getIntent().getExtras();

        String nombreE1 = bundle.getString("txtNombreE1");
        String apellidoE1 = bundle.getString("txtApellidoE1");
        String cantHorasE1 = bundle.getString("txtHorasE1");
        String cargoE1 = bundle.getString("txtCargoE1");
        int horasE1 = Integer.parseInt(cantHorasE1);

        String nombreE2 = bundle.getString("txtNombreE2");
        String apellidoE2 = bundle.getString("txtApellidoE2");
        String cantHorasE2 = bundle.getString("txtHorasE2");
        String cargoE2 = bundle.getString("txtCargoE2");
        int horasE2 = Integer.parseInt(cantHorasE2);

        String nombreE3 = bundle.getString("txtNombreE3");
        String apellidoE3 = bundle.getString("txtApellidoE3");
        String cantHorasE3 = bundle.getString("txtHorasE3");
        String cargoE3 = bundle.getString("txtCargoE3");
        int horasE3 = Integer.parseInt(cantHorasE3);

        //  Calculos

        double sueldoBaseE1 = 0, bonoE1 = 0, sueldoTotalE1 = 0;
        double sueldoBaseE2 = 0, bonoE2 = 0, sueldoTotalE2 = 0;
        double sueldoBaseE3 = 0, bonoE3 = 0, sueldoTotalE3 = 0;

        // -------- Sueldo Base

        if(horasE1 <= 160)                                      // Empleado 1
            sueldoBaseE1 = horasE1 * 9.75;
        else
            sueldoBaseE1 = 1560 + ((horasE1 - 160) * 11.5);    // 160 h * $9.75 = 1,560

        if(horasE2 <= 160)                                      // Empleado 2
            sueldoBaseE2 = horasE2 * 9.75;
        else
            sueldoBaseE2 = 1560 + ((horasE2 - 160) * 11.5);

        if(horasE3 <= 160)                                      // Empleado 3
            sueldoBaseE3 = horasE3 * 9.75;
        else
            sueldoBaseE3 = 1560 + ((horasE3 - 160) * 11.5);

        // -------- Descuentos

        double isssE1 = sueldoBaseE1 * 0.0525;      // Empleado 1
        double afpE1 = sueldoBaseE1 * 0.0688;
        double rentaE1 = sueldoBaseE1 * 0.1;

        double isssE2 = sueldoBaseE2 * 0.0525;      // Empleado 2
        double afpE2 = sueldoBaseE2 * 0.0688;
        double rentaE2 = sueldoBaseE2 * 0.1;

        double isssE3 = sueldoBaseE3 * 0.0525;      // Empleado 3
        double afpE3 = sueldoBaseE3 * 0.0688;
        double rentaE3 = sueldoBaseE3 * 0.1;

        // -------- Sueldo líquido

        double sueldoLiquidoE1 = sueldoBaseE1 - (isssE1 + afpE1 + rentaE1);
        double sueldoLiquidoE2 = sueldoBaseE2 - (isssE2 + afpE2 + rentaE2);
        double sueldoLiquidoE3 = sueldoBaseE3 - (isssE3 + afpE3 + rentaE3);

        // -------- Bono

        // Verificamos que no se obtenga bono con la secuencia 1-Gerente 2-Asistente 3-Secretaria
        if(cargoE1.equals("Gerente") && cargoE2.equals("Asistente") && cargoE3.equals("Secretaria"))
        {
            bonoE1 = 0;
            bonoE2 = 0;
            bonoE3 = 0;

            etBonos.setText("NO HAY BONOS");
        } else {

            etBonos.setText(" ");

            if(cargoE1.equals("Gerente"))               // Empleado 1
                bonoE1 = sueldoBaseE1 * 0.1;
            if(cargoE1.equals("Asistente"))
                bonoE1 = sueldoBaseE1 * 0.05;
            if(cargoE1.equals("Secretaria"))
                bonoE1 = sueldoBaseE1 * 0.03;
            if(cargoE1.equals("Otro"))
                bonoE1 = sueldoBaseE1 * 0.02;

            if(cargoE2.equals("Gerente"))               // Empleado 2
                bonoE2 = sueldoBaseE2 * 0.1;
            else if(cargoE2.equals("Asistente"))
                bonoE2 = sueldoBaseE2 * 0.05;
            else if(cargoE2.equals("Secretaria"))
                bonoE2 = sueldoBaseE2 * 0.03;
            else if(cargoE2.equals("Otro"))
                bonoE2 = sueldoBaseE2 * 0.02;

            if(cargoE3.equals("Gerente"))               // Empleado 3
                bonoE3 = sueldoBaseE3 * 0.1;
            else if(cargoE3.equals("Asistente"))
               bonoE3 = sueldoBaseE3 * 0.05;
            else if(cargoE3.equals("Secretaria"))
                bonoE3 = sueldoBaseE3 * 0.03;
            else if(cargoE3.equals("Otro"))
                bonoE3 = sueldoBaseE3 * 0.02;
        }

        // -------- Sueldos Totales

        sueldoTotalE1 = sueldoLiquidoE1 + bonoE1;
        sueldoTotalE2 = sueldoLiquidoE2 + bonoE2;
        sueldoTotalE3 = sueldoLiquidoE3 + bonoE3;

        // -------- Comparaciones

        // Si todos tienen igual sueldo
        if(sueldoTotalE1 == sueldoTotalE2 && sueldoTotalE1 == sueldoTotalE3)
        {
            etMayorSueldo.setText("-");
            etMenorSueldo.setText("-");
            Toast.makeText(this, "Todos tienen el mismo sueldo", Toast.LENGTH_SHORT).show();
        }

        // Mayor sueldo
        if(sueldoTotalE1 > sueldoTotalE2 && sueldoTotalE1 > sueldoTotalE3)
            etMayorSueldo.setText(nombreE1 + " " + apellidoE1);
        else if(sueldoTotalE2 > sueldoTotalE1 && sueldoTotalE2 > sueldoTotalE3)
            etMayorSueldo.setText(nombreE2 + " " + apellidoE2);
        else
            etMayorSueldo.setText(nombreE3 + " " + apellidoE3);

        // Menor Sueldo
        if(sueldoTotalE1 < sueldoTotalE2 && sueldoTotalE1 < sueldoTotalE3)
            etMenorSueldo.setText(nombreE1 + " " + apellidoE1);
        else if(sueldoTotalE2 < sueldoTotalE1 && sueldoTotalE2 < sueldoTotalE3)
            etMenorSueldo.setText(nombreE2 + " " + apellidoE2);
        else
            etMenorSueldo.setText(nombreE3 + " " + apellidoE3);

        // Más de $300
        if(sueldoTotalE1 > 300 && sueldoTotalE2 > 300 && sueldoTotalE3 > 300)
            etCantidad.setText("3");
        else if((sueldoTotalE1 > 300 && sueldoTotalE2 > 300) || (sueldoTotalE1 > 300 && sueldoTotalE3 > 300) || (sueldoTotalE2 > 300 && sueldoTotalE3 > 300))
            etCantidad.setText("2");
        else if(sueldoTotalE1 > 300 || sueldoTotalE2 > 300 || sueldoTotalE3 > 300)
            etCantidad.setText("1");
        else
            etCantidad.setText("-");


        //  Imprimir resultados

        etNombreE1.setText(nombreE1 + " " + apellidoE1);        // Empleado 1
        etCargoE1.setText(cargoE1);
        etISSSE1.setText("$" + isssE1);
        etAFPE1.setText("$" + afpE1);
        etRentaE1.setText("$" + rentaE1);
        etSueldoTotalE1.setText("$" + sueldoTotalE1);

        etNombreE2.setText(nombreE2 + " " + apellidoE2);        // Empleado 2
        etCargoE2.setText(cargoE2);
        etISSSE2.setText("$" + isssE2);
        etAFPE2.setText("$" + afpE2);
        etRentaE2.setText("$" + rentaE2);
        etSueldoTotalE2.setText("$" + sueldoTotalE2);

        etNombreE3.setText(nombreE3 + " " + apellidoE3);        // Empleado 3
        etCargoE3.setText(cargoE3);
        etISSSE3.setText("$" + isssE3);
        etAFPE3.setText("$" + afpE3);
        etRentaE3.setText("$" + rentaE3);
        etSueldoTotalE3.setText("$" + sueldoTotalE3);

    }

    public void pantallaEjercicio3(View view){
        Intent cambio = new Intent(this, Ejercicio3.class);
        startActivity(cambio);
    }

    public void pantallaMenu(View view){
        Intent cambio = new Intent(this, Menu.class);
        startActivity(cambio);
    }
}