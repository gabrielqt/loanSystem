package dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    T findOne(T entity) throws SQLException;
    T save(T entity) throws SQLException;
    Integer deleteOne (T entity) throws SQLException;
    List<T> listAll() throws SQLException;
}
