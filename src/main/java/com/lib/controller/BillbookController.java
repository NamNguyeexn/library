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
        List<Billbook> _billbook = billbookService.getAll();
        model.addAttribute("billbooks", _billbook);
        return "billbook";
    }
    @RequestMapping("/findByLibrarian")
    public String getByLibrarianId(Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int id = librarian.getId();
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
        Billbook billbook1 = new Billbook();
        model.addAttribute("billbook", billbook1);
        return "billbookAdd";
    }
    @RequestMapping("/saveBillbook")
    public String saveBillbook(@ModelAttribute("billbook") Billbook billbook,
                               @PathVariable("nameAuthor") String nameAuthor,
                               @PathVariable("pubYear") int pubYear,
                               @PathVariable("publisherId") int publisherId,
                               Model model,
                               HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        model.addAttribute("loi", null);
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        billbookService.addBookByBillbook(billbook, nameAuthor, pubYear, publisherId, librarian.getId());
        return "billbook";
    }

}
