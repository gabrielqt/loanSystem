package dao;

import dao.interfaces.GenericDao;
import mapper.ItemMapper;
import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ItemDaoJDBC implements GenericDao<Item> {

    private final Connection conn;

    public ItemDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Item findOne(Item item) throws SQLException {
        String sql = """
                select
                	i.id as item_id,
                	i.item_ds, i.available,
                	r.id as rarity_id,
                	r.rarity_ds
                	from item i
                		left join rarity r
                			on i.rarity_id = r.id
                                where i.id = ?
                """;

        try (PreparedStatement ps = this.conn.prepareStatement(sql)){
            ps.setInt(1, item.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return ItemMapper.map(rs);
            }
        } catch (SQLException e){
            System.out.println("ERRO: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Item save(Item item) throws SQLException {
        if (item.getId() == null){
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
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, item.getItem_ds());
            ps.setBoolean(2, item.isAvailable());
            ps.setInt(3, item.getRarity().getRarity_id());
            ps.setInt(4, item.getId());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("ERRO: " + e.getMessage());
        }
        return item;
    }

    private Item insert(Item item) throws SQLException {
        String sql = """
                insert into
                    Item (item_ds, available, rarity_id)
                        values(?, ? ,?);
                """;
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getItem_ds());
            ps.setBoolean(2, item.isAvailable());
            ps.setInt(3, item.getRarity().getRarity_id());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                item.setId(keys.getInt(1));
            }
            return item;
        } catch(SQLException e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }

    }

    @Override
    public Integer deleteOne(Item item) throws SQLException {
        String sql = """
                delete from
                    Item where id = ?;
                """;
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, item.getId());
            return ps.executeUpdate();
        } catch(SQLException e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Item> listAll() throws SQLException {
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

        List<Item> items = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                items.add(ItemMapper.map(rs));
            }

            return items;
        } catch(SQLException e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }
}
