package com.lib.services;

import com.lib.beans.Book;
import com.lib.beans.Borpaper;
//import com.lib.beans.ResponseObject;

import java.time.LocalDate;
import java.util.List;
public interface BorpaperServiceImpl {
    List<Borpaper> getBorpapersByTimeToTime (LocalDate lDay, LocalDate rDay);
    List<Borpaper> getBorpaperByTimeEnd (LocalDate rDay);
    List<Borpaper> getBorpaperByTimeStart (LocalDate lDay);
    List<Borpaper> getBorpaperOutOfDate ();
    List<Borpaper> findByReaderId(int id);
    List<Borpaper> getAll();
    int getLibrarianId(int paperId);
    int getReaderId(int paperId);
    Borpaper getById(int id);
    List<Book> getBookInBorpaper(int borpaperId);
    String getName(int listbookId);
    void saveBorpaper(Borpaper borpaper);
    List<Integer> getAllReaderId(List<Borpaper> borpapers);
    List<Integer> getAllLibrarianId(List<Borpaper> borpapers);
}
