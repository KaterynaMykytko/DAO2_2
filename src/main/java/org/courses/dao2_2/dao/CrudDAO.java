package org.courses.dao2_2.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> {
    void insert(T t) throws SQLException;

    void update(int id) throws SQLException;

    void deleteById(int id) throws SQLException;

    T findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

}
