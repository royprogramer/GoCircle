package com.teamvoid.gocircle;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getConnect()
    {
        String databaseName="gocirle";
        String databaseUsername="root";
        String databasePassword="";
        String url = "jdbc:mysql://localhost:3306/"+databaseName;
        try {
            Class.forName("com.teamvoid.gocircle.DatabaseConnection");
            databaseLink = DriverManager.getConnection(url,databaseUsername,databasePassword);


        }
        catch (Exception e)
        {
            System.out.println("here");
        }
        return databaseLink;
    }

}
