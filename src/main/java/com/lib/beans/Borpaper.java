package com.lib.beans;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "borpaper")
public class Borpaper {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "bor_day", nullable = false)
    private LocalDate borDay;
    @Column(name = "ret_day", nullable = false)
    private LocalDate retDay;
    @Column(name = "last_day", nullable = false)
    private LocalDate lastDay;
    @Column(name = "detail", nullable = false)
    private String detail; //danh sach id sach
    @Column(name = "status", nullable = false)
    private String status;

    public Borpaper() {
    }

    public Borpaper(int id, LocalDate borDay, LocalDate retDay, LocalDate lastDay, String detail, String status) {
        this.id = id;
        this.borDay = borDay;
        this.retDay = retDay;
        this.lastDay = lastDay;
        this.detail = detail;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBorDay() {
        return borDay;
    }

    public void setBorDay(LocalDate borDay) {
        this.borDay = borDay;
    }

    public LocalDate getRetDay() {
        return retDay;
    }

    public void setRetDay(LocalDate retDay) {
        this.retDay = retDay;
    }

    public LocalDate getLastDay() {
        return lastDay;
    }

    public void setLastDay(LocalDate lastDay) {
        this.lastDay = lastDay;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
