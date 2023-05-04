package com.dkit.gd2.dovydas.dao;

import com.dkit.gd2.dovydas.Exceptions.DAOException;
import com.dkit.gd2.dovydas.dto.Record;

import java.util.List;

public interface RecordDaoInterface
{
    public List<Record> findAllRecords(String peopleID) throws DAOException;
    public boolean addRecord(Record r,String peopleID) throws DAOException;
    public boolean getRecord(Record r) throws DAOException;
    public boolean deleteRecord(String peopleID) throws DAOException;
}
