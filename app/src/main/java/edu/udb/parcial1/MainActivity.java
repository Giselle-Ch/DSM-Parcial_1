package edu.udb.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario, txtContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = (EditText) findViewById(R.id.inputLoginUsuario);
        txtContrasena = (EditText) findViewById(R.id.inputLoginContrasena);
    }

    public void iniciarSesion(View view){
        String usu = txtUsuario.getText().toString();
        String cont = txtContrasena.getText().toString();

        // Verificando que los campos no estén vacíos
        if(usu.equals("") || cont.equals(""))
        {
            Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
        }
        else {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "login", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            Cursor fila = db.rawQuery("select * from usuarios where usuario='" + usu + "' and contrasena='" + cont + "'", null);

            if (fila.getCount() > 0) {
                Intent cambio = new Intent(this, Menu.class);
                startActivity(cambio);
            } else {
                Toast.makeText(this, "Las credenciales estan incorrectas o el usuario ingresado no existe", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Redireccionamiento a pantalla de registro de usuarios
    public void pantallaRegistro(View view){
        Intent cambio = new Intent(this, RegistroUsuarios.class);
        startActivity(cambio);
    }
}