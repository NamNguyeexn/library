package com.lib.services;

import com.lib.beans.Boraction;
//import com.lib.beans.ResponseObject;

import java.util.List;

public interface BoractionServiceImpl {
    List<Boraction> findByBookId(int id);
    List<Boraction> findByLibrarianId(int id);
    List<Boraction> findByReaderId(int id);
    List<Boraction> getAll();
}
