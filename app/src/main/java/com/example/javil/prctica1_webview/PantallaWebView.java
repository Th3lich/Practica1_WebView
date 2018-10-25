package com.example.javil.prctica1_webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PantallaWebView extends Activity{

    static final String TAG = "MITAG";
    private WebView miwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);


        String message = getIntent().getStringExtra(ActividadPrincipal.url);

        miwebView = findViewById(R.id.wvMoodle);

        miwebView.getSettings().setJavaScriptEnabled(true);
        InterfazAplicacionWeb iaw = new InterfazAplicacionWeb();
        miwebView.addJavascriptInterface(iaw, "puente");
        miwebView.loadUrl(message);

        miwebView.setWebViewClient(new WebViewClient() {
            private static final String CLAVE ="CLAVE   ";
            int contador = 0;
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.v(TAG, url);
                String username = getIntent().getStringExtra("usuario");
                String password = getIntent().getStringExtra("contrasena");
                int clave = getIntent().getIntExtra("clave", 0);

                    Log.v(CLAVE, String.valueOf(clave));
                    final String javaScript = "" +
                            "var boton = document.getElementById('loginbtn');\n" +
                            "var nombre = document.getElementById('username');\n" +
                            "var clave  = document.getElementById('password');\n" +
                            "nombre.value = '"+username+"';\n" +
                            "clave.value = '"+password+"';\n" +
                            "boton.click();\n";
                    miwebView.loadUrl("javascript: " + javaScript);
                    Log.v(TAG, javaScript);

                if(miwebView.getUrl().compareTo("http://www.juntadeandalucia.es/averroes/centros-tic/18700098/moodle2/") == 0 && clave == 1){
                    Log.v(TAG, "ENTRA");
                    SharedPreferences prefs =
                                getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("usuario",username);
                    editor.putString("contrasena",password);
                    editor.commit();
                }
            }
        });
    }
}
