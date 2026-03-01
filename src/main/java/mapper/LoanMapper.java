package mapper;

import model.Loan;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanMapper {
    public static Loan map(ResultSet rs) throws SQLException{
        Loan l = new Loan();
        l.setId(rs.getInt("loan_id"));
        l.setClient(ClientMapper.map(rs));
        l.setItem(ItemMapper.map(rs));
        l.setReturnDate(rs.getDate("return_date").toLocalDate());
        l.setExpectedReturnDate(rs.getDate("exp_return_date").toLocalDate());

        return l;
    }
}
