package com.lib.dao;

import com.lib.beans.Login;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert (Login l) {
        String sql = "INSERT INTO Login(password, LibrarianID) VALUES (" +
                l.getPassword()
                + ", " +
                l.getIdLibrarian()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update (Login l) {
        String sql = "UPDATE Login SET password = " +
                l.getPassword()
                + " WHERE LibrarianID = " +
                l.getIdLibrarian()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int delete (String id) {
        String sql = "";
        return jdbcTemplate.update(sql);
    }
    public List<Login> getLogins() {
        return jdbcTemplate.query("SELECT * FROM Login", new RowMapper<Login>() {
            @Override
            public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
                Login l = new Login();
                l.setIdLibrarian(rs.getString(1));
                l.setPassword(rs.getString(2));
                return l;
            }
        });
    }
}
