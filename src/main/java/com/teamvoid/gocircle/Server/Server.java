package com.teamvoid.gocircle.Server;

import com.teamvoid.gocircle.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Server(ServerSocket serverSocket) {
        try{
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()) );
            this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


        }
        catch (Exception e)
        {
            System.out.println("Error Server creating");
            e.printStackTrace();
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
    public void massageToSend(String msgSendToClient) {
        try {
            bufferedWriter.write(msgSendToClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error sending to client");
            colseAll(bufferedWriter,bufferedReader,socket);
        }
    }

    public void massageFrmClient(VBox vboxMsg) {
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




}
