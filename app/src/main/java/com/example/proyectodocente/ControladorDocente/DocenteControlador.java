package com.example.proyectodocente.ControladorDocente;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.proyectodocente.loginDocente;
import com.example.proyectodocente.principalDocente;

public class DocenteControlador extends Service {
    public DocenteControlador() {
    }

    public void onCreate(){
        super.onCreate();
        Intent objDocente=new Intent(DocenteControlador.this, principalDocente.class);
        startActivity(objDocente);
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
