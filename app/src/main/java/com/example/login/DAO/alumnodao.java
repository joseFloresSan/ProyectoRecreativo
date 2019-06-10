package com.example.login.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.login.BEAN.alumnobean;
import com.example.login.DATABASE.mysqlihelper;

import java.util.ArrayList;

public class alumnodao {
    private SQLiteDatabase database;
    private mysqlihelper dhHelper;
    public alumnodao(Context context){
        dhHelper=new mysqlihelper(context);
    }
    public void open()throws SQLException{
        database=dhHelper.getWritableDatabase();
    }
    public void close(){
        dhHelper.close();
    }
    public long Insertar(String nom,String apelli,String correo,String dir,String usuario,String contra){
        long estado=0;
        try {
            ContentValues valores=new ContentValues();
            valores.put("nombre",nom);
            valores.put("apellido",apelli);
            valores.put("correo",correo);
            valores.put("direccion",dir);
            valores.put("usuario",usuario);
            valores.put("contraseña",contra);
            estado=database.insert(mysqlihelper.NOMBRETABLA,null,valores);
        }catch (Exception e){
            estado=0;
        } return estado;
    }
    public ArrayList<alumnobean> ListadoGeneral(){
        Cursor c;
        ArrayList<alumnobean> listado=new ArrayList<alumnobean>();
        c=database.rawQuery("SELECT*FROM alumno",null);
        while (c.moveToNext()){
            alumnobean objpersona=new alumnobean();
                       objpersona.setCodigo(c.getInt(0));
                       objpersona.setNombre(c.getString(1));
                       objpersona.setApellido(c.getString(2));
                       objpersona.setCorreo(c.getString(3));
                       objpersona.setDireccion(c.getString(4));
                       objpersona.setUsuario(c.getString(5));
                       objpersona.setContraseña(c.getString(6));
            listado.add(objpersona);
        }
        c.close();
        return listado;
    }

}
