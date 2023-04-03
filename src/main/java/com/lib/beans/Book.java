package com.lib.beans;
import com.lib.beans.Listbook;
public class Book {
    private String id;
    private String detail;
    private String idListBook;

    public Book(String id, String detail, String idListBook) {
        this.id = id;
        this.detail = detail;
        this.idListBook = idListBook;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIdListBook() {
        return idListBook;
    }

    public void setIdListBook(String idListBook) {
        this.idListBook = idListBook;
    }
}
