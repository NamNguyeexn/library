package com.lib.dao;

import com.lib.beans.Librarian;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LibrarianDao {
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert (Librarian l) {
        String sql = "INSERT INTO Librarian(ID, name, HumanID) VALUES (" +
                l.getId()
                + ", " +
                l.getName()
                + ", " +
                l.getIdHuman()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update (Librarian l) {
        String sql = "UPDATE Librarian SET name = " +
                l.getName()
                + " WHERE ID = " +
                l.getId()
                + " AND HumanID = " +
                l.getIdHuman()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int delete (String idLibrarian, String idHuman) {
        String sql = "DELETE FROM Librarian WHERE ID = " +
                idLibrarian
                + " AND HumanID = " +
                idHuman
                + ";";
        return jdbcTemplate.update(sql);
    }
    public List<Librarian> getAllLibrarians() {
        // trả về danh sách tất cả các thủ thư
        return jdbcTemplate.query("SELECT * FROM Librarian", new RowMapper<Librarian>() {
            @Override
            public Librarian mapRow(ResultSet rs, int rowNum) throws SQLException {
                Librarian l = new Librarian();
                l.setId(rs.getString(1));
                l.setName(rs.getString(2));
                l.setIdHuman(rs.getString(3));
                return l;
            }
        });
    }
    public Librarian getLibrarianById(String id) throws SQLException{
        // tìm thủ thư theo mã thủ thư
        List<Librarian> lst = getAllLibrarians();
        for (var l : lst) {
            if (l.getId().matches(id)) {
                return l;
            }
        }
        return null;
    }
}
