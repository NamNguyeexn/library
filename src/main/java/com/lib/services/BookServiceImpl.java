package com.lib.services;

import com.lib.beans.Book;

import java.util.List;


public interface BookServiceImpl {
    List<Book> findByListbookId(int id);
    List<Book> findByBorpaperId(int id);
    List<Book> findByBillbookId(int id);
    List<Book> findByNameBook(String name);
    List<Book> findByNameAuthor(String name);
    List<Book> getAll();
    List<Book> getByKey(String key);
    String getName(int listbookId);
}
