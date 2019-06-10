package com.example.proyectodocente.ControladorRecursos;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.proyectodocente.principalCuentos;

public class ControladorRecurso extends Service {
    public ControladorRecurso() {
    }

    public void onCreate(){
        super.onCreate();
        Intent objCuento=new Intent(ControladorRecurso.this,principalCuentos.class);
        startActivity(objCuento);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
