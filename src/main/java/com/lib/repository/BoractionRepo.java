package com.lib.repository;

import com.lib.beans.Boraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface BoractionRepo extends JpaRepository<Boraction, Integer> {

}
