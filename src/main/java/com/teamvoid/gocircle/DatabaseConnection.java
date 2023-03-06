package com.teamvoid.gocircle;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getConnect()
    {
        String databaseName="sql7602631";
        String databaseUsername="sql7602631";
        String databasePassword="QQulIkHFSv";
        String url = "jdbc:mysql://sql7.freesqldatabase.com/"+databaseName;
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
