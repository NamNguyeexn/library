package com.lib.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "billbook")
public class Billbook {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "cost", nullable = false)
    private int cost;
    @Column(name = "amount", nullable = false)
    private int amount;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "total_cost", nullable = false)
    private int totalCost;
    @Column(name = "librarian_id", nullable = false)
    private int librarianId;
    @Column(name = "name_author", nullable = false)
    private String nameAuthor;
    @Column(name = "pub_year", nullable = false)
    private int pubYear;
    @Column(name = "publisher_id", nullable = false)
    private int publisherId;

    public Billbook() {
    }

    public Billbook(int id, String name, int cost, int amount, int price, int totalCost, int librarianId, String nameAuthor, int pubYear, int publisherId) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.amount = amount;
        this.price = price;
        this.totalCost = totalCost;
        this.librarianId = librarianId;
        this.nameAuthor = nameAuthor;
        this.pubYear = pubYear;
        this.publisherId = publisherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
}
