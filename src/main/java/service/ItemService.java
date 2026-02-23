package service;

import dao.ItemDaoJDBC;
import model.Item;


public class ItemService extends GenericService<Item> {
    public ItemService() {
        super(ItemDaoJDBC::new);
    }
}
