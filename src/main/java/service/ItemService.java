package service;

import dao.ItemDaoJDBC;
import factory.ConnectionFactory;
import model.Item;


public class ItemService extends GenericService<Item> {
    public ItemService() {
        super(ItemDaoJDBC::new);
    }

    public boolean itemIsAvailable(Integer id){
        return this.getById(id).isAvailable();
    }
}
