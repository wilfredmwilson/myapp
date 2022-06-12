package com.example.appproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Types;

public class Login extends AppCompatActivity {
    //Declaramos nuestra variable de conexion
    private static clsConexionPG con=new clsConexionPG();
    Variables_Globales va=Variables_Globales.getInstance();

    //Declaramos los elementos de nuestro activity login
    Button b1;
    EditText user,pass;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Luego a esas variables le asignamos los valores de cada elemento
        b1=findViewById(R.id.button);
        user=findViewById(R.id.editTextTextPersonName);
        pass=findViewById(R.id.editTextTextPassword);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Incio_Sesion(user.getText().toString(),pass.getText().toString());
            }
        });
    }

    //Crearemos la Función para Iniciar Sesion de Postgresql
    public  void Incio_Sesion(String username, String password){
        try{
            String storeProcedureCall="{CALL login_android(?,?)}";
            CallableStatement cStmt=con.conexionBD().prepareCall(storeProcedureCall);
            //Estos dos primeros parametros son los de entrada
            cStmt.setString(1,username);
            cStmt.setString(2,password);

            //cStmt.registerOutParameter(3, Types.VARCHAR);
         // cStmt.registerOutParameter(4, Types.VARCHAR);


            cStmt.executeUpdate();

            //declaramos las variables que recibiremos de la funcion de postgresql

         //   String _usertype=cStmt.getString(3);
            //String _status=cStmt.getString(4);
            String _msj=cStmt.getString(5);

            //agregamos una condicional para sercioranos si se ingresaron correctamente el usuario y la clave

            if(_msj.equals("OK")){

             //   va.set_usertype(_usertype);
               // va.set_status(_status);

//Luego Abrimos el activity menu
                Intent menu=new Intent(this,MainActivity.class);
                startActivity(menu);

            }else{
                Toast.makeText(getApplicationContext(),_msj,Toast.LENGTH_SHORT).show();
            }

        }catch (Exception er){
            Toast.makeText(getApplicationContext(),er.toString(),Toast.LENGTH_SHORT).show();
        }

    }
}