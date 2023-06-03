package com.lib.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "listbook")
public class Listbook {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "pub_year", nullable = false)
    private int pubYear;
    @Column(name = "cost", nullable = false)
    private int cost;
    @Column(name = "amount", nullable = false)
    private int amount;
    @Column(name = "billbook_id", nullable = false)
    private int billbookId;
    @Column(name = "publisher_id", nullable = false)
    private int publisherId;
    @Column(name = "librarian_id", nullable = false)
    private int librarianId;

    public Listbook() {
    }

    public Listbook(int id, String name, String author, int pubYear, int cost, int amount, int billbookId, int publisherId, int librarianId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pubYear = pubYear;
        this.cost = cost;
        this.amount = amount;
        this.billbookId = billbookId;
        this.publisherId = publisherId;
        this.librarianId = librarianId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getBillbookId() {
        return billbookId;
    }

    public void setBillbookId(int billbookId) {
        this.billbookId = billbookId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }
}
