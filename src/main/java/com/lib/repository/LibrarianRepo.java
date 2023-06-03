package com.lib.repository;

import com.lib.beans.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface LibrarianRepo extends JpaRepository<Librarian, Integer> {
    ArrayList<Librarian> findAll();
    Optional<Librarian> findById(Integer id);
}
