package com.lib.beans.input;

import java.time.LocalDate;

public class BorpaperInput {
    private LocalDate retDay;
    private String status;

    public LocalDate getRetDay() {
        return retDay;
    }

    public void setRetDay(LocalDate retDay) {
        this.retDay = retDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BorpaperInput() {
    }

    public BorpaperInput(LocalDate retDay, String status) {
        this.retDay = retDay;
        this.status = status;
    }
}
