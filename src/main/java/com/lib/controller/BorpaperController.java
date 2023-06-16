package com.lib.controller;

import com.lib.beans.Book;
import com.lib.beans.Borpaper;
import com.lib.beans.Librarian;
import com.lib.beans.input.BorpaperInput;
import com.lib.beans.input.DateInput;
import com.lib.beans.input.DoubleInput;
import com.lib.services.BorpaperServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/borpaper")
public class BorpaperController {
    @Autowired
    private BorpaperServiceImpl borpaperService;
    private Borpaper borpaperUp = new Borpaper();
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
        List<Integer> _librarianId = borpaperService.getAllLibrarianId(_borpaper);
        List<Integer> _readerId = borpaperService.getAllReaderId(_borpaper);


        model.addAttribute("borpapers", _borpaper);
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
        List<Book> books = borpaperService.getBookInBorpaper(_borpaper.getId());
        List<String> _name = new ArrayList<>();
        for (var b : books) {
            _name.add(borpaperService.getName(b.getListbook_id()));
        }

        model.addAttribute("borpaper", _borpaper);
        model.addAttribute("librarianId", _librarianId);
        model.addAttribute("readerId", _readerId);
        model.addAttribute("books", books);
        model.addAttribute("name", _name);
        return "borpaperFindById";
    }
    @RequestMapping("/timetotime/frm")
    public String getTimetoTimeFrm(HttpSession session, Model model) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DoubleInput doubleInput = new DoubleInput();
        model.addAttribute("doubleInput", doubleInput);
        return "borpaperTimetoTime";
    }
    @RequestMapping("/timetotime")
    public String getTimetoTime (@ModelAttribute("doubleInput") DoubleInput doubleInput, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocalDate tL = doubleInput.getStrL(), tR = doubleInput.getStrR();
        List<Borpaper> _borpapers = borpaperService.getBorpapersByTimeToTime(tL, tR);
        model.addAttribute("str", "Danh sách phiếu mượn từ ngày " + tL + " đến ngày " + tR);
        List<Integer> _librarianId = borpaperService.getAllLibrarianId(_borpapers);
        List<Integer> _readerId = borpaperService.getAllReaderId(_borpapers);

        model.addAttribute("borpapers", _borpapers);
        model.addAttribute("librarianId", _librarianId);
        model.addAttribute("readerId", _readerId);
        return "borpaperTimetoTime";
    }
    @RequestMapping("/beforetime/frm")
    public String getBeforeTimeFrm(HttpSession session, Model model) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateInput dateInput = new DateInput();
        model.addAttribute("dateInput", dateInput);
        return "borpaperBeforeTime";
    }
    @RequestMapping("/beforetime")
    public String getBeforeTime (@ModelAttribute("dateInput") DateInput dateInput, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocalDate tR = dateInput.getStr();
        List<Borpaper> _borpapers = borpaperService.getBorpaperByTimeEnd(tR);
        List<Integer> _librarianId = borpaperService.getAllLibrarianId(_borpapers);
        List<Integer> _readerId = borpaperService.getAllReaderId(_borpapers);

        model.addAttribute("borpapers", _borpapers);
        model.addAttribute("str", "Danh sách phiếu mượn trước ngày " + tR);
        model.addAttribute("librarianId", _librarianId);
        model.addAttribute("readerId", _readerId);
        return "borpaperBeforeTime";
    }
    @RequestMapping("/aftertime/frm")
    public String getAfterTimeFrm(HttpSession session, Model model) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateInput dateInput = new DateInput();
        model.addAttribute("dateInput", dateInput);
        return "borpaperAfterTime";
    }
    @RequestMapping("/aftertime")
    public String getAfterTime (@ModelAttribute("dateInput") DateInput dateInput, Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocalDate tL = dateInput.getStr();
        List<Borpaper> _borpapers = borpaperService.getBorpaperByTimeStart(tL);
        List<Integer> _librarianId = borpaperService.getAllLibrarianId(_borpapers);
        List<Integer> _readerId = borpaperService.getAllReaderId(_borpapers);

        model.addAttribute("str", "Danh sách phiếu mượn sau ngày " + tL);
        model.addAttribute("borpapers", _borpapers);
        model.addAttribute("librarianId", _librarianId);
        model.addAttribute("readerId", _readerId);
        return "borpaperAfterTime";
    }
    @RequestMapping("/outofdate/frm")
    public String getOutOfDate (Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Borpaper> _borpapers = borpaperService.getBorpaperOutOfDate();
        List<Integer> _librarianId = borpaperService.getAllLibrarianId(_borpapers);
        List<Integer> _readerId = borpaperService.getAllReaderId(_borpapers);

        model.addAttribute("str", "Danh sách phiếu mượn quá hạn");
        model.addAttribute("borpapers", _borpapers);
        model.addAttribute("librarianId", _librarianId);
        model.addAttribute("readerId", _readerId);
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
        model.addAttribute("str", " của bạn đọc có mã : " + String.valueOf(id));
        return "borpaperFindByReaderId";
    }
    @RequestMapping("/addBorpaper")
    public String addBorpaper(Model model, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Borpaper borpaper1 = new Borpaper();
        model.addAttribute("borpaper", borpaper1);
        return "borpaperAdd";
    }
    @RequestMapping("/saveBorpaper")
    public String saveBorpaper(@ModelAttribute("borpaper") Borpaper borpaper, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        borpaperService.saveBorpaper(borpaper);
        return "redirect:/borpaper/all";
    }
    @RequestMapping("/updateBorpaper/{id}")
    public String updateBorpaper(@PathVariable(value = "id") int id, HttpSession session, Model model) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BorpaperInput borpaperInput = new BorpaperInput();
        Borpaper _borpaper = borpaperService.getById(id);
        borpaperUp = _borpaper;
        int _librarianId = borpaperService.getLibrarianId(_borpaper.getId());
        int _readerId = borpaperService.getReaderId(_borpaper.getId());
        List<Book> books = borpaperService.getBookInBorpaper(_borpaper.getId());
        List<String> _name = new ArrayList<>();
        for (var b : books) {
            _name.add(borpaperService.getName(b.getListbook_id()));
        }
        model.addAttribute("borpaperInput", borpaperInput);
        model.addAttribute("borpaper", _borpaper);
        model.addAttribute("librarianId", _librarianId);
        model.addAttribute("readerId", _readerId);
        model.addAttribute("books", books);
        model.addAttribute("name", _name);

        return "borpaperUpdate";
    }
    @RequestMapping("/saveBorpaperUpdate")
    public String saveBorpaperUpdate(@ModelAttribute("borpaperInput") BorpaperInput borpaperInput, HttpSession session) {
        Librarian librarian = (Librarian) session.getAttribute("librarian");
        try {
            if (librarian == null) {
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        borpaperUp.setRetDay(borpaperInput.getRetDay());
        borpaperUp.setStatus(borpaperInput.getStatus());
        borpaperService.saveBorpaper(borpaperUp);
        return "redirect:/borpaper/all";
    }
}
