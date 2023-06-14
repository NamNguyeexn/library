package com.lib.controller;

import com.lib.beans.Book;
import com.lib.beans.Borpaper;
import com.lib.beans.Librarian;
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
        List<Borpaper> _borpaper = borpaperService.getAll();
        List<Integer> _librarianId = new ArrayList<>(), _readerId = new ArrayList<>();
        model.addAttribute("borpapers", _borpaper);
        for (var b : _borpaper) {
            _librarianId.add(borpaperService.getLibrarianId(b.getId()));
            _readerId.add(borpaperService.getReaderId(b.getId()));
        }
        model.addAttribute("librarianId", _librarianId);
        model.addAttribute("readerId", _readerId);
        return "borpaper";
    }
    @RequestMapping("/find/{id}")
    public String getById(@PathVariable("id") int id, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Borpaper _borpaper = borpaperService.getById(id);
        int _librarianId = borpaperService.getLibrarianId(_borpaper.getId());
        int _readerId = borpaperService.getReaderId(_borpaper.getId());
        model.addAttribute("borpaper", _borpaper);
        model.addAttribute("librarianId", _librarianId);
        model.addAttribute("readerId", _readerId);
        List<Book> books = borpaperService.getBookInBorpaper(_borpaper.getId());
        model.addAttribute("books", books);
        return "borpaperFindById";
    }
    @RequestMapping("/timetotime/frm")
    public String getTimetoTimeFrm(HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "borpaperTimetoTimeFrm";
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
        model.addAttribute("str", " từ " + timeL + " đến " + timeR);
        return "borpaperTimetoTimeFrm";
    }
    @RequestMapping("/beforetime/frm")
    public String getBeforeTimeFrm(HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "borpaperBeforeTimeFrm";
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
        model.addAttribute("str", " trước ngày " + timeR);
        return "borpaperBeforeTimeFrm";
    }
    @RequestMapping("/aftertime/frm")
    public String getAfterTimeFrm(HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "borpaperAfterTimeFrm";
    }
    @RequestMapping("/aftertime/{timeL}")
    public String getAfterTime (@PathVariable("timeL") String timeL, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Borpaper> _borpapers = borpaperService.getBorpaperByTimeStart(timeL);
        model.addAttribute("str", " sau ngày " + timeL);
        return "borpaperAfterTimeFrm";
    }
    @RequestMapping("/outofdate/frm")
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
        model.addAttribute("str", " quá hạn");
        return "borpaperOutOfDateFrm";
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
        model.addAttribute("str", " của bạn đọc có mã : " + String.valueOf(id));
        return "borpaperFindByReaderId";
    }
}
