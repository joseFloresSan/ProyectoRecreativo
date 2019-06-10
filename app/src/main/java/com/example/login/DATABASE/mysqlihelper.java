package com.example.login.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class mysqlihelper extends SQLiteOpenHelper {
    public static final String NOMBRETABLA="alumno";
    private static final String NOMBREBASEDATOS="BDCJAVA.db";
    private static final int VERSION=1;

    private static final String SQLBD="create table "+NOMBRETABLA+
            "(codigo integer primary key autoincrement,"+
            "nombre text not null,apellido text not null,correo text not null,direccion text not null,usuario text not null,contraseña text not null);";
    public mysqlihelper(Context contexto){
        super(contexto,NOMBREBASEDATOS,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLBD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(mysqlihelper.class.getName(),
                "Actualizando la version de la Base de datos Numero:"+ oldVersion+"a"+ newVersion);
        db.execSQL("DROP TABLE IF EXISTS "+NOMBRETABLA);
        onCreate(db);
    }
}
