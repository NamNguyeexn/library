package com.lib.dao;

import com.lib.beans.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert (Book b) {
        String sql = "INSERT INTO Book(ID, detail, ListBookID) VALUES (" +
                b.getId()
                + ", " +
                b.getDetail()
                + ", " +
                b.getIdListBook()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update(Book b) {
        String sql = "UPDATE Book SET detail = " +
                b.getDetail()
                + " WHERE ID = " +
                b.getId()
                + " AND ListBookID = " +
                b.getIdListBook()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int detele(String idBook, String idListbook) {
        String sql = "DELETE FROM Book WHERE ID = " +
                idBook
                + " AND ListBookID = " +
                idListbook
                + ";";
        return jdbcTemplate.update(sql);
    }
    public List<Book> getAllBooks(){
        return jdbcTemplate.query("SELECT * FROM Book", new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book b = new Book();
                b.setId(rs.getString(1));
                b.setDetail(rs.getString(2));
                b.setIdListBook(rs.getString(3));
                return b;
            }
        });
    }

}
