package com.lib.controller;


import com.lib.beans.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LibrarianController {
    @RequestMapping("/librarian")
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
        return "librarianSys";
    }
    @RequestMapping(path = {"/logout", "/login"})
    public ModelAndView returnLogin(HttpSession session) {
        session.invalidate();
        return new ModelAndView("loginSys", "librarian", new Librarian());
    }
}
