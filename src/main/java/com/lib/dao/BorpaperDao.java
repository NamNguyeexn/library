package com.lib.dao;

import com.lib.beans.Borpaper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BorpaperDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert(Borpaper b) {
        String sql = "INSERT INTO BorPaper(ID, borDay, retDay, lastDay, detail, status) VALUES (" +
                b.getId()
                + ", " +
                b.getBorDay()
                + ", " +
                b.getRetDay()
                + ", " +
                b.getLastDay()
                + ", " +
                b.getDetail()
                + ", " +
                b.getStatus()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update(Borpaper b) {
        String sql = "UPDATE BorPaper SET borDay = " +
                b.getBorDay()
                + ", retDay = " +
                b.getRetDay()
                + ", lastDay = " +
                b.getLastDay()
                + ", detail = " +
                b.getDetail()
                + ", status = " +
                b.getStatus()
                + " WHERE ID = " +
                b.getId()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int delete(String id) {
        String sql = "DELETE FROM BorPaper WHERE ID = " +
                id
                +";";
        return jdbcTemplate.update(sql);
    }
    public List<Borpaper> getAllBorpapers(){
        return jdbcTemplate.query("SELECT * FROM Borpaper", new RowMapper<Borpaper>() {
            @Override
            public Borpaper mapRow(ResultSet rs, int rowNum) throws SQLException {
                Borpaper b = new Borpaper();
                b.setId(rs.getString(1));
                b.setBorDay(rs.getString(2));
                b.setRetDay(rs.getString(3));
                b.setLastDay(rs.getString(4));
                b.setDetail(rs.getString(5));
                b.setStatus(rs.getString(6));
                return b;
            }
        });
    }

}
