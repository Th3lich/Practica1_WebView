package com.example.javil.prctica1_webview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActividadPrincipal extends AppCompatActivity {

    public static final String url = "";
    public static final String usuario = "";
    public static final String contraseña = "";
    EditText edt1, edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        edt1 = findViewById(R.id.usuario);
        edt2 = findViewById(R.id.contraseña);


        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);

        String usuario = prefs.getString("usuario", "");
        String contrasena = prefs.getString("contrasena", "");

        if(!usuario.isEmpty() && !contrasena.isEmpty()){
            Intent intent = new Intent(this, PantallaWebView.class);
            intent.putExtra(url, "http://www.juntadeandalucia.es/averroes/centros-tic/18700098/moodle2/login/index.php");
            intent.putExtra("usuario", usuario);
            intent.putExtra("contrasena", contrasena);
            startActivity(intent);
        }


        /*try {
            InputStream is = this.getResources().openRawResource(R.raw.data);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            if (!reader.readLine().isEmpty()) {
                usuario = reader.readLine();
                contraseña = reader.readLine();
            }
        }catch (IOException ex){

        }*/
    }

    public void GuardarDatos(View view){

        Intent intent = new Intent(this, PantallaWebView.class);
        intent.putExtra(url, "http://www.juntadeandalucia.es/averroes/centros-tic/18700098/moodle2/login/index.php");
        intent.putExtra("usuario", edt1.getText().toString());
        intent.putExtra("contrasena", edt2.getText().toString());
        intent.putExtra("clave", 1);
        startActivity(intent);
    }

    public void noGuardarDatos(View view){

        Intent intent = new Intent(this, PantallaWebView.class);
        intent.putExtra(url, "http://www.juntadeandalucia.es/averroes/centros-tic/18700098/moodle2/login/index.php");
        intent.putExtra("usuario", edt1.getText().toString());
        intent.putExtra("contrasena", edt2.getText().toString());
        intent.putExtra("clave", 0);
        startActivity(intent);
    }
}
