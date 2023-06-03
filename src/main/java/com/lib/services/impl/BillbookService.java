package com.lib.services.impl;

import com.lib.beans.Billbook;
import com.lib.beans.Librarian;
import com.lib.beans.Publisher;
//import com.lib.beans.ResponseObject;
import com.lib.repository.BillbookRepo;
import com.lib.repository.LibrarianRepo;
import com.lib.repository.PublisherRepo;
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

    @Override
    public List<Billbook> findByPublisherId(int id) {
        try {
            Optional<List<Billbook>> _billbooks = Optional.ofNullable(billbookRepo.findAll());
            if(!_billbooks.isPresent()) {
                return null;
            }
            Optional<Publisher> _publisher = publisherRepo.findById(id);
            if(!_publisher.isPresent()) {
                return null;
            }
            List<Billbook> res = new ArrayList<>();
            for (var b : _billbooks.get()) {
                if (b.getId() == id)
                    res.add(b);
            }
            if(res.size() == 0) {
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
            if(!_billbooks.isPresent()) {
                return null;
            }
            Optional<Librarian> _librarian = librarianRepo.findById(id);
            if(!_librarian.isPresent()) {
                return null;
            }
            List<Billbook> res = new ArrayList<>();
            for (var b : _billbooks.get()) {
                if (b.getId() == id)
                    res.add(b);
            }
            if(res.size() == 0) {
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
//    @Override
//    public ResponseObject<List<Billbook>> findByPublisherId(int id) {
//        try {
//            Optional<List<Billbook>> _billbooks = Optional.ofNullable(billbookRepo.findAll());
//            if(!_billbooks.isPresent()) {
//                return new ResponseObject<List<Billbook>>("danh sach hoa don trong", null);
//            }
//            Optional<Publisher> _publisher = publisherRepo.findById(id);
//            if(!_publisher.isPresent()) {
//                return new ResponseObject<List<Billbook>>("ma nha xuat ban khong ton tai", null);
//            }
//            List<Billbook> res = new ArrayList<>();
//            for (var b : _billbooks.get()) {
//                if (b.getId() == id)
//                    res.add(b);
//            }
//            if(res.size() == 0) {
//                return new ResponseObject<List<Billbook>>("danh sach can tim trong", null);
//            }
//            return new ResponseObject<List<Billbook>>("lay danh sach thanh cong", res);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
//
//    @Override
//    public ResponseObject<List<Billbook>> findByLibrarianId(int id) {
//        try {
//            Optional<List<Billbook>> _billbooks = Optional.ofNullable(billbookRepo.findAll());
//            if(!_billbooks.isPresent()) {
//                return new ResponseObject<List<Billbook>>("danh sach hoa don trong", null);
//            }
//            Optional<Librarian> _librarian = librarianRepo.findById(id);
//            if(!_librarian.isPresent()) {
//                return new ResponseObject<List<Billbook>>("ma thu thu khong ton tai", null);
//            }
//            List<Billbook> res = new ArrayList<>();
//            for (var b : _billbooks.get()) {
//                if (b.getId() == id)
//                    res.add(b);
//            }
//            if(res.size() == 0) {
//                return new ResponseObject<List<Billbook>>("danh sach can tim trong", null);
//            }
//            return new ResponseObject<List<Billbook>>("lay danh sach thanh cong", res);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
}
