package lk.ijse.dep.app.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {

    T find(ID key) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean save(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean delete(ID key) throws SQLException;

}
