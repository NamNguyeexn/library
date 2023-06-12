package com.lib.services.impl;

import com.lib.beans.*;
import com.lib.repository.*;
import com.lib.services.BoractionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoractionService implements BoractionServiceImpl {
    @Autowired
    private BoractionRepo boractionRepo;
    @Autowired
    private BorpaperRepo borpaperRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LibrarianRepo librarianRepo;
    @Autowired
    private ReaderRepo readerRepo;
    @Override
    public List<Boraction> findByBookId(int id) {
        try {
            Optional<List<Book>> _books = Optional.ofNullable(bookRepo.findAll());
            if (!_books.isPresent()) {
                return null;
            }
            Optional<Book> _book = bookRepo.findById(id);
            if (!_book.isPresent()) {
                return null;
            }
            List<Boraction> res = new ArrayList<>();
            List<Boraction> allBoraction = boractionRepo.findAll();
            for (var b : allBoraction) {
                if(b.getBookId() == id) {
                    res.add(b);
                }
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
    public List<Boraction> findByLibrarianId(int id) {
        try {
            Optional<List<Librarian>> _librarians = Optional.ofNullable(librarianRepo.findAll());
            if (!_librarians.isPresent()) {
                return null;
            }
            Optional<Librarian> _librarian = librarianRepo.findById(id);
            if (!_librarian.isPresent()) {
                return null;
            }
            List<Boraction> res = new ArrayList<>();
            List<Boraction> allBoraction = boractionRepo.findAll();
            for (var b : allBoraction) {
                if(b.getLibrarianId() == id) {
                    res.add(b);
                }
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
    public List<Boraction> findByReaderId(int id) {
        try {
            Optional<List<Reader>> _readers = Optional.ofNullable(readerRepo.findAll());
            if (!_readers.isPresent()) {
                return null;
            }
            Optional<Reader> _reader = readerRepo.findById(id);
            if (!_reader.isPresent()) {
                return null;
            }
            List<Boraction> res = new ArrayList<>();
            List<Boraction> allBoraction = boractionRepo.findAll();
            for (var b : allBoraction) {
                if(b.getReaderId() == id) {
                    res.add(b);
                }
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
    public List<Boraction> getAll() {
        return boractionRepo.findAll();
    }
//    @Override
//    public ResponseObject<List<Boraction>> findByBookId(int id) {
//        try {
//            Optional<List<Book>> _books = Optional.ofNullable(bookRepo.findAll());
//            if (!_books.isPresent()) {
//                return new ResponseObject<>("danh sach sach trong", null);
//            }
//            Optional<Book> _book = bookRepo.findById(id);
//            if (!_book.isPresent()) {
//                return new ResponseObject<>("ma sach khong hop le", null);
//            }
//            List<Boraction> res = new ArrayList<>();
//            List<Boraction> allBoraction = boractionRepo.findAll();
//            for (var b : allBoraction) {
//                if(b.getBookId() == id) {
//                    res.add(b);
//                }
//            }
//            if (res.size() == 0) {
//                return new ResponseObject<>("danh sach trong", null);
//            }
//            return new ResponseObject<>("lay danh sach thanh cong", res);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
//
//    @Override
//    public ResponseObject<List<Boraction>> findByLibrarianId(int id) {
//        try {
//            Optional<List<Librarian>> _librarians = Optional.ofNullable(librarianRepo.findAll());
//            if (!_librarians.isPresent()) {
//                return new ResponseObject<>("danh sach sach trong", null);
//            }
//            Optional<Librarian> _librarian = librarianRepo.findById(id);
//            if (!_librarian.isPresent()) {
//                return new ResponseObject<>("ma thu thu khong hop le", null);
//            }
//            List<Boraction> res = new ArrayList<>();
//            List<Boraction> allBoraction = boractionRepo.findAll();
//            for (var b : allBoraction) {
//                if(b.getLibrarianId() == id) {
//                    res.add(b);
//                }
//            }
//            if (res.size() == 0) {
//                return new ResponseObject<>("danh sach trong", null);
//            }
//            return new ResponseObject<>("lay danh sach thanh cong", res);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
}
