package com.lib.dao;

import com.lib.beans.Listbook;
import com.lib.beans.Publisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PublisherDao {
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert (Publisher p) {
        String sql = "INSERT INTO Publisher(ID, name, address, phone, email) VALUES (" +
                p.getId()
                + ", " +
                p.getName()
                + ", " +
                p.getAddress()
                + ", " +
                p.getPhone()
                + ", " +
                p.getEmail()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update (Publisher p) {
        String sql = "UPDATE Publisher SET name = " +
                p.getName()
                + ", address = " +
                p.getAddress()
                + ", phone = " +
                p.getPhone()
                + ", email = " +
                p.getEmail()
                + " WHERE ID = " +
                p.getId()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int delete(String id) {
        String sql = "DELETE FROM Publisher WHERE ID = " +
                id
                + ";";
        return jdbcTemplate.update(sql);
    }
    public List<Publisher> getAllPublishers() {
        // trả về tất cả các nhà xuất bản
        return jdbcTemplate.query("SELECT * FROM Publisher", new RowMapper<Publisher>() {
            @Override
            public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
                Publisher p = new Publisher();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setAddress(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setPhone(rs.getString(5));
                return p;
            }
        });
    }
    public Publisher getPublisherById(String id) {
        // tìm nhà xuất bản theo id
        List<Publisher> lst = getAllPublishers();
        for (var p : lst) {
            if(p.getId().matches(id))
                return p;
        }
        return null;
    }
}
