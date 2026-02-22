package dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    T findById(Integer id) throws SQLException;
    T save(T entity) throws SQLException;
    Integer deleteById (Integer id) throws SQLException;
    List<T> listAll() throws SQLException;
}
