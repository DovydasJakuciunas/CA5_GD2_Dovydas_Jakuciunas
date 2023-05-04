package com.dkit.gd2.dovydas.dao;

import com.dkit.gd2.dovydas.Exceptions.DAOException;
import com.dkit.gd2.dovydas.dto.People;
import com.dkit.gd2.dovydas.dto.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPeopleDao extends MYSqlDao implements PeopleDaoInterface
{
    @Override
    public List<People> findAllPeople() throws DAOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<People> people = new ArrayList<>();

        try
        {
            con = this.getConnection();
            String query = "SELECT * FROM people";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next())
            {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int won = rs.getInt("won");
                int age = rs.getInt("age");

                People p = new People(firstName, lastName, won, age);
                people.add(p);
            }
        }
        catch(SQLException e)
        {
            throw new DAOException("findAllPeople() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return  people;
    }

    @Override
    public People findPeopleByID(String studentID) throws DAOException {
        return null;
    }

    @Override
    public boolean addPeople(People s) throws DAOException {
        return false;
    }

    @Override
    public boolean deletePeople(String studentID) throws DAOException {
        return false;
    }

    @Override
    public boolean updatePeople(People s) throws DAOException {
        return false;
    }

    @Override
    public boolean updatePeopleID(People s, String previousID) throws DAOException {
        return false;
    }
}
