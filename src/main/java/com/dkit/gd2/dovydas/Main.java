package com.dkit.gd2.dovydas;

import com.dkit.gd2.dovydas.Exceptions.DAOException;
import com.dkit.gd2.dovydas.dao.MySqlPeopleDao;
import com.dkit.gd2.dovydas.dao.PeopleDaoInterface;

public class Main
{
    public static void main(String[] args) throws DAOException {
        System.out.println("DB Connection Test");
        PeopleDaoInterface peopleDao = new MySqlPeopleDao();
        System.out.println(peopleDao.findAllPeople());
    }
}
