package com.lib.dao;

import com.lib.beans.Boraction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BoractionDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert(Boraction b) {
        String sql = "INSERT INTO BorAction(BookID, BorPaperID, LibrarianID, ReaderID) VALUES (" +
                b.getIdBook()
                + ", " +
                b.getIdPaper()
                + ", " +
                b.getIdLibrarian()
                + ", " +
                b.getIdReader()
                + ");";
        return jdbcTemplate.update(sql);
    }
    public int update(Boraction b) {
        String sql = "UPDATE BorAction SET  WHERE BookID = " +
                b.getIdBook()
                + " AND BorPaperID = " +
                b.getIdPaper()
                + " AND LibrarianID = " +
                b.getIdLibrarian()
                + " AND ReaderID = " +
                b.getIdReader()
                + ";";
        return jdbcTemplate.update(sql);
    }
    public int delete(String idBook, String idReader, String idLibrarian, String idPaper) {
        String sql = "DELETE FROM BorAction WHERE BookID = " +
                idBook
                + " AND BorPaperID = " +
                idPaper
                + " AND LibrarianID = " +
                idLibrarian
                + " AND ReaderID = " +
                idReader
                + ";";
        return jdbcTemplate.update(sql);
    }
    public List<Boraction> getAllBoractions (){
        return jdbcTemplate.query("SELECT * FROM Boraction", new RowMapper<Boraction>() {
            @Override
            public Boraction mapRow(ResultSet rs, int rowNum) throws SQLException {
                Boraction b = new Boraction();
                b.setIdBook(rs.getString(1));
                b.setIdReader(rs.getString(2));
                b.setIdLibrarian(rs.getString(3));
                b.setIdPaper(rs.getString(4));
                return b;
            }
        });
    }
}
