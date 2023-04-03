package com.lib.beans;

public class Billbook {
    private String id;
    private String name;
    private int cost;
    private int amount;
    private int price;
    private int totalCost;
    private String idLibrarian;

    public Billbook() {
    }

    public Billbook(String id, String name, int cost, int amount, int price, int totalCost, String idLibrarian) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.amount = amount;
        this.price = price;
        this.totalCost = totalCost;
        this.idLibrarian = idLibrarian;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdLibrarian() {
        return idLibrarian;
    }

    public void setIdLibrarian(String idLibrarian) {
        this.idLibrarian = idLibrarian;
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
}
