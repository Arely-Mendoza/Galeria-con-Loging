package com.example.galeriat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    EditText usuario,password;
    Button btnEntrar;
    TextView btnRegistrar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=(EditText)findViewById(R.id.Usuario);
        password=(EditText)findViewById(R.id.Password);
        btnRegistrar= (TextView) findViewById(R.id.Registrar);
        btnEntrar=(Button)findViewById(R.id.Entrar);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);

        dao=new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Registrar:

                Intent i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);
                finish();
                break;
            case R.id.Entrar:

                String u = usuario.getText().toString();
                String p = password.getText().toString();
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this, "error, campos vacios",Toast.LENGTH_LONG).show();

                }else if (dao.login(u,p)==1){
                    Usuario ux =dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Inicio.class);
                    intent.putExtra("Id", ux.getId());
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "usuario y/o contrasena incorrectos",Toast.LENGTH_LONG).show();
                }


        }

    }
}