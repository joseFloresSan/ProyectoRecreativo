package com.example.login.CONTROLADOR;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import com.example.login.BEAN.usuariobean;
import com.example.login.DAO.usuariodao;
import com.example.login.PRINCIPAL.frmloginadmin;
import com.example.login.PRINCIPAL.frmprincipalpersonal;

public class personalcontrolador extends Service {
    public personalcontrolador() {

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
                    Intent objIntentepersonal = new Intent(personalcontrolador.this, frmloginadmin.class);
                    startActivity(objIntentepersonal);
                    break;
                }

                case 2:{
                    usuariobean objusuario=(usuariobean)objBundle.getSerializable("datos");
                    String usuario=objusuario.getUsuario();
                    String password=objusuario.getPassword();

                    usuariobean objusubean=new usuariobean();
                                objusubean.setUsuario(usuario);
                                objusubean.setPassword(password);
                                objusubean.setTipousuario("2");
                    usuariodao objusudao=new usuariodao();
                    boolean estado=objusudao.ValidarUsuario(objusubean);

                    if (estado){
                        Intent objIntentpersonal=new Intent(personalcontrolador.this, frmprincipalpersonal.class);
                        startActivity(objIntentpersonal);
                    }else {
                        Intent objIntentpersonal=new Intent(personalcontrolador.this, frmloginadmin.class);
                        Bundle obj=new Bundle();
                        objBundle.putString("msj","Usuario y clave incorrecto");
                        objIntentpersonal.putExtras(objBundle);
                        startActivity(objIntentpersonal);
                    }
                    break;


                }
            }



    }
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
