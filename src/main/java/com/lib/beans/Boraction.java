package com.lib.beans;

public class Boraction {
    private String idBook;
    private String idReader;
    private String idLibrarian;
    private String idPaper;

    public Boraction() {
    }

    public Boraction(String idBook, String idReader, String idLibrarian, String idPaper) {
        this.idBook = idBook;
        this.idReader = idReader;
        this.idLibrarian = idLibrarian;
        this.idPaper = idPaper;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getIdReader() {
        return idReader;
    }

    public void setIdReader(String idReader) {
        this.idReader = idReader;
    }

    public String getIdLibrarian() {
        return idLibrarian;
    }

    public void setIdLibrarian(String idLibrarian) {
        this.idLibrarian = idLibrarian;
    }

    public String getIdPaper() {
        return idPaper;
    }

    public void setIdPaper(String idPaper) {
        this.idPaper = idPaper;
    }
}
