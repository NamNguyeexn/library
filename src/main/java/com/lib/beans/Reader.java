package com.lib.beans;
public class Reader{
    private Human h = new Human();
    private String id;
    private String name;
    private String idHuman;

    public Reader(String id, String name, String idHuman) {
        this.id = id;
        this.name = name;
        this.idHuman = idHuman;
    }

    public Reader() {
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

    public String getIdHuman() {
        return idHuman;
    }

    public void setIdHuman(String idHuman) {
        this.idHuman = idHuman;
    }
}
