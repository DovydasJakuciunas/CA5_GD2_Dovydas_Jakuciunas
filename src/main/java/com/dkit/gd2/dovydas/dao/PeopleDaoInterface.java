package com.dkit.gd2.dovydas.dao;

import com.dkit.gd2.dovydas.Exceptions.DAOException;
import com.dkit.gd2.dovydas.dto.People;

import java.util.List;

public interface PeopleDaoInterface
{
    public List<People> findAllPeople() throws DAOException;
    public People findPeopleByID(String studentID) throws DAOException;
    public boolean addPeople(People s) throws DAOException;
    public boolean deletePeople(String studentID) throws DAOException;
    public boolean updatePeople(People s) throws DAOException;
    public boolean updatePeopleID(People s, String previousID) throws DAOException;
}
