package com.lib.beans.input;

import java.time.LocalDate;

public class DateInput {
    private LocalDate str;

    public DateInput() {
    }

    public DateInput(LocalDate str) {
        this.str = str;
    }

    public LocalDate getStr() {
        return str;
    }

    public void setStr(LocalDate str) {
        this.str = str;
    }
}
