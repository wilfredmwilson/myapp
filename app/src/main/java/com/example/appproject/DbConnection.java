package com.example.bhoomi;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public Connection connection;
    // For Amazon Postgresql
    // private final String host = "ssprojectinstance.csv2nbvvgbcb.us-east-2.rds.amazonaws.com"
    private final String host = "fisat.ckxtdm8r1jbh.us-east-1.rds.amazonaws.com";
    private final String database = "DBbhoomi";
    private final int port = 5432;
    private final String user = "bhoomi";
    private final String pass = "Fisat#123";
    // For Google Cloud Postgresql
    // private final String host = "35.44.16.169";

    // For Local PostgreSQL
  /* private final String host = "10.0.2.2";

    private final String database = "postgres";
    private final int port = 5432;
    private final String user = "postgres";
    private final String pass = "123456";*/
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public DbConnection()
    {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        //this.disconnect();
        System.out.println("connection status:" + status);
    }

    private void connect()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                }
                catch (Exception e)
                {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try
        {
            thread.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection()
    {
        Connection c = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return c;
    }
}
