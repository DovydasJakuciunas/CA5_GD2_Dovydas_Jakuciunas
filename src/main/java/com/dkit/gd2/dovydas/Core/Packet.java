package com.dkit.gd2.dovydas.Core;

public class Packet
{
    private MarketEnum command;
    private String components;

    public Packet(MarketEnum command, String components)
    {
        this.command = command;
        this.components = components;
    }

    public MarketEnum getCommand()
    {
        return command;
    }

    public String getComponents()
    {
        return components;
    }

    @Override
    public String toString()
    {
        return "Packet{" + "command=" + command + ", components=" + components + '}';
    }
}
