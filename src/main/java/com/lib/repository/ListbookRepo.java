package com.lib.repository;

import com.lib.beans.Listbook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ListbookRepo extends JpaRepository<Listbook, Integer> {
    ArrayList<Listbook> findAll();
    Optional<Listbook> findById(Integer id);
    Listbook save(Listbook listbookUpdate);
    boolean existsById(Integer id);
    long count();
//    void deleteById(Integer id);
}
