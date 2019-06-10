package com.example.proyectodocente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.proyectodocente.ControladorRecursos.ControladorRecurso;

public class principalDocente extends AppCompatActivity {

    ImageButton btnCuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniciarCuento();
    }

    public void iniciarCuento(){
        setContentView(R.layout.principal_docente);
        btnCuento=(ImageButton)findViewById(R.id.btnCuentos);
        btnCuento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irCuento();
            }
        });
    }

    public void irCuento(){
        Intent objCuento=new Intent(principalDocente.this, ControladorRecurso.class);
        startActivity(objCuento);

    }
}
