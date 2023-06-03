package com.lib.repository;

import com.lib.beans.Borpaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorpaperRepo extends JpaRepository<Borpaper, Integer> {
    Optional<Borpaper> findById(Integer id);
    Borpaper save(Borpaper borpaperUpdate);
    void deleteById(Integer id);
}
