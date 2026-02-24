package dao;

import dao.interfaces.GenericDao;
import mapper.LoanMapper;
import model.Client;
import model.Loan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDaoJDBC implements GenericDao<Loan> {

    private final Connection conn;

    public LoanDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Loan findById(Integer id) throws SQLException {
        String sql = """
                    select
                        l.id as loan_id,
                        l.loan_date, l.return_date, l.exp_return_date,
                        c.id as client_id,
                        c.nickname, c.email, c.reputation,
                        i.id as item_id,
                        i.item_ds, i.available,
                        r.id as rarity_id,
                        r.rarity_ds
                    from Loan l
                    join Client c on l.client_id = c.id
                    join Item i on l.item_id = i.id
                    join Rarity r on i.rarity_id = r.id;
                where l.id = ?
                """;

        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return LoanMapper.map(rs);
                }
            }

        }
        return null;
    }

    @Override
    public Loan save(Loan loan) throws SQLException {
        if (loan.getId() == null){
            return insert(loan);
        }
        return update(loan);
    }


    private Loan update(Loan loan) throws SQLException {
        String sql = """
          update loan
             set
                client_id = ?,
                item_id = ?,
                loan_date = ?,
                return_date = ?,
                exp_return_date = ?
             where id = 2
          """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, loan.getClient().getId());
            ps.setInt(2, loan.getItem().getId());
            ps.setDate(3, Date.valueOf(loan.getLoanDate()));
            ps.setDate(4, Date.valueOf(loan.getReturnDate()));
            ps.setDate(5, Date.valueOf(loan.getExpectedReturnDate()));
            ps.executeUpdate();
            return loan;
        }
    }

    private Loan insert(Loan loan) throws SQLException {
        String sql = """
                insert into Loan
                    (client_id, item_id, loan_date, return_date, exp_return_date)
                VALUES (?, ?, ?, ?, ?);
                """;
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, loan.getClient().getId());
            ps.setInt(2, loan.getItem().getId());
            ps.setDate(3, Date.valueOf(loan.getLoanDate()));
            ps.setDate(4, Date.valueOf(loan.getReturnDate()));
            ps.setDate(5, Date.valueOf(loan.getExpectedReturnDate()));
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                loan.setId(keys.getInt(1));
            }
            return loan; // returns the loan with id
        }

    }

    @Override
    public Integer deleteById(Integer id) throws SQLException {
        String sql = """
                delete from
                    Loan where id = ?;
                """;
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    @Override
    public List<Loan> listAll() throws SQLException {
        String sql = """
            select
                l.id as loan_id,
                l.loan_date, l.return_date, l.exp_return_date,
                c.id as client_id,
                c.nickname, c.email, c.reputation,
                i.id as item_id,
                i.item_ds, i.available,
                r.id as rarity_id,
                r.rarity_ds
            from Loan l
            join Client c on l.client_id = c.id
            join Item i on l.item_id = i.id
            join Rarity r on i.rarity_id = r.id;
            """;

        List<Loan> loans = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                loans.add(LoanMapper.map(rs));
            }
            return loans;
        }
    }
}
