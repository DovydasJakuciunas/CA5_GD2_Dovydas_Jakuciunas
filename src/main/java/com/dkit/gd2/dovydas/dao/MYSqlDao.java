package com.dkit.gd2.dovydas.dao;

import com.dkit.gd2.dovydas.Exceptions.DAOException;

import java.sql.Connection;
import java.sql.SQLException;

public class MYSqlDao
{
    public Connection getConnection() throws DAOException
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/oop";
        String username = "root";
        String password = System.getenv("MYSQL_PASSWORD");
        Connection con = null;
        try
        {
            Class.forName(driver);
            con = java.sql.DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
            System.exit(1);
        }
        catch (java.sql.SQLException e)
        {
            System.out.println("Connection failed " + e.getMessage());
        }

        return con;
    }

    public void freeConnection (Connection con) throws DAOException
    {
        try
        {
            if(con != null)
            {
                con.close();
                con = null;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to free the connection " + e.getMessage());
            System.exit(1);
        }
    }
}
