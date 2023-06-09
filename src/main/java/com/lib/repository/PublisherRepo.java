package com.lib.repository;

import com.lib.beans.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {

}
