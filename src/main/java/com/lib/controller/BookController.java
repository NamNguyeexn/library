package com.lib.controller;

import com.lib.beans.Billbook;
import com.lib.beans.Book;
import com.lib.beans.Librarian;
import com.lib.repository.BookRepo;
import com.lib.repository.ListbookRepo;
import com.lib.services.BookServiceImpl;
import com.lib.services.ListbookServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private ListbookRepo listbookRepo;
//    @Autowired
//    private ListbookServiceImpl listbookService;
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
        ArrayList<Book> _book = bookRepo.findAll();
        model.addAttribute("books", _book);
        return "book";
    }
    @GetMapping("/findByKey/{key}")
    public String findByKey(@PathVariable("key") String key, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Book> res = new ArrayList<>();
        List<String> nameBook = new ArrayList<>();
        List<String> nameAuthor = new ArrayList<>();
        for (var b: listbookRepo.findAll()) {
            if(b.getName().contains(key)) {
                nameBook.add(b.getName());
            }
            if(b.getAuthor().contains(key)) {
                nameAuthor.add(b.getAuthor());
            }
        }
        for (var i : nameBook) {
            res.addAll(bookService.findByNameBook(i));
        }
        for (var i : nameBook) {
            res.addAll(bookService.findByNameAuthor(i));
        }
        model.addAttribute("books", res).addAttribute("nameBook", nameBook);
        return "bookFind";
    }
}
