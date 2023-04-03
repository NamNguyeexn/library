package com.lib.services;

import java.util.List;

import com.lib.beans.Billbook;

public interface BillbookServiceImpl {
    public List<Billbook> getBillbookByPubligherId(String id); // tìm hóa đơn theo mã nhà xuất bản
    public void createBillbook (String id, String name, int cost, int amount, int price, int totalCost, String LibrarianID);
    public void updateBillbookById (String id);
    public void deleteBillbookById (String id);
    public Billbook getBillbookById (String id);
}
