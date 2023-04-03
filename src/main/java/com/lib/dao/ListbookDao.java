package com.lib.dao;

import com.lib.beans.Book;
import com.lib.beans.Listbook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ListbookDao {
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert(Listbook l) {
        String sql = "INSERT INTO ListBook(ID, name, author, pubYear, cost, amount, BillBookID, PublisherID, LibrarianID) VALUES (" +
                l.getId()
                + ", " +
                l.getName()
                + ", " +
                l.getAuthor()
                + ", " +
                l.getPubYear()
                + ", " +
                l.getCost()
                + ", " +
                l.getAmount()
                + ", " +
                l.getIdBillbook()
                + ", " +
                l.getIdPublisher()
                + ", " +
                l.getIdLibrarian()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update(Listbook l) {
        String sql = "UPDATE ListBook SET name = " +
                l.getName()
                + ", author = " +
                l.getAuthor()
                + ", pubYear = " +
                l.getPubYear()
                + ", cost = " +
                l.getCost()
                + ", amount = " +
                l.getAmount()
                + " WHERE ID = " +
                l.getId()
                + " AND BillBookID = " +
                l.getIdBillbook()
                + " AND PublisherID = " +
                l.getIdPublisher()
                + " AND LibrarianID = " +
                l.getIdLibrarian()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int detele(String idListbook, String idBillbook, String idPublisher, String idLibrarian) {
        String sql = "DELETE FROM ListBook WHERE ID = " +
                idListbook
                + " AND BillBookID = " +
                idBillbook
                + " AND PublisherID = " +
                idPublisher
                + " AND LibrarianID = " +
                idLibrarian
                + ";";
        return jdbcTemplate.update(sql);
    }
    public List<Listbook> getAllListbooks(){
        // trả về danh sách tất cả các đầu sách
        return jdbcTemplate.query("SELECT * FROM Listbook", new RowMapper<Listbook>() {
            @Override
            public Listbook mapRow(ResultSet rs, int rowNum) throws SQLException {
                Listbook l = new Listbook();
                l.setId(rs.getString(1));
                l.setName(rs.getString(2));
                l.setAuthor(rs.getString(3));
                l.setPubYear(rs.getInt(4));
                l.setCost(rs.getInt(5));
                l.setAmount(rs.getInt(6));
                return l;
            }
        });
    }
    public Listbook getListbookById (String id) throws SQLException{
        List<Listbook> lst = getAllListbooks();
        for (var l : lst) {
            if (l.getId().matches(id))
                return l;
        }
        return null;
    }
}
