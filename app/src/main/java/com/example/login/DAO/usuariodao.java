package com.example.login.DAO;

import com.example.login.BEAN.usuariobean;

public class usuariodao {

    String usuarioestu[]={"jose","flores"};
    String passwordestu[]={"123","147"};

    String usuarioadmin[]={"jos","flor"};
    String passwordadmin[]={"123","147"};

    String usuariodocente[]={"jo","res"};
    String passworddocente[]={"321","147"};

public boolean ValidarUsuario(usuariobean objusuariobean)    {
    boolean estado=false;
    int op=Integer.parseInt(objusuariobean.getTipousuario());
    try {
        switch (op){
            case 1:{
                for (int i=0;i<usuarioadmin.length;i++){
                    if (objusuariobean.getUsuario().equals(usuarioadmin[i])&&
                        objusuariobean.getPassword().equals(passwordadmin[i])){
                        estado=true;
                        break;
                    }
                }
                break;
            }
            case 2:{
                for (int i=0;i<usuariodocente.length;i++){
                    if (objusuariobean.getUsuario().equals(usuariodocente[i])&&
                            objusuariobean.getPassword().equals(passworddocente[i])){
                        estado=true;
                        break;
                    }
                }
                break;
            }
            case 3:{
                for (int i=0;i<usuarioestu.length;i++){
                    if (objusuariobean.getUsuario().equals(usuarioestu[i])&&
                            objusuariobean.getPassword().equals(passwordestu[i])){
                        estado=true;
                        break;
                    }
                }
                break;
            }
        }
    }
    catch (Exception e){
        estado=false;
    }
    return estado;
}

}
