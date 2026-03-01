package service;

import dao.ItemDaoJDBC;
import factory.ConnectionFactory;
import model.Item;


public class ItemService extends GenericService<Item> {
    public ItemService() {
        super(ItemDaoJDBC::new);
    }

    public boolean toggleAvailabilityItem(Item item){
        item.setAvailable(!item.isAvailable());
        save(item);
        return item.isAvailable();
    }
}
