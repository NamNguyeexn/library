package com.lib.services.impl;

import com.lib.beans.Borpaper;
//import com.lib.beans.ResponseObject;
import com.lib.beans.Reader;
import com.lib.repository.BoractionRepo;
import com.lib.repository.BorpaperRepo;
import com.lib.services.BoractionServiceImpl;
import com.lib.services.BorpaperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private BoractionServiceImpl boractionService;
    private String xuLyNgayThang(String s) {
        String[] res = s.split("/");
        if (res[0].length() < 2) {
            res[0] = '0' + res[0];
        }
        if (res[1].length() < 2) {
            res[1] = '0' + res[1];
        }
        return res[0] + res[1] + res[2];
    }
    @Override
    public List<Borpaper> getBorpapersByTimeToTime(String lDay, String rDay) {
        try {
            lDay = xuLyNgayThang(lDay);
            rDay = xuLyNgayThang(rDay);
            if (lDay.compareTo(rDay) > 0) {
                return null;
            }
            Optional<List<Borpaper>> _borpapers = Optional.of(borpaperRepo.findAll());
//            if (!_borpapers.isPresent()) {
//                return null;
//            }
            List<Borpaper> res = new ArrayList<>();
            for (var bp : _borpapers.get()) {
                if (xuLyNgayThang(bp.getBorDay()).compareTo(lDay) > 0 && xuLyNgayThang(bp.getLastDay()).compareTo(rDay) < 0) {
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
    public List<Borpaper> getBorpaperByTimeEnd(String rDay) {
        try {
            rDay = xuLyNgayThang(rDay);
            Optional<List<Borpaper>> _borpapers = Optional.of(borpaperRepo.findAll());
//            if (!_borpapers.isPresent()) {
//                return null;
//            }
            List<Borpaper> res = new ArrayList<>();
            for (var bp : _borpapers.get()) {
                if (xuLyNgayThang(bp.getLastDay()).compareTo(rDay) < 0) {
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
    public List<Borpaper> getBorpaperByTimeStart(String lDay) {
        try {
            lDay = xuLyNgayThang(lDay);
            Optional<List<Borpaper>> _borpapers = Optional.of(borpaperRepo.findAll());
//            if (!_borpapers.isPresent()) {
//                return new ResponseObject<>("danh sach giay muon sach trong", null);
//            }
            List<Borpaper> res = new ArrayList<>();
            for (var bp : _borpapers.get()) {
                if (xuLyNgayThang(bp.getBorDay()).compareTo(lDay) > 0) {
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
            Optional<List<Borpaper>> _borpapers = Optional.of(borpaperRepo.findAll());
//            if (!_borpapers.isPresent()) {
//                return new ResponseObject<>("danh sach giay muon sach trong", null);
//            }
            List<Borpaper> res = new ArrayList<>();
            for (var bp : _borpapers.get()) {
                if (xuLyNgayThang(bp.getLastDay()).compareTo(xuLyNgayThang(bp.getRetDay())) < 0 ||
                        bp.getRetDay() == null) {
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

//    @Override
//    public ResponseObject<List<Borpaper>> getBorpapersByTimeToTime(String lDay, String rDay) {
//        try {
//            lDay = xuLyNgayThang(lDay);
//            rDay = xuLyNgayThang(rDay);
//            if (lDay.compareTo(rDay) > 0) {
//                return new ResponseObject<>("ngay thang nhap vao khong hop le", null);
//            }
//            Optional<List<Borpaper>> _borpapers = Optional.of(borpaperRepo.findAll());
//            if (!_borpapers.isPresent()) {
//                return new ResponseObject<>("danh sach giay muon sach trong", null);
//            }
//            List<Borpaper> res = new ArrayList<>();
//            for (var bp : _borpapers.get()) {
//                if (xuLyNgayThang(bp.getBorDay()).compareTo(lDay) > 0 && xuLyNgayThang(bp.getLastDay()).compareTo(rDay) < 0) {
//                    res.add(bp);
//                }
//            }
//            if (res.size() == 0) {
//                return new ResponseObject<>("danh sach can tim trong", null);
//            }
//            return new ResponseObject<>("lay danh sach thanh cong", res);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
//
//    @Override
//    public ResponseObject<List<Borpaper>> getBorpaperByTimeEnd(String rDay) {
//        try {
//            rDay = xuLyNgayThang(rDay);
//            Optional<List<Borpaper>> _borpapers = Optional.of(borpaperRepo.findAll());
//            if (!_borpapers.isPresent()) {
//                return new ResponseObject<>("danh sach giay muon sach trong", null);
//            }
//            List<Borpaper> res = new ArrayList<>();
//            for (var bp : _borpapers.get()) {
//                if (xuLyNgayThang(bp.getLastDay()).compareTo(rDay) < 0) {
//                    res.add(bp);
//                }
//            }
//            if (res.size() == 0) {
//                return new ResponseObject<>("danh sach can tim trong", null);
//            }
//            return new ResponseObject<>("lay danh sach thanh cong", res);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
//
//    @Override
//    public ResponseObject<List<Borpaper>> getBorpaperByTimeStart(String lDay) {
//        try {
//            lDay = xuLyNgayThang(lDay);
//            Optional<List<Borpaper>> _borpapers = Optional.of(borpaperRepo.findAll());
//            if (!_borpapers.isPresent()) {
//                return new ResponseObject<>("danh sach giay muon sach trong", null);
//            }
//            List<Borpaper> res = new ArrayList<>();
//            for (var bp : _borpapers.get()) {
//                if (xuLyNgayThang(bp.getBorDay()).compareTo(lDay) > 0) {
//                    res.add(bp);
//                }
//            }
//            if (res.size() == 0) {
//                return new ResponseObject<>("danh sach can tim trong", null);
//            }
//            return new ResponseObject<>("lay danh sach thanh cong", res);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
//
//    @Override
//    public ResponseObject<List<Borpaper>> getBorpaperOutOfDate() {
//        try {
//            Optional<List<Borpaper>> _borpapers = Optional.of(borpaperRepo.findAll());
//            if (!_borpapers.isPresent()) {
//                return new ResponseObject<>("danh sach giay muon sach trong", null);
//            }
//            List<Borpaper> res = new ArrayList<>();
//            for (var bp : _borpapers.get()) {
//                if (xuLyNgayThang(bp.getLastDay()).compareTo(xuLyNgayThang(bp.getRetDay())) < 0 ||
//                        bp.getRetDay() == null) {
//                    res.add(bp);
//                }
//            }
//            if (res.size() == 0) {
//                return new ResponseObject<>("danh sach can tim trong", null);
//            }
//            return new ResponseObject<>("lay danh sach thanh cong", res);
//        } catch (Exception e) {
//            return new ResponseObject<>(e + " null", null);
//        }
//    }
}
