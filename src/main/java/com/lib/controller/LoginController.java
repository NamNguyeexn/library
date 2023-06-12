package com.lib.controller;

import com.lib.beans.Librarian;
//import com.lib.beans.ResponseObject;
import com.lib.services.LibrarianServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    private LibrarianServiceImpl librarianService;
    @RequestMapping (value = "/librarian", method = {RequestMethod.GET, RequestMethod.POST})
    public String checkLogin(@ModelAttribute("librarian") Librarian librarian, Model model, HttpServletRequest request) {
        try {
            librarian = librarianService.getLibrarianByEmailAndPassword(librarian.getUsername(), librarian.getPassword());
            if(librarian == null) System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLLL");
            if (librarian != null) {
                model.addAttribute("librarian", librarian);
                HttpSession session = request.getSession();
                session.setAttribute("librarian", librarian);
                return "librarianSys";
            }
        } catch (Exception e) {
            model.addAttribute("loi", "Ten dang nhap hoac mat khau chua dung, vui long nhap lai!");
            return "loginSys";
        }
        model.addAttribute("loi", "Ten dang nhap hoac mat khau chua dung, vui long nhap lai!");
        return "loginSys";
    }
}
