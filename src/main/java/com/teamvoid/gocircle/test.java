package com.teamvoid.gocircle;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class test {
    public static void main(String[] args) {
        Connection connect;
        String path= "temp/Koushik.png";

        File file1=new File(path);
        try {
            DatabaseConnection connectNow= new DatabaseConnection();
            connect= connectNow.getConnect();
            FileInputStream fis = new FileInputStream(file1);
            String s = "Update test set Image=? where Username=?";
            PreparedStatement preparedStatement2 = (PreparedStatement) connect.prepareStatement(s);
            preparedStatement2.setBinaryStream(1, fis, (int) file1.length());
            preparedStatement2.setString(2, "hello");
            preparedStatement2.execute();
            preparedStatement2.close();



        } catch (Exception ee) {

            System.out.println(ee.getMessage());
        }

    }

}
