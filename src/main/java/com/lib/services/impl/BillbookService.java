package com.lib.services.impl;

import com.lib.beans.*;
//import com.lib.beans.ResponseObject;
import com.lib.repository.*;
import com.lib.services.BillbookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BillbookService implements BillbookServiceImpl {
    @Autowired
    private BillbookRepo billbookRepo;
    @Autowired
    private PublisherRepo publisherRepo;
    @Autowired
    private LibrarianRepo librarianRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private ListbookRepo listbookRepo;

    @Override
    public List<Billbook> findByPublisherId(int id) {
        try {
            Optional<List<Billbook>> _billbooks = Optional.ofNullable(billbookRepo.findAll());
            if (!_billbooks.isPresent()) {
                return null;
            }
            Optional<Publisher> _publisher = publisherRepo.findById(id);
            if (!_publisher.isPresent()) {
                return null;
            }
            List<Billbook> res = new ArrayList<>();
            for (var b : _billbooks.get()) {
                if (b.getId() == id)
                    res.add(b);
            }
            if (res.size() == 0) {
                return null;
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Billbook> findByLibrarianId(int id) {
        try {
            Optional<List<Billbook>> _billbooks = Optional.ofNullable(billbookRepo.findAll());
            if (!_billbooks.isPresent()) {
                return null;
            }
            Optional<Librarian> _librarian = librarianRepo.findById(id);
            if (!_librarian.isPresent()) {
                return null;
            }
            List<Billbook> res = new ArrayList<>();
            for (var b : _billbooks.get()) {
                if (b.getId() == id)
                    res.add(b);
            }
            if (res.size() == 0) {
                return null;
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Billbook findByNameBillbook(String name) {
        for (var b : billbookRepo.findAll()) {
            if (b.getName().compareTo(name) == 0) {
                return b;
            }
        }
        return null;
    }

    @Override
    public List<Billbook> getAll() {
        return billbookRepo.findAll();
    }

    @Override
    public Billbook getById(int id) {
        return billbookRepo.findById(id).get();
    }

    @Override
    public void addBookByBillbook(Billbook billbook, String nameAuthor, int pubYear, int publisherId, int librarianId) {
        billbookRepo.save(billbook);
        int count = (int) bookRepo.count();
        for (int i = 1; i <= billbook.getAmount(); i++) {
            bookRepo.save(new Book(count + i, billbook.getName(), billbook.getId()));
        }
        listbookRepo.save(new Listbook((int)listbookRepo.count() + 1, billbook.getName(), nameAuthor, pubYear, billbook.getPrice(), billbook.getAmount(), billbook.getId(), publisherId, librarianId));
    }
}