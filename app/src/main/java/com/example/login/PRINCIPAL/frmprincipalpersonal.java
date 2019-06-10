package com.example.login.PRINCIPAL;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.login.R;

public class frmprincipalpersonal extends AppCompatActivity {

    ImageButton BTNREGISTRARDOCENTE,BTNREGISTRARALUMNO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniComponents();
    }

    private void iniComponents() {
        setContentView(R.layout.activity_frmprincipaladmin);
        BTNREGISTRARALUMNO=(ImageButton)findViewById(R.id.btnRegistrarEst);
        BTNREGISTRARALUMNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrAlRegistroAlumno();
            }
        });
        BTNREGISTRARDOCENTE=(ImageButton)findViewById(R.id.btnRegistrarDocen);
        BTNREGISTRARDOCENTE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrAlRegistroDocente();
            }
        });

    }
    public void IrAlRegistroAlumno(){
        Intent objIntentregalum=new Intent(frmprincipalpersonal.this, frmresgistraralumno.class);
        startActivity(objIntentregalum);
        finish();

    }
    public void IrAlRegistroDocente(){
        Intent objIntentregdoc=new Intent(frmprincipalpersonal.this, frmresgistraralumno.class);
        startActivity(objIntentregdoc);
        finish();

    }
}
