package factory;

import dao.interfaces.GenericDao;

import java.sql.Connection;

public interface DaoFactory<T> {
    GenericDao<T> create(Connection conn);
}