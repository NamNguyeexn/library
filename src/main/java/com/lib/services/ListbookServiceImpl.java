package com.lib.services;

import com.lib.beans.Listbook;

import java.util.List;

public interface ListbookServiceImpl {
    List<Listbook> findByNameAuthor(String name);
}
