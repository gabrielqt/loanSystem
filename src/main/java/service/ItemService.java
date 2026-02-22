package service;

import dao.interfaces.GenericDao;
import factory.ConnectionFactory;
import model.Item;
import dao.ItemDaoJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ItemService {
    public ItemService() {
    }

    public Item getItem(Integer id) {
        try (Connection conn = ConnectionFactory.getConnection();) {
            GenericDao<Item> dao = new ItemDaoJDBC(conn);
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("ERRO: " + e.getMessage(), e);
        }}

    public List<Item> getAllItems(){
        try (Connection conn = ConnectionFactory.getConnection();) {
            GenericDao<Item> dao = new ItemDaoJDBC(conn);
            return dao.listAll();
        } catch (SQLException e) {
            throw new RuntimeException("ERRO: " + e.getMessage(), e);
        }
    }

    public Item saveItem(Item item){
        try (Connection conn = ConnectionFactory.getConnection();) {
            GenericDao<Item> dao = new ItemDaoJDBC(conn);
            return dao.save(item);
        } catch (SQLException e) {
            throw new RuntimeException("ERRO: " + e.getMessage(), e);
        }
    }
}