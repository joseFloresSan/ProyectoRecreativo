package com.example.login.CONTROLADOR;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import com.example.login.BEAN.usuariobean;
import com.example.login.DAO.usuariodao;
import com.example.login.PRINCIPAL.frmloginestudiante;
import com.example.login.PRINCIPAL.frmprincipalestudiante;

public class estudiantecontrolador extends Service {
    public estudiantecontrolador() {
    }
    @Override
    public void onStart(Intent intent,int starId){
        super.onStart(intent,starId);
        String opcad;
        int op;
            Bundle objBundle=intent.getExtras();
            opcad=objBundle.getString("op");

            op=Integer.parseInt(opcad);
            switch (op){
                case 1: {
                    Intent objIntentestudiante = new Intent(estudiantecontrolador.this, frmloginestudiante.class);
                    startActivity(objIntentestudiante);
                    break;
                }

                case 2:{
                    usuariobean objusuario=(usuariobean)objBundle.getSerializable("datos");
                    String usuario=objusuario.getUsuario();
                    String password=objusuario.getPassword();

                    usuariobean objusubean=new usuariobean();
                                objusubean.setUsuario(usuario);
                                objusubean.setPassword(password);
                                objusubean.setTipousuario("3");
                    usuariodao objusudao=new usuariodao();
                    boolean estado=objusudao.ValidarUsuario(objusubean);

                    if (estado){
                        Intent objIntentestudiante=new Intent(estudiantecontrolador.this, frmprincipalestudiante.class);
                        startActivity(objIntentestudiante);
                    }else {
                        Intent objIntentestudiante=new Intent(estudiantecontrolador.this,frmloginestudiante.class);
                        Bundle obj=new Bundle();
                        objBundle.putString("msj","Usuario y clave incorrecto");
                        objIntentestudiante.putExtras(objBundle);
                        startActivity(objIntentestudiante);
                    }
                    break;


                }
            }



    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
