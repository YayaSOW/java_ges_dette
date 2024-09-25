package org.example.core.repository.impl;

import org.example.core.database.impl.DatabaseImp;
import org.example.core.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RepositoryBDImp<T> extends DatabaseImp implements Repository<T> {
    protected String tableName;
    public abstract T convertToObject(ResultSet rs) throws SQLException;
//    @Override
//    public void insert(T data) {
//        System.out.println("BD");
//    }

//    @Override
//    public List<T> selectAll() {
//        return null;
//    }

}
