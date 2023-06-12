package com.lib.services.impl;

import com.lib.beans.Listbook;
import com.lib.repository.ListbookRepo;
import com.lib.services.ListbookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ListbookService implements ListbookServiceImpl {
    @Autowired
    private ListbookRepo listbookRepo;
    @Override
    public List<Listbook> findByNameAuthor(String name) {
        List<Listbook> listbooks = new ArrayList<>();
        for (var b : listbookRepo.findAll()) {
            if (b.getAuthor().compareTo(name) == 0) {
                listbooks.add(b);
            }
        }
        return listbooks;
    }

    @Override
    public List<Listbook> getAll() {
        return listbookRepo.findAll();
    }
}
