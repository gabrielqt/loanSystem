package service;

import dao.interfaces.GenericDao;
import factory.ConnectionFactory;
import factory.DaoFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GenericService<T> {

    private final DaoFactory<T> daoFactory;

    public GenericService(DaoFactory<T> daoFactory) {
        this.daoFactory = daoFactory;
    }

    public T getById(Integer id) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            GenericDao<T> dao = daoFactory.create(conn);
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("ERRO: " + e.getMessage(), e);
        }
    }

    public List<T> getAll() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            GenericDao<T> dao = daoFactory.create(conn);
            return dao.listAll();
        } catch (SQLException e) {
            throw new RuntimeException("ERRO: " + e.getMessage(), e);
        }
    }

    public T save(T entity) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            GenericDao<T> dao = daoFactory.create(conn);
            return dao.save(entity);
        } catch (SQLException e) {
            throw new RuntimeException("ERRO: " + e.getMessage(), e);
        }
    }

    public Integer deleteById(Integer id) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            GenericDao<T> dao = daoFactory.create(conn);
            return dao.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException("ERRO: " + e.getMessage(), e);
        }
    }
}