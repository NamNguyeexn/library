package com.lib.repository;

import com.lib.beans.Billbook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface BillbookRepo extends JpaRepository<Billbook, Integer> {

}
