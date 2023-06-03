package com.lib.controller;

import com.lib.beans.Billbook;
//import com.lib.beans.ResponseObject;
import com.lib.beans.Book;
import com.lib.beans.Librarian;
import com.lib.repository.BillbookRepo;
import com.lib.repository.BookRepo;
import com.lib.services.BillbookServiceImpl;
import com.lib.services.BookServiceImpl;
import com.lib.services.impl.BillbookService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/billbook")
public class BillbookController {
    @Autowired
    private BillbookServiceImpl billbookService;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BillbookRepo billbookRepo;
    @Autowired
    private BookServiceImpl bookService;
    @GetMapping("/all")
    public String getAll(Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Billbook> _billbook = billbookRepo.findAll();
        model.addAttribute("billbooks", _billbook);
        return "billbook";
    }
    @RequestMapping("/findByLibrarian/{id}")
    public String getByLibrarianId(@PathVariable("id") int id, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Billbook> _billbook = billbookService.findByLibrarianId(id);
        if (_billbook == null) {
            return "redirect:/all";
        } else {
            List<Billbook> res = new ArrayList<>();
            for (var b : _billbook) {
                if(b.getLibrarianId() == id) {
                    res.add(b);
                }
            }
            model.addAttribute("billbooks", res);
            return "billbookFindById";
        }
    }
    @RequestMapping("/addBillbook")
    public String addBillbook(@ModelAttribute("billbook") Billbook billbook, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Optional<Billbook> _billbook = billbookRepo.findById(billbook.getId());
        if (!_billbook.isPresent()) {
            model.addAttribute("loi", "da ton tai hoa don");
        }
        return "billbookAdd";
    }
    @RequestMapping("/saveBillbook")
    public String saveBillbook(@ModelAttribute("billbook") Billbook billbook, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int check = 0;
        for (var b : bookRepo.findAll()) {
            if (b.getId() == billbook.getId()) {
                check = 1;
                break;
            }
        }
        if (check == 0) {
            billbookRepo.save(billbook);
//            int count = maxof(bookService.findByName(billbook.getName()).size());
            int count = 0;
            for (var b : bookService.findByNameBook(billbook.getName())) {
                if (b.getId() > count) {
                    count = b.getId();
                }
            }
            for (int i = 1; i <= billbook.getAmount(); i++) {
                bookRepo.save(new Book(count + i, "", billbook.getId()));
            }
            model.addAttribute("billbook", billbook);
        }
        else {
            model.addAttribute("loi", "da ton tai hoa don");
        }
        return "billbook";
    }

}
