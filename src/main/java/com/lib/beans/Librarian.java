package com.lib.beans;
public class Librarian {
    private String id;
    private String name;
    private String idHuman;

    public Librarian() {
    }

    public Librarian(String id, String name, String idHuman) {
        this.id = id;
        this.name = name;
        this.idHuman = idHuman;
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
