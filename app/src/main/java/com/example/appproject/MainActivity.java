package com.example.bhoomi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    private static Conn con=new Conn();
    private static DbConnection dbConnection = new DbConnection();
    Button b1;
    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   b1=findViewById(R.id.button);
      // user=findViewById(R.id.editTextTextPersonName2);
      //  DbConnection dbConnection = new DbConnection();
        //dbConnection.execute();
        InsertRecordExample createTableExample = new InsertRecordExample();

                createTableExample.insertRecord();

        //connection=dbConnection.getExtraConnection();


    }


    public class InsertRecordExample {


        private static final String INSERT_USERS_SQL = "INSERT INTO login" +
                "  (login_id,username) VALUES " +
                " (?,?);";





        public void insertRecord()  {           System.out.println(INSERT_USERS_SQL);
            // Step 1: Establishing a Connection
            try (

                 // Step 2:Create a statement using connection object
                 PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(INSERT_USERS_SQL)) {
                preparedStatement.setInt(1, 1);
               preparedStatement.setString(2, "Tony");
              /*  preparedStatement.setString(3, "tony@gmail.com");
                preparedStatement.setString(4, "US");
                preparedStatement.setString(5, "secret");
*/
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
            } catch (SQLException e) {

                // print SQL exception information
                System.out.println("oopsss");
            }

            // Step 4: try-with-resource statement will auto close the connection.
        }


    }
}