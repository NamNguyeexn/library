package com.lib.controller;

import com.lib.beans.Book;
import com.lib.beans.Librarian;
import com.lib.services.BookServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
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
        List<Book> _book = bookService.getAll();
        List<String> _name = new ArrayList<>();
        for (var b : _book) {
            _name.add(bookService.getName(b.getListbook_id()));
        }
        model.addAttribute("books", _book);
        model.addAttribute("name", _name);
        return "book";
    }
    @RequestMapping("/findByKey/{key}")
    public String findByKey(@PathVariable(name = "key") String key, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Book> res = bookService.getByKey(key);
//        System.out.println("TU KHOA TIM KIEM " + key + " CHO RA " + res.size() + " KET QUA");
        System.out.printf("TU KHOA TIM KIEM %s CHO RA %d KET QUA", key, res.size());
        List<String> _name = new ArrayList<>();
        for (var b : res) {
            _name.add(bookService.getName(b.getListbook_id()));
        }
        model.addAttribute("books", res);
        model.addAttribute("name", _name);
        return "bookFind";
    }
}
