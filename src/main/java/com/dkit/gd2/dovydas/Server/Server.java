package com.dkit.gd2.dovydas.Server;

import com.dkit.gd2.dovydas.Core.ServiceDetails;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;

public class Server
{
    public static void main(String[] args)
    {
        try
        {
            //Set up a connection sockets that listens for connections
            ServerSocket listeningSocket = new ServerSocket(ServiceDetails.SERVER_PORT);

            ThreadGroup clientThreads = new ThreadGroup("Client Threads");
            clientThreads.setMaxPriority(Thread.currentThread().getPriority() - 1);

            boolean continueRunning = true;
            int countRequests = 0;

            while(continueRunning)
            {
                //Wait for an incoming connection and build the communications link
                System.out.println("Waiting for connections...");
                Socket dataSocket = listeningSocket.accept();
                System.out.println("Connection accepted.");

                BodyThread newClient = new BodyThread(dataSocket);

            }
            listeningSocket.close();
        }
        catch(NoSuchElementException nse)
        {
            System.out.println(nse.getMessage());
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
    }
}
