package com.lib.repository;

import com.lib.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;


public interface BookRepo extends JpaRepository<Book, Integer> {

}
