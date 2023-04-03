package com.lib.dao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.lib.beans.Human;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HumanDao {
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert (Human h) {
        String sql = "INSERT INTO Human(ID, name, birth, phone, address) VALUES (" +
                h.getId()
                + ", " +
                h.getName()
                + ", " +
                h.getBirth()
                + ", " +
                h.getPhone()
                + ", " +
                h.getAddress()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update (Human h) {
        String sql ="UPDATE Human SET name = '" +
                h.getName()
                + ", birth = " +
                h.getBirth()
                + ", phone = " +
                h.getPhone()
                + ", address = " +
                h.getAddress()
                + " WHERE ID = " +
                h.getId()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int delete (String id) {
        String sql = "DELETE FROM Human WHERE ID = " +
        id
        + ";";
        return jdbcTemplate.update(sql);
    }
    public List<Human> getAllHumans(){
        // tìm tất cả người dùng
        return jdbcTemplate.query("SELECT * FROM Human", new RowMapper<Human>() {
            @Override
            public Human mapRow(ResultSet rs, int rowNum) throws SQLException {
                Human h = new Human();
                h.setId(rs.getString(1));
                h.setName(rs.getString(2));
                h.setBirth(rs.getString(3));
                h.setPhone(rs.getString(4));
                h.setAddress(rs.getString(5));
                return h;
            }
        });
    }
}
