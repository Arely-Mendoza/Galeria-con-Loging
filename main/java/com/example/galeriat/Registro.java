package com.example.galeriat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText nom,dir,us,pas;
    Button reg;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nom=(EditText)findViewById(R.id.nombre);
        dir=(EditText)findViewById(R.id.apellidos);
        us=(EditText)findViewById(R.id.usuario);
        pas=(EditText)findViewById(R.id.pass);
        reg=(Button)findViewById(R.id.reg);
        reg.setOnClickListener(this);
        dao=new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reg:
                Usuario u = new Usuario();
                u.setNombre(nom.getText().toString());
                u.setDireccion(dir.getText().toString());
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this, "error, campos vacios",Toast.LENGTH_LONG).show();

                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this, "Datos registrados correctamente",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Registro.this, MainActivity.class);
                    startActivity(i);
                    finish();

                }else{
                    Toast.makeText(this, "usuario ya registrado",Toast.LENGTH_LONG).show();
                }

                break;

        }

    }
}