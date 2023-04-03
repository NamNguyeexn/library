package com.lib.services.impl;

import com.lib.beans.Borpaper;
import com.lib.dao.BorpaperDao;
import com.lib.services.BorpaperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BorpaperService implements BorpaperServiceImpl {
    @Autowired
    private BorpaperDao borpaperDao;
    @Override
    public Borpaper getBorpaperById (String id) {
        List<Borpaper> lst = borpaperDao.getAllBorpapers();
        for(var b : lst) {
            if(b.getId().matches(id))
                return b;
        }
        return null;
    }
    @Override
    public List<Borpaper> getBorpapersByTime (String lDay, String rDay) {
        // tìm phiếu mượn trong khoảng thời gian
        List<Borpaper> lst = borpaperDao.getAllBorpapers(), res = null;
        for (var b : lst) {
            String[] c1 = b.getBorDay().split("/"), c2 = lDay.split("/"), c3 = rDay.split("/");
            if(c1[0].compareTo(c2[0]) > 0 && c1[0].compareTo(c3[0]) < 0) res.add(b);
            else if(c1[1].compareTo(c2[1]) > 0 && c1[0].compareTo(c3[0]) < 0) res.add(b);
            else if(c1[2].compareTo(c2[2]) > 0 && c1[0].compareTo(c3[0]) < 0) res.add(b);
        }
        return res;
    }
    @Override
    public List<Borpaper> getBorpaperByTime (String lDay) {
        // tim phieu muon sau khoang thoi gian nay
        List<Borpaper> lst = borpaperDao.getAllBorpapers(), res = null;
        for (var b : lst) {
            String[] c1 = b.getBorDay().split("/"), c2 = lDay.split("/");
            if(c1[0].compareTo(c2[0]) > 0) res.add(b);
            else if(c1[1].compareTo(c2[1]) > 0) res.add(b);
            else if(c1[2].compareTo(c2[2]) > 0) res.add(b);
        }
        return res;
    }
}
