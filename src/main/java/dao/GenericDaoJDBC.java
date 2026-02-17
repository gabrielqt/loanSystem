package dao;

import dao.interfaces.GenericDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericDaoJDBC implements GenericDao {
    // tableName não vai vir do usuário, portanto não é passível de SQLInj.
    private String tableName;
    private Connection conn;

    public GenericDaoJDBC(String tableName, Connection conn) {
        this.tableName = tableName;
        this.conn = conn;
    }

    @Override
    public ResultSet findById(Integer id) throws SQLException{
        String sql = "SELECT * from " + this.tableName + " where id = " + id;
        PreparedStatement p = conn.prepareStatement(sql);
        return p.executeQuery();
    }

    @Override
    public void save(Object Entity) {
        if (Entity.id == null){

        }
    }


    protected abstract Object insert(Object Entity);
    protected abstract Object update(Object Entity);

    @Override
    public void DeleteById(Integer id) {

    }

    @Override
    public List listAll() {
        return List.of();
    }
}
