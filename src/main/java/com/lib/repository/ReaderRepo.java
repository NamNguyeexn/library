package com.lib.repository;

import com.lib.beans.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ReaderRepo extends JpaRepository<Reader, Integer> {

}
