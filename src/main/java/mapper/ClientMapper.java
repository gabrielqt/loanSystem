package mapper;
import model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper{
    public static Client map (ResultSet rs) throws SQLException{
        Client c = new Client();

        c.setId(rs.getInt("id"));
        c.setNickname(rs.getString("nickname"));
        c.setEmail(rs.getString("email"));
        c.setReputation(rs.getInt("reputation"));

        return c;
    }
}
