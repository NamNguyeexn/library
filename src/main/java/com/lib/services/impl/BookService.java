package com.lib.services.impl;

import com.lib.beans.*;
import com.lib.repository.BillbookRepo;
import com.lib.repository.BookRepo;
import com.lib.repository.BorpaperRepo;
import com.lib.repository.ListbookRepo;
import com.lib.services.BillbookServiceImpl;
import com.lib.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceImpl {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BorpaperRepo borpaperRepo;
    @Autowired
    private ListbookRepo listbookRepo;
    @Autowired
    private BillbookRepo billbookRepo;
    @Autowired
    private BillbookServiceImpl billbookService;
    @Autowired
    private BookServiceImpl bookService;
    @Override
    public List<Book> findByListbookId(int id) {
        try {
            Optional<Listbook> _listbook = listbookRepo.findById(id);
            if(!_listbook.isPresent()) {
                return null;
            }
            List<Book> res = new ArrayList<>();
            for (var b : bookRepo.findAll()) {
                if (b.getListbook_id() == id) {
                    res.add(b);
                }
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Book> findByBorpaperId(int id) {
        try {
            Optional<Borpaper> _borpaper = borpaperRepo.findById(id);
            if(!_borpaper.isPresent()) {
                return null;
            }
            List<Book> res = new ArrayList<>();
            for (var b : bookRepo.findAll()) {
                if (b.getListbook_id() == id) {
                    res.add(b);
                }
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Book> findByBillbookId(int id) {
        try {
            Optional<Billbook> _billbook = billbookRepo.findById(id);
            if(!_billbook.isPresent()) {
                return null;
            }
            List<Book> res = new ArrayList<>();
            for (var b : bookRepo.findAll()) {
                if (b.getListbook_id() == id) {
                    res.add(b);
                }
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Book> findByNameBook(String name) {
        try {
            Billbook billbook = billbookService.findByNameBillbook(name);
            List<Book> res = bookService.findByBillbookId(billbook.getId());
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Book> findByNameAuthor(String name) {
        List<Book> res = new ArrayList<>();
        for (var b : listbookRepo.findAll())
            if (b.getAuthor().compareTo(name) == 0)
                for (var b1 : bookRepo.findAll()) {
                    if (b1.getListbook_id() == b.getId()) {
                        res.add(b1);
                    }
                }
        return res;
    }
//    @Override
//    public ResponseObject<List<Book>> findByListbookId(int id) {
//        try {
//            Optional<Listbook> _listbook = listbookRepo.findById(id);
//            if(!_listbook.isPresent()) {
//                return new ResponseObject<>("ma dau sach khong hop le", null);
//            }
//            List<Book> res = new ArrayList<>();
//            for (var b : bookRepo.findAll()) {
//                if (b.getListbook_id() == id) {
//                    res.add(b);
//                }
//            }
//            return new ResponseObject<>("lay danh sach thanh cong", null);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
//
//    @Override
//    public ResponseObject<List<Book>> findByBorpaperId(int id) {
//        try {
//            Optional<Borpaper> _borpaper = borpaperRepo.findById(id);
//            if(!_borpaper.isPresent()) {
//                return new ResponseObject<>("ma giay muon khong hop le", null);
//            }
//            List<Book> res = new ArrayList<>();
//            for (var b : bookRepo.findAll()) {
//                if (b.getListbook_id() == id) {
//                    res.add(b);
//                }
//            }
//            return new ResponseObject<>("lay danh sach thanh cong", null);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
//
//    @Override
//    public ResponseObject<List<Book>> findByBillbookId(int id) {
//        try {
//            Optional<Billbook> _billbook = billbookRepo.findById(id);
//            if(!_billbook.isPresent()) {
//                return new ResponseObject<>("ma hoa don khong hop le", null);
//            }
//            List<Book> res = new ArrayList<>();
//            for (var b : bookRepo.findAll()) {
//                if (b.getListbook_id() == id) {
//                    res.add(b);
//                }
//            }
//            return new ResponseObject<>("lay danh sach thanh cong", null);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
}
