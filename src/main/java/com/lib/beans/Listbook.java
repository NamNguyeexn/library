package com.lib.beans;

public class Listbook {
    private String id;
    private String name;
    private String author;
    private int pubYear;
    private int cost;
    private int amount;
    private String idBillbook;
    private String idPublisher;
    private String idLibrarian;

    public Listbook() {
    }

    public Listbook(String id, String name, String author, int pubYear, int cost, int amount, String idBillbook, String idPublisher, String idLibrarian) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pubYear = pubYear;
        this.cost = cost;
        this.amount = amount;
        this.idBillbook = idBillbook;
        this.idPublisher = idPublisher;
        this.idLibrarian = idLibrarian;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getIdBillbook() {
        return idBillbook;
    }

    public void setIdBillbook(String idBillbook) {
        this.idBillbook = idBillbook;
    }

    public String getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(String idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getIdLibrarian() {
        return idLibrarian;
    }

    public void setIdLibrarian(String idLibrarian) {
        this.idLibrarian = idLibrarian;
    }
}
