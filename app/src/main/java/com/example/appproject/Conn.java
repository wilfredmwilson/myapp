package com.example.bhoomi;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    Connection conexion=null;
    private final String host = "fisat.ckxtdm8r1jbh.us-east-1.rds.amazonaws.com";
    private final String database = "DBbhoomi";
    private final int port = 5432;
    private final String user = "bhoomi";
    private final String pass = "Fisat#123";
    //Creamos nuestra funcion para Conectarnos a Postgresql
    public  Connection conexionBD(){
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+database, user, pass);

        }catch (Exception er){
            System.err.println("Error CONNECTION"+ er.toString());
        }
        return  conexion;
    }
}
