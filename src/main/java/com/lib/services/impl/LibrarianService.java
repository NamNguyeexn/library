package com.lib.services.impl;

import com.lib.beans.Librarian;
//import com.lib.beans.ResponseObject;
import com.lib.repository.LibrarianRepo;
import com.lib.services.LibrarianServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LibrarianService implements LibrarianServiceImpl {
    @Autowired
    private LibrarianRepo librarianRepo;
    private Optional<Librarian> findByUsername(String username) {
        for (var b : librarianRepo.findAll()) {
            if (b.getUsername().compareTo(username) == 0) {
                return Optional.of(b);
            }
        }
        return null;
    }
    @Override
    public Librarian getLibrarianByEmailAndPassword(String username, String password) {
        try {
            Optional<Librarian> _librarian = findByUsername(username);
            if (!_librarian.isPresent() || _librarian.get().getPassword().compareTo(password) != 0) {
                return null;
            }
            return _librarian.get();
        } catch (Exception e) {
            return null;
        }
    }
//    @Override
//    public ResponseObject<Librarian> getLibrarianByEmailAndPassword(String username, String password) {
//        try {
//            Optional<Librarian> _librarian = findByUsername(username);
//            if (!_librarian.isPresent() || _librarian.get().getPassword().compareTo(password) != 0) {
//                return new ResponseObject<>("id thu thu hoac mat khau khong hop le", null);
//            }
//            return new ResponseObject<>("login success", _librarian.get());
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
}
