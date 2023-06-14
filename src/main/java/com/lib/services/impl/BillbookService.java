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
    private int status = 100;

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
            List<Billbook> _billbooks = billbookRepo.findAll();
            List<Billbook> res = new ArrayList<>();
            for (var b : _billbooks) {
                if (b.getLibrarianId() == id)
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
    public void addBookByBillbook(Billbook billbook) {
        billbookRepo.save(billbook);
        Listbook listbook = createListbook(billbook);
        listbookRepo.save(listbook);
        for (int i = 1; i <= listbook.getAmount(); i++) {
            Book book = createBook(listbook);
            bookRepo.save(book);
        }
    }
    private Listbook createListbook(Billbook billbook) {
        int countl = (int) listbookRepo.count();
        System.out.println("SO LUONG DAU SACH LA " + countl);
        return new Listbook(countl + 1,
                billbook.getName(),
                billbook.getNameAuthor(),
                billbook.getPubYear(),
                billbook.getPrice(),
                billbook.getAmount(),
                billbook.getId(),
                billbook.getPublisherId(),
                billbook.getLibrarianId());

    }
    private Book createBook(Listbook listbook) {
        int countb = (int) bookRepo.count();
        System.out.println("SO LUONG SACH LA " + countb);
        return new Book(countb + 1, status, listbook.getId());
    }
}