package com.example.proyectodocente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyectodocente.ControladorDocente.DocenteControlador;

public class loginDocente extends AppCompatActivity {
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniCompenents();
    }
    public void iniCompenents(){
        setContentView(R.layout.loginDocente);

        btnLogin=(Button)findViewById(R.id.btnLogDocente);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPrincipalDoc();
            }
        });
    }
    public void irPrincipalDoc(){
        Intent objCuento=new Intent(loginDocente.this, DocenteControlador.class);
        startActivity(objCuento);
        //finish();
    }

}
