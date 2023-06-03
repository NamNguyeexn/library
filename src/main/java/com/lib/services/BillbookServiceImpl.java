package com.lib.services;

import java.util.List;

import com.lib.beans.Billbook;
//import com.lib.beans.ResponseObject;

public interface BillbookServiceImpl {
//    ResponseObject<List<Billbook>> findByPublisherId(int id); // tìm hóa đơn theo mã nhà xuất bản
//    ResponseObject<List<Billbook>> findByLibrarianId(int id);
    List<Billbook> findByPublisherId(int id); // tìm hóa đơn theo mã nhà xuất bản
    List<Billbook> findByLibrarianId(int id);
    Billbook findByNameBillbook(String name);
}
