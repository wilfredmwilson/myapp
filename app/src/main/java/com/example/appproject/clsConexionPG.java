package com.example.appproject;

import android.os.StrictMode;
import java.sql.Connection;
import java.sql.DriverManager;

public class clsConexionPG {
    Connection conexion=null;

    //Creamos nuestra funcion para Conectarnos a Postgresql
    public  Connection conexionBD(){
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myapp", "postgres", "root");

        }catch (Exception er){
            System.err.println("Error CONNECTION"+ er.toString());
        }
        return  conexion;
    }

    //Creamos la funcion para Cerrar la Conexion
    protected  void cerrar_conexion(Connection con)throws  Exception{
        con.close();
    }
}
