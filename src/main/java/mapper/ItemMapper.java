package mapper;

import model.Item;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper {
    public static Item map(ResultSet rs) throws SQLException {
        Item i = new Item();

        i.setId(rs.getInt("id"));
        i.setItem_ds(rs.getString("item_ds"));
        i.setAvailable(rs.getBoolean("available"));
        i.setRarity(RarityMapper.map(rs));

        return i;
    }
}
