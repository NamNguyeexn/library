package com.lib.services;

import com.lib.beans.Book;
import com.lib.beans.Borpaper;
//import com.lib.beans.ResponseObject;

import java.util.List;
public interface BorpaperServiceImpl {
    List<Borpaper> getBorpapersByTimeToTime (String lDay, String rDay);
    List<Borpaper> getBorpaperByTimeEnd (String rDay);
    List<Borpaper> getBorpaperByTimeStart (String lDay);
    List<Borpaper> getBorpaperOutOfDate ();
    List<Borpaper> findByReaderId(int id);
    List<Borpaper> getAll();
    int getLibrarianId(int paperId);
    int getReaderId(int paperId);
    Borpaper getById(int id);
    List<Book> getBookInBorpaper(int borpaperId);
}
