package com.lib.beans;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "borpaper")
public class Borpaper {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "bor_day", nullable = false)
    private String borDay;
    @Column(name = "ret_day", nullable = false)
    private String retDay;
    @Column(name = "last_day", nullable = false)
    private String lastDay;
    @Column(name = "detail", nullable = false)
    private String detail; //danh sach id sach
    @Column(name = "status", nullable = false)
    private String status;

    public Borpaper() {
    }

    public Borpaper(int id, String borDay, String retDay, String lastDay, String detail, String status) {
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

    public String getBorDay() {
        return borDay;
    }

    public void setBorDay(String borDay) {
        this.borDay = borDay;
    }

    public String getRetDay() {
        return retDay;
    }

    public void setRetDay(String retDay) {
        this.retDay = retDay;
    }

    public String getLastDay() {
        return lastDay;
    }

    public void setLastDay(String lastDay) {
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
