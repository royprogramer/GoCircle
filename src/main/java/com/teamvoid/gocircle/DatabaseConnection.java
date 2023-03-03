package com.teamvoid.gocircle;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getConnect()
    {
        String databaseName="gocircle";
        String databaseUsername="root";
        String databasePassword="";
        String url = "jdbc:mysql://localhost/"+databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUsername,databasePassword);


        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        return databaseLink;
    }

}
