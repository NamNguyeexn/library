package com.lib.controller;

import com.lib.beans.Billbook;
import com.lib.beans.Librarian;
import com.lib.services.BillbookServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/billbook")
public class BillbookController {
    @Autowired
    private BillbookServiceImpl billbookService;
    private int billId;
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
        billId = (int) billbookService.getNumId() + 1;
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
            return "redirect:/billbook/all";
        } else {
            model.addAttribute("billbooks", _billbook);
            System.out.println("SO LUONG HOA DON LA " + _billbook.size());
            return "billbookFindById";
        }
    }
    @RequestMapping("/addBillbook")
    public String addBillbook(@ModelAttribute("billbook") Billbook billbook,
                              Model model,
                              HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Billbook billbook1 = new Billbook();
        billbook1.setId(billId);
        model.addAttribute("billbook", billbook1);
        return "billbookAdd";
    }
    @RequestMapping("/saveBillbook")
    public String saveBillbook(@ModelAttribute("billbook") Billbook billbook,
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
        billbookService.addBookByBillbook(billbook);
        return "redirect:/billbook/all";
    }

}
