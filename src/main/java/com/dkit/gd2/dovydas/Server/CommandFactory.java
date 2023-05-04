package com.dkit.gd2.dovydas.Server;

import com.dkit.gd2.dovydas.Core.MarketEnum;

public class CommandFactory
{

    public static Command createCommand(String command)
    {
        Command c = null;
        if(command.equals(MarketEnum.QUIT_COMMAND))
        {
            c = new QuitCommand();
        }
        else if(command.equals(MarketEnum.START_COMMAND))
        {
            c = new StartCommand();
        }
        else if(command.equals(MarketEnum.NONE))
        {
            c = new NoneCommand();
        }
    }
}
