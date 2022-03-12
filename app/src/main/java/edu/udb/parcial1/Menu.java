package edu.udb.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    // Direccionamiento a pantalla de primer ejercicio (función cuadrática)
    public void pantallaEjercicio1 (View view){
        Intent cambio = new Intent(this, Ejercicio1.class);
        startActivity(cambio);
    }

    // Direccionamiento a pantalla de segundo ejercicio (contador de votos)
    public void pantallaEjercicio2 (View view){
        Intent cambio = new Intent(this, Ejercicio2.class);
        startActivity(cambio);
    }

    // Direccionamiento a pantalla de tercer ejercicio (sueldos de empleados)
    public void pantallaEjercicio3 (View view){
        Intent cambio = new Intent(this, Ejercicio3.class);
        startActivity(cambio);
    }

    // Direccionamiento a pantalla de inicio de sesión
    public void cerrarSesion (View view){
        Intent cambio = new Intent(this, MainActivity.class);
        startActivity(cambio);
    }
}