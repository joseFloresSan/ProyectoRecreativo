package com.example.login.PRINCIPAL;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.login.BEAN.alumnobean;
import com.example.login.DAO.alumnodao;
import com.example.login.R;

import java.util.ArrayList;

public class frmresgistraralumno extends AppCompatActivity {
    private alumnodao objalumnodao;
    EditText txtnombre,txtapellido,txtcorreo,txtdireccion,txtusuario,txtcontraseña;
    ImageButton btnregresar;
    ArrayList<alumnobean> lista=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frmresgistraralumno);
        txtnombre=(EditText)findViewById(R.id.txtnombrealum);
        txtapellido=(EditText)findViewById(R.id.txtapellidoalum);
        txtcorreo=(EditText)findViewById(R.id.txtcorreoalum);
        txtdireccion=(EditText)findViewById(R.id.txtdireccionalum);
        txtusuario=(EditText)findViewById(R.id.txtusuarioalum);
        txtcontraseña=(EditText)findViewById(R.id.txtcontraseñaalum);


        objalumnodao=new alumnodao(this);
        objalumnodao.open();
    }
    public void Grabar(View v){
        String nombre=txtnombre.getText().toString();
        String apellido=txtapellido.getText().toString();
        String correo=txtcorreo.getText().toString();
        String direccion=txtdireccion.getText().toString();
        String usuario=txtusuario.getText().toString();
        String contraseña=txtcontraseña.getText().toString();
        long i=0;
        i=objalumnodao.Insertar(nombre,apellido,correo,direccion,usuario,contraseña);
        if ((i==0)){
            Toast.makeText(getApplicationContext(),"Registro No Insertado",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Registro Insertado",Toast.LENGTH_LONG).show();
            txtnombre.setText("");
            txtapellido.setText("");
            txtcorreo.setText("");
            txtdireccion.setText("");
            txtusuario.setText("");
            txtcontraseña.setText("");
            txtnombre.requestFocus();

        }
    }
    public void cargarTabla(View v){
        String acum="";
        try {
            lista=objalumnodao.ListadoGeneral();
            for (alumnobean obj:lista){
                acum+=obj.getNombre()+""+obj.getApellido()+""+obj.getCorreo()+""+obj.getDireccion()+""+obj.getUsuario()+""+obj.getContraseña()+"\n";
            }
            Toast.makeText(getApplicationContext(),acum,Toast.LENGTH_LONG).show();

        }catch (Exception e){

        }
    }
    public void regresar(View v){
        Intent objregresar=new Intent(frmresgistraralumno.this,frmprincipalpersonal.class);
        startActivity(objregresar);
    }



}
