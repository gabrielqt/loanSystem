package dao;

import dao.interfaces.GenericDao;
import mapper.ClientMapper;
import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoJDBC implements GenericDao<Client> {

    private final Connection conn;

    public ClientDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Client findById(Integer id) throws SQLException {
        String sql = """
                select
                	c.id as cliente_id,
                	c.nickname, c.email, c.reputation
                	from Client c
                        where c.id = ?
                """;

        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return ClientMapper.map(rs);
                }
            }

        }
        return null;
    }

    @Override
    public Client save(Client client) throws SQLException {
        if (client.getId() == null){
            return insert(client);
        }
        return update(client);
    }


    private Client update(Client client) throws SQLException {
        String sql = """
                update Client
                	set nickname = ?,
                    email = ?,
                    reputation = ?
                	where id = ?;
                """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, client.getNickname());
            ps.setString(2, client.getEmail());
            ps.setInt(3, client.getReputation());
            ps.setInt(4, client.getId());
            ps.executeUpdate();
            return client;
        }
    }

    private Client insert(Client client) throws SQLException {
        String sql = """
                insert into
                        Client(nickname, email, reputation)
                    values (?,?,?)
                """;
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, client.getNickname());
            ps.setString(2, client.getEmail());
            ps.setInt(3, client.getReputation());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                client.setId(keys.getInt(1));
            }
            return client; // returns the client with id
        }

    }

    @Override
    public Integer deleteById(Integer id) throws SQLException {
        String sql = """
                delete from
                    Client where id = ?;
                """;
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    @Override
    public List<Client> listAll() throws SQLException {
        String sql = """
                select
                	c.id as cliente_id,
                	c.nickname, c.email, c.reputation
                	from Client c
                """;

        List<Client> clients = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                clients.add(ClientMapper.map(rs));
            }
            return clients;
        }
    }
}
