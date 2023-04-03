package com.lib.beans;

import java.io.Serializable;

public class Login implements Serializable {
    private String idLibrarian;
    private String password;

    public Login() {
    }

    public Login(String idLibrarian, String password) {
        this.idLibrarian = idLibrarian;
        this.password = password;
    }

    public String getIdLibrarian() {
        return idLibrarian;
    }

    public void setIdLibrarian(String idLibrarian) {
        this.idLibrarian = idLibrarian;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
