package com.lib.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "default", nullable = false)
    private String detail;
    @Column(name = "listbook_id", nullable = false)
    private int listbookId;

    public Book(int id, String detail, int listbook_id) {
        this.id = id;
        this.detail = detail;
        this.listbookId = listbook_id;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getListbook_id() {
        return listbookId;
    }

    public void setListbook_id(int listbook_id) {
        this.listbookId = listbook_id;
    }
}
