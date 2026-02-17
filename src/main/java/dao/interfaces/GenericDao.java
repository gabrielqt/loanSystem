package dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao <T> {
    ResultSet findById(Integer id) throws SQLException;
    T save(T Entity) throws SQLException; // seria o UPDATE
    T DeleteById (Integer id) throws SQLException;
    List<T> listAll() throws SQLException;
}
