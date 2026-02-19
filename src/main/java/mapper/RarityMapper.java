package mapper;

import model.Rarity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RarityMapper {
    public static Rarity map(ResultSet rs) throws SQLException {
        Rarity r = new Rarity();
        r.setRarity_ds(rs.getString("rarity_ds"));
        r.setId(rs.getInt("rarity_id"));
        return r;
    }
}
