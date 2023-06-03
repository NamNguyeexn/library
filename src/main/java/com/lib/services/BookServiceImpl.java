package com.lib.services;

import com.lib.beans.Book;
//import com.lib.beans.ResponseObject;

import java.util.List;


public interface BookServiceImpl {
//    ResponseObject<List<Book>> findByListbookId(int id);
//    ResponseObject<List<Book>> findByBorpaperId(int id);
//    ResponseObject<List<Book>> findByBillbookId(int id);
    List<Book> findByListbookId(int id);
    List<Book> findByBorpaperId(int id);
    List<Book> findByBillbookId(int id);
    List<Book> findByNameBook(String name);
    List<Book> findByNameAuthor(String name);
}
