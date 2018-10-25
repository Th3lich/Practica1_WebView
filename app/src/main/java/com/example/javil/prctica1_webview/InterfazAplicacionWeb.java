package com.example.javil.prctica1_webview;

import android.util.Log;
import android.webkit.JavascriptInterface;


public class InterfazAplicacionWeb {
    private String usuario, clave;

    public InterfazAplicacionWeb() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @JavascriptInterface
    public void sendData(String usuario, String clave) {
        setUsuario(usuario);
        setClave(clave);
    }
}
