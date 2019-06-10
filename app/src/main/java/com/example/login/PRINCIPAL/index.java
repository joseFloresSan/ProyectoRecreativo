package com.example.login.PRINCIPAL;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.login.R;


public class index extends AppCompatActivity {
    ImageButton BTNPERSONAL, BTNESTUDIANTE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniComponents();
    }

    private void iniComponents() {
        setContentView(R.layout.index);
        BTNPERSONAL=(ImageButton)findViewById(R.id.BTNPERSONAL);

        BTNPERSONAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrAlPersonal();

            }
        });
        BTNESTUDIANTE=(ImageButton)findViewById(R.id.BTNESTUDIANTE);

        BTNESTUDIANTE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrAlEstudiante();

            }
        });
    }
    public void IrAlPersonal(){
        Intent objIntentpersonal=new Intent(index.this, frmloginadmin.class);
        startActivity(objIntentpersonal);
        finish();
    }
    public void IrAlEstudiante(){
        Intent objIntentestudiante=new Intent(index.this,frmloginestudiante.class);
        startActivity(objIntentestudiante);
        finish();

    }
}
