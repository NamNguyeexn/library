package com.lib.services.impl;

import com.lib.beans.Book;
import com.lib.beans.Borpaper;
import com.lib.repository.BookRepo;
import com.lib.repository.BoractionRepo;
import com.lib.repository.BorpaperRepo;
import com.lib.repository.ListbookRepo;
import com.lib.services.BoractionServiceImpl;
import com.lib.services.BorpaperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BorpaperService implements BorpaperServiceImpl {
    @Autowired
    private BorpaperRepo borpaperRepo;
    @Autowired
    private BoractionRepo boractionRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private ListbookRepo listbookRepo;
    @Autowired
    private BoractionServiceImpl boractionService;
    @Override
    public List<Borpaper> getBorpapersByTimeToTime(LocalDate lDay, LocalDate rDay) {
        try {
            if (lDay.compareTo(rDay) > 0) {
                return null;
            }
            List<Borpaper> _borpapers = borpaperRepo.findAll();
            List<Borpaper> res = new ArrayList<>();
            for (var bp : _borpapers) {
                if (bp.getBorDay().compareTo(lDay) > 0 && bp.getLastDay().compareTo(rDay) < 0) {
                    res.add(bp);
                }
            }
            if (res.size() == 0) {
                return null;
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Borpaper> getBorpaperByTimeEnd(LocalDate rDay) {
        try {
            List<Borpaper> _borpapers = borpaperRepo.findAll();
            List<Borpaper> res = new ArrayList<>();
            for (var bp : _borpapers) {
                if (bp.getLastDay().compareTo(rDay) > 0) {
                    res.add(bp);
                }
            }
            if (res.size() == 0) {
                return null;
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Borpaper> getBorpaperByTimeStart(LocalDate lDay) {
        try {
            List<Borpaper> _borpapers = borpaperRepo.findAll();
            List<Borpaper> res = new ArrayList<>();
            for (var bp : _borpapers) {
                if (bp.getBorDay().compareTo(lDay) > 0) {
                    res.add(bp);
                }
            }
            if (res.size() == 0) {
                return null;
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Borpaper> getBorpaperOutOfDate() {
        try {
            List<Borpaper> _borpapers = borpaperRepo.findAll();
            List<Borpaper> res = new ArrayList<>();
            for (var bp : _borpapers) {
                if (bp.getLastDay().compareTo(bp.getRetDay()) < 0) {
                    res.add(bp);
                }
//                if(bp.getStatus().compareTo("out") == 0) {
//                    res.add(bp);
//                }
            }
            if (res.size() == 0) {
                return null;
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Borpaper> findByReaderId(int id) {
        try {
            List<Borpaper> res = new ArrayList<>();
            for (var b : boractionService.findByReaderId(id)) {
                Optional<Borpaper> bp = borpaperRepo.findById(b.getPaperId());
                if (!bp.isPresent()) {
                    continue;
                }
                res.add(bp.get());
            }
            if (res.size() == 0) {
                return null;
            }
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Borpaper> getAll() {
        return borpaperRepo.findAll();
    }

    @Override
    public int getLibrarianId(int paperId) {
        for (var b : boractionRepo.findAll()) {
            if (b.getPaperId() == paperId) {
                return b.getLibrarianId();
            }
        }
        return 0;
    }

    @Override
    public int getReaderId(int paperId) {
        for (var b : boractionRepo.findAll()) {
            if (b.getPaperId() == paperId) {
                return b.getReaderId();
            }
        }
        return 0;
    }

    @Override
    public Borpaper getById(int id) {
        return borpaperRepo.findById(id).get();
    }

    @Override
    public List<Book> getBookInBorpaper(int borpaperId) {
        List<Book> res = new ArrayList<>();
        String lBook = borpaperRepo.findById(borpaperId).get().getDetail();
        String[] lstIdBook = lBook.replace(" ", "").trim().split(",");
        for (var s : lstIdBook) {
            res.add(bookRepo.findById(Integer.parseInt(s)).get());
        }
        return res;
    }

    @Override
    public String getName(int listbookId) {
        return listbookRepo.findById(listbookId).get().getName();
    }

    @Override
    public void saveBorpaper(Borpaper borpaper) {
        borpaperRepo.save(borpaper);
    }

    @Override
    public List<Integer> getAllReaderId(List<Borpaper> borpapers) {
        List<Integer> _readerId = new ArrayList<>();
        for (var b : borpapers) {
            _readerId.add(getLibrarianId(b.getId()));
        }
        return _readerId;
    }

    @Override
    public List<Integer> getAllLibrarianId(List<Borpaper> borpapers) {
        List<Integer> _librarianId = new ArrayList<>();
        for (var b : borpapers) {
            _librarianId.add(getLibrarianId(b.getId()));
        }
        return _librarianId;
    }

    @Override
    public void updateBorpaper(Borpaper borpaper) {
        borpaperRepo.save(borpaper);
    }

}
