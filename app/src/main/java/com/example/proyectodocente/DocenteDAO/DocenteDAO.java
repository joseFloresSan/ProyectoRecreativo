package com.example.proyectodocente.DocenteDAO;

import com.example.proyectodocente.DocenteBean.DocBean;

public class DocenteDAO {
    //Datos de acceso al docente
    String usuarioDoc[]={"docente"};
    String passDoce[]={"123"};


    public boolean validarDocente(DocBean objDocente){
        boolean estado=false;

        //int op=Integer.parseInt(objDocente.getUsuarioDocente());

        try{
            for(int i=0;i<usuarioDoc.length;i++){
                if(objDocente.getUsuarioDocente()=="docente" && objDocente.getPassDocente()=="123"){
                    estado=true;
                }
            }
        }catch (Exception e){
            estado=false;

        }
        return estado;
    }

}
