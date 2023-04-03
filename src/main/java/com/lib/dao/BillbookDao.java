package com.lib.dao;

import com.lib.beans.Billbook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BillbookDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert (Billbook b) {
        String sql = "INSERT INTO BillBook(ID, name, cost, amount, price, totalCost, LibrarianID) VALUES (" +
                b.getId()
                + ", " +
                b.getName()
                + ", " +
                b.getCost()
                + ", " +
                b.getAmount()
                + ", " +
                b.getPrice()
                + ", " +
                b.getTotalCost()
                + ", " +
                b.getIdLibrarian()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update (Billbook b) {
        String sql = "UPDATE BillBook SET name = " +
                b.getName()
                + ", cost = " +
                b.getCost()
                + ", amount = " +
                b.getAmount()
                + ", price = " +
                b.getPrice()
                + ", totalCost = " +
                b.getTotalCost()
                + " WHERE ID = " +
                b.getId()
                + " AND LibrarianID = " +
                b.getIdLibrarian()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int delete(String idBillbook, String idLibrarian) {
        String sql = "DELETE FROM BillBook WHERE ID = " +
                idBillbook
                + " AND LibrarianID = " +
                idLibrarian
                + ";";
        return jdbcTemplate.update(sql);
    }
    public List<Billbook> getAllBillbooks (){
        return jdbcTemplate.query("SELECT * FROM Billbook", new RowMapper<Billbook>() {
            @Override
            public Billbook mapRow(ResultSet rs, int rowNum) throws SQLException {
                Billbook b = new Billbook();
                b.setId(rs.getString(1));
                b.setName(rs.getString(2));
                b.setCost(rs.getInt(3));
                b.setAmount(rs.getInt(4));
                b.setPrice(rs.getInt(5));
                b.setTotalCost(rs.getInt(6));
                return b;
            }
        });
    }
}
