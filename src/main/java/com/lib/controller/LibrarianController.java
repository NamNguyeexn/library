package com.lib.controller;


import com.lib.beans.*;
import com.lib.repository.BillbookRepo;
import com.lib.repository.BookRepo;
import com.lib.repository.BoractionRepo;
import com.lib.repository.BorpaperRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LibrarianController {
    @Autowired
    private BillbookRepo billbookRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BoractionRepo boractionRepo;
    @Autowired
    private BorpaperRepo borpaperRepo;
    @RequestMapping("/home")
    public String returnHome(Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("librarian", librarian);
        return "librarian";
    }
    @RequestMapping(path = {"/logout", "/login"})
    public ModelAndView returnLogin(HttpSession session) {
        session.invalidate();
        return new ModelAndView("login", "librarian", new Librarian());
    }
    @RequestMapping("/billbook")
    public String goToBillbook(Model model, HttpSession session){
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Billbook> _billbooks = billbookRepo.findAll();
        model.addAttribute("billbooks", _billbooks);
        return "billbook";
    }
    @RequestMapping("/book")
    public String goToBook(Model model, HttpSession session){
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Book> _books = bookRepo.findAll();
        model.addAttribute("books", _books);
        return "book";
    }
    @RequestMapping("/borpaper")
    public String goToBorpaper(Model model, HttpSession session){
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Borpaper> _borpapers = borpaperRepo.findAll();
        model.addAttribute("borpapers", _borpapers);
        return "borpaper";
    }
}
