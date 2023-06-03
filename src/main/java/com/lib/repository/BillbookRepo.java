package com.lib.repository;

import com.lib.beans.Billbook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface BillbookRepo extends JpaRepository<Billbook, Integer> {
    ArrayList<Billbook> findAll();
    Optional<Billbook> findById(Integer id);
    void deleteById (Integer id);
    long count();
    boolean existsById(Integer id);
    Billbook save(Billbook billbookUpdate);
}
