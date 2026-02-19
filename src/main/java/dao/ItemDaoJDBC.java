package dao;

import dao.interfaces.GenericDao;
import mapper.ItemMapper;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ItemDaoJDBC implements GenericDao<Item> {

    private final Connection conn;

    public ItemDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Item findById(Integer id) throws SQLException {
        String sql = """
                select
                	i.id as item_id,
                	i.item_ds, i.available,
                	r.id as rarity_id,
                	r.rarity_ds
                	from item i
                		left join rarity r
                			on i.rarity_id = r.id
                """;

        PreparedStatement ps = this.conn.prepareStatement(sql);
        return ItemMapper.map(ps.executeQuery());
    }

    @Override
    public Item save(Item item) throws SQLException {
        if (item.getItem_id() == null){
            return insert(item);
        }
        return update(item);
    }


    private Item update(Item item) throws SQLException {
        String sql = """
                update Item
                	set item_ds = ?,
                	available = ?,
                	rarity_id = ?
                	where id = ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, item.getItem_ds());
        ps.setBoolean(2, item.isAvailable());
        ps.setInt(3, item.getRarity().getRarity_id());
        ps.setInt(4, item.getItem_id());
        return item;
    }

    private Item insert(Item i) throws SQLException {
        return null;
    }

    @Override
    public Integer DeleteById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Item> listAll() throws SQLException {
        return null;
    }
}
