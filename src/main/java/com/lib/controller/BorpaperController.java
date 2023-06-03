package com.lib.controller;

import com.lib.beans.Book;
import com.lib.beans.Borpaper;
import com.lib.beans.Librarian;
import com.lib.repository.BorpaperRepo;
import com.lib.services.BorpaperServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/borpaper")
public class BorpaperController {
    @Autowired
    private BorpaperRepo borpaperRepo;
    @Autowired
    private BorpaperServiceImpl borpaperService;
    @RequestMapping("/all")
    public String getAll(Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Borpaper> _borpaper = borpaperRepo.findAll();
        model.addAttribute("borpapers", _borpaper);
        return "borpaper";
    }
    @RequestMapping("/timetotime/{timeL}to{timeR}")
    public String getTimetoTime (@PathVariable("timeL") String timeL, @PathVariable("timeR") String timeR, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Borpaper> _borpapers = borpaperService.getBorpapersByTimeToTime(timeL, timeR);
        model.addAttribute("borpapers", _borpapers);
        return "borpaperTimetoTime";
    }
    @RequestMapping("/beforetime/{timeR}")
    public String getBeforeTime (@PathVariable("timeR") String timeR, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Borpaper> _borpapers = borpaperService.getBorpaperByTimeEnd(timeR);
        model.addAttribute("borpapers", _borpapers);
        return "borpaperBeforeTime";
    }
    @RequestMapping("/aftertime/{timeL}")
    public String getTimetoTime (@PathVariable("timeL") String timeL, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Borpaper> _borpapers = borpaperService.getBorpaperByTimeStart(timeL);
        model.addAttribute("borpapers", _borpapers);
        return "borpaperAfterTime";
    }
    @RequestMapping("/outofdate")
    public String getTimetoTime (Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Borpaper> _borpapers = borpaperService.getBorpaperOutOfDate();
        model.addAttribute("borpapers", _borpapers);
        return "borpaperOutOfDate";
    }
    @RequestMapping("/findByReaderId/{id}")
    public String findByReaderId (@PathVariable("id") int id, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Borpaper> _borpapers = borpaperService.findByReaderId(id);
        model.addAttribute("borpapers", _borpapers);
        return "borpaperFindByReaderId";
    }
//    @RequestMapping("/find{idL}{idR}")
//    public String buttonFind (@PathVariable("idL") int idL, @PathVariable("idR") int idR, Model model, HttpSession session) {
//        Librarian librarian = (Librarian) session.getAttribute("librarian");
//        try {
//            if (librarian == null) {
//                return "redirect:/login";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (idL.) {
//
//        }
//    }
}
