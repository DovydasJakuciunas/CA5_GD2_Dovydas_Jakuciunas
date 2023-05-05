package com.dkit.gd2.dovydas.Server;

import com.dkit.gd2.dovydas.Core.BodyBuildingServiceDetails;

import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) {

        try
        {
            ServerSocket connectionSocket = new ServerSocket(BodyBuildingServiceDetails.SERVER_PORT);
            Socket dataSocket = null;
            System.out.println("Ready to accept connection.");

            boolean continueRunning = true;
            while(continueRunning)
            {
                System.out.println("Waiting for connections...");
                dataSocket = connectionSocket.accept();
                System.out.println("Connection accepted.");

                ThreadPerClient runnable = new ThreadPerClient(dataSocket);
            }
        }
    }
}
