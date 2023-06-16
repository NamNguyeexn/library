package com.lib.controller;

import com.lib.beans.Book;
import com.lib.beans.Librarian;
import com.lib.beans.input.StringInput;
import com.lib.services.BookServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/findByKey/frm")
    public String findByKeyFrm(Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringInput stringInput = new StringInput();
        model.addAttribute("stringInput", stringInput);
        return "bookFind";
    }
    @RequestMapping("/findByKey")
    public String findByKey(@ModelAttribute("stringInput") StringInput stringInput, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String key = stringInput.getStr();
        System.out.println("LOGGGGGGGGGGGGGGGGGG " + key);
        List<Book> res = bookService.getByKey(key);
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
