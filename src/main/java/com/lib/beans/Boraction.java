package com.lib.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "boraction")
public class Boraction {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Column(name = "reader_id", nullable = false)
    private int readerId;
    @Column(name = "librarian_id", nullable = false)
    private int librarianId;
    @Column(name = "paper_id", nullable = false)
    private int paperId;

    public Boraction() {
    }

    public Boraction(int id, int bookId, int readerId, int librarianId, int paperId) {
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.librarianId = librarianId;
        this.paperId = paperId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }
}
