package com.example.login.PRINCIPAL;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.login.BEAN.usuariobean;
import com.example.login.CONTROLADOR.estudiantecontrolador;
import com.example.login.R;

import java.io.Serializable;

public class frmloginestudiante extends AppCompatActivity implements View.OnClickListener{
    EditText txtusuarioestudiante,txtcontraseñaestudiante;
    Button btnentrarestudiante;
    TextView lblmensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frmloginestudiante);
        txtusuarioestudiante=(EditText)findViewById(R.id.txtUsuarioEstudiante);
        txtcontraseñaestudiante=(EditText)findViewById(R.id.txtContraseñaEstudiante);
        btnentrarestudiante=(Button)findViewById(R.id.btnentrar);
        btnentrarestudiante.setOnClickListener(this);

    }
    public  void entrar(){
        String usuario,password;
        usuario=txtusuarioestudiante.getText().toString();
        password=txtcontraseñaestudiante.getText().toString();

        usuariobean objusuario=new usuariobean();
                    objusuario.setUsuario(usuario);
                    objusuario.setPassword(password);

        Intent objIntentestudiante=new Intent(frmloginestudiante.this, estudiantecontrolador.class);
        Bundle objBundle=new Bundle();
               objBundle.putSerializable("datos",objusuario);
               objBundle.putString("op","2");
               objIntentestudiante.putExtras(objBundle);

        startService(objIntentestudiante);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v==btnentrarestudiante)
            {
                entrar();
            }

    }
}
