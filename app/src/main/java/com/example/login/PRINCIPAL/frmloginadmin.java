package com.example.login.PRINCIPAL;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.login.BEAN.usuariobean;
import com.example.login.CONTROLADOR.personalcontrolador;
import com.example.login.R;

public class frmloginadmin extends AppCompatActivity implements View.OnClickListener{
    EditText txtUsuariopersonal,txtContraseñapersonal;
    Button btnentrarpersonal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frmloginadmin);
        txtUsuariopersonal=(EditText)findViewById(R.id.txtUsuarioPersonal);
        txtContraseñapersonal=(EditText)findViewById(R.id.txtPasswordPersonal);
        btnentrarpersonal=(Button)findViewById(R.id.btnentrarpersonal);
        btnentrarpersonal.setOnClickListener(this);

    }
    public void entrarpersonal(){
        String usuario,password;
        usuario=txtUsuariopersonal.getText().toString();
        password=txtContraseñapersonal.getText().toString();

        usuariobean objusuario=new usuariobean();
                    objusuario.setUsuario(usuario);
                    objusuario.setPassword(password);

        Intent objIntentpersonal=new Intent(frmloginadmin.this, personalcontrolador.class);
        Bundle  objBundle=new Bundle();
                objBundle.putSerializable("datos",objusuario);
                objBundle.putString("op","2");
                objIntentpersonal.putExtras(objBundle);

        startService(objIntentpersonal);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v==btnentrarpersonal)
            {
                entrarpersonal();
            }

    }
}
