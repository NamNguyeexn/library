package com.lib.services;

import com.lib.beans.Librarian;

import java.util.List;
//import com.lib.beans.ResponseObject;

public interface LibrarianServiceImpl {
    Librarian getLibrarianByEmailAndPassword (String email, String password);
    List<Librarian> getAll();
}
