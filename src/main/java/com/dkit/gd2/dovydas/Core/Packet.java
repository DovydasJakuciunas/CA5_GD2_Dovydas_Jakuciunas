package com.dkit.gd2.dovydas.Core;

public class Packet
{
    private MenuOptions command;
    private String components;

    public Packet(MenuOptions.ClientMenuOptions command, String components)
    {
        this.command = command;
        this.components = components;
    }

    public MenuOptions getCommand()
    {
        return command;
    }

    public String getComponents()
    {
        return components;
    }

    public MenuOptions getRequestType()
    {
        return command;
    }

    @Override
    public String toString()
    {
        return "Packet{" + "command=" + command + ", components=" + components + '}';
    }
}
