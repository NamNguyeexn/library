package com.lib.dao;

import com.lib.beans.Reader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReaderDao {
    JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert (Reader r) {
        String sql = "INSERT INTO Reader(ID, name, HumanID) VALUES (" +
                r.getId()
                + ", " +
                r.getName()
                + ", " +
                r.getIdHuman()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update (Reader r) {
        String sql = "UPDATE Reader SET name = " +
                r.getName()
                + " WHERE ID = " +
                r.getId()
                + " AND HumanID = " +
                r.getIdHuman()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int delete (String idReader, String idHuman) {
        String sql = "DELETE FROM Reader WHERE ID = " +
                idReader
                + " AND HumanID = " +
                idHuman
                + ";";
        return jdbcTemplate.update(sql);
    }
    public List<Reader> getAllReaders() {
        return jdbcTemplate.query("SELECT * FROM Reader", new RowMapper<Reader>() {
            @Override
            public Reader mapRow(ResultSet rs, int rowNum) throws SQLException {
                Reader r = new Reader();
                r.setId(rs.getString(1));
                r.setName(rs.getString(2));
                r.setIdHuman(rs.getString(3));
                return r;
            }
        });
    }
    public Reader getReaderById(String id) {
        List<Reader> lst = getAllReaders();
        for (var l : lst) {
            if(l.getId().matches(id))
                return l;
        }
        return null;
    }
}
