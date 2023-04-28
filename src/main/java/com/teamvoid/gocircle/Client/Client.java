package com.teamvoid.gocircle.Client;

import com.teamvoid.gocircle.Main;
import com.teamvoid.gocircle.Server.serverScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    public Client(Socket socket) {
        try{
            this.socket = socket;
            this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()) );



        }
        catch (Exception e)
        {
            System.out.println("Error client creating");
            e.printStackTrace();
        }
    }

    public void massageFrmServer(VBox vboxMsg) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (socket.isConnected())
                {
                    try{
                        String massageClient= bufferedReader.readLine();
                        serverScreenController.addMassage(massageClient,vboxMsg);

                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                        System.out.println("reading error");
                        colseAll(bufferedWriter,bufferedReader,socket);
                        break;
                    }
                }
            }
        }).start();
    }

    public void massageToSend(String msgSendToServer) {
        try {
            bufferedWriter.write(msgSendToServer);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error sending from client to server");
            colseAll(bufferedWriter,bufferedReader,socket);
        }
    }
    public void colseAll(BufferedWriter bufferedWriter,BufferedReader bufferedReader, Socket socket)
    {
        try{
            if(bufferedReader !=null)
            {
                bufferedReader.close();
            }
            if(bufferedWriter !=null)
            {
                bufferedWriter.close();
            }
            if(socket !=null)
            {
                socket.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
