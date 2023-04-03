package com.lib.services.impl;

import com.lib.beans.Billbook;
import com.lib.dao.BillbookDao;
import com.lib.services.BillbookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BillbookService implements BillbookServiceImpl {
    @Autowired
    private Billbook billbook;
    @Autowired
    private BillbookDao billbookDao;
    @Override
    public List<Billbook> getBillbookByPubligherId(String id) {
        List<Billbook> bills = billbookDao.getAllBillbooks();
        for (var b : billbookDao.getAllBillbooks()) {
            if (id.matches(b.getId()))
                bills.add(b);
        }
        return bills;
    }

    @Override
    public void createBillbook(String id, String name, int cost, int amount, int price, int totalCost, String LibrarianID) {
        Billbook b = new Billbook(id, name, cost, amount, price, totalCost, LibrarianID);
        billbookDao.insert(b);
    }
    @Override
    public Billbook getBillbookById(String id) {
        // tim tat ca sach co ma
        for (var b : billbookDao.getAllBillbooks()) {
            if (b.getId().matches(id))
                return b;
        }
        return null;
    }
    @Override
    public void updateBillbookById(String id) {
        if(getBillbookById(id) == null) {

        }
    }

    @Override
    public void deleteBillbookById(String id) {

    }



}
