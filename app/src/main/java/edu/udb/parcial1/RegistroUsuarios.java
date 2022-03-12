package edu.udb.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class RegistroUsuarios extends AppCompatActivity {

    private EditText txtUsuario, txtContrasena, txtReContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        txtUsuario = (EditText) findViewById(R.id.inputUsuario);
        txtContrasena = (EditText) findViewById(R.id.inputContrasena);
        txtReContrasena = (EditText) findViewById(R.id.inputReContrasena);
    }

    public void registrarUsuario(View view){

        String usuario = txtUsuario.getText().toString();
        String cont = txtContrasena.getText().toString();
        String reCont = txtReContrasena.getText().toString();

        // Verificando que los campos no estén vacíos
        if(usuario.equals("") || cont.equals("") || reCont.equals(""))
            Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();

        if(reCont.equals(cont))
        {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "login", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            ContentValues registro = new ContentValues();

            registro.put("usuario", usuario);
            registro.put("contrasena", cont);

            db.insert("usuarios", null, registro);

            db.close();

            txtUsuario.setText("");
            txtContrasena.setText("");
            txtReContrasena.setText("");

            Toast.makeText(this, "Se ha registrado el nuevo usuario", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }

    }

    public void finalizarActividad(View view){
        finish();
    }
}