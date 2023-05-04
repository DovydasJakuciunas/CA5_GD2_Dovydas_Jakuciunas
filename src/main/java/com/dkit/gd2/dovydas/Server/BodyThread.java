package com.dkit.gd2.dovydas.Server;

import com.dkit.gd2.dovydas.Core.MarketEnum;
import com.dkit.gd2.dovydas.Core.ServiceDetails;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BodyThread extends Thread
{
    private Socket dataSocket;
    private Scanner input;
    private PrintWriter output;
    private int number;


    public ComboServiceThread(ThreadGroup group, String name, Socket dataSocket, int number)
    {
        super(group, name);
        try
        {
            this.dataSocket = dataSocket;
            this.number = number;

            //Create stream for reading from the client
            input = new Scanner(new InputStreamReader(this.dataSocket.getInputStream()));
            output = new PrintWriter(this.dataSocket.getOutputStream(), true);

        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run()
    {
        String incomingMessage = "";
        String response = "";
        try
        {
            //While the client doesn't want to quit
            while (!incomingMessage.equals(MarketEnum.QUIT_COMMAND))
            {
                //Wipe the respinse to make sure we don't send old values
                response = null;
                //Read a message from the client
                incomingMessage = input.nextLine();
                System.out.println("Server received: " + incomingMessage);

                //Break the incoming message into its components
                String[] components = incomingMessage.split(ServiceDetails.BREAKING_CHARACTERS);

                //Figure out what command to send back to the client
                CommandFactory commandFactory = new CommandFactory();

                Command command = commandFactory.createCommand(components[0]);

                //If we get a command back from the factory, then the command is an accepted action
                //If not then the command is unrecognised

                if (command != null)
                {
                    response = command.createResponse(components);
                }
                else
                {
                    response = MarketEnum.UNRECOGNISED_COMMAND;
                }

                //Send the response back to the client
                output.println(response);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                //Close the streams and the socket
                input.close();
                output.close();
                dataSocket.close();
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

}
