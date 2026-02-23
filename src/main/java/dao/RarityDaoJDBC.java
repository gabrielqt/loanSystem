package dao;

import dao.interfaces.GenericDao;
import mapper.RarityMapper;
import model.Rarity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RarityDaoJDBC implements GenericDao<Rarity> {

    private final Connection conn;

    public RarityDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Rarity findById(Integer id) throws SQLException {
        String sql = """
                select
                	r.id as rarity_id,
                	r.rarity_ds
                	from rarity r
                        where r.id = ?
                """;

        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return RarityMapper.map(rs);
                }
            }

        }
        return null;
    }

    @Override
    public Rarity save(Rarity rarity) throws SQLException {
        if (rarity.getId() == null){
            return insert(rarity);
        }
        return update(rarity);
    }


    private Rarity update(Rarity rarity) throws SQLException {
        String sql = """
                update Rarity
                	set rarity_ds = ?
                	where id = ?;
                """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rarity.getRarity_ds());
            ps.executeUpdate();
            return rarity;
        }
    }

    private Rarity insert(Rarity rarity) throws SQLException {
        String sql = """
                insert into
                    Rarity (rarity_ds)
                        values(?);
                """;
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, rarity.getRarity_ds());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                rarity.setId(keys.getInt(1));
            }
            return rarity; // returns the rarity with id
        }

    }

    @Override
    public Integer deleteById(Integer id) throws SQLException {
        String sql = """
                delete from
                    Rarity where id = ?;
                """;
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    @Override
    public List<Rarity> listAll() throws SQLException {
        String sql = """
                select
                	r.id as rarity_id,
                	r.rarity_ds
                	    from rarity r
                """;

        List<Rarity> rarities = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                rarities.add(RarityMapper.map(rs));
            }
            return rarities;
        }
    }
}
