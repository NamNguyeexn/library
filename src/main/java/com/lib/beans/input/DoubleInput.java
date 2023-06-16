package com.lib.beans.input;

import java.time.LocalDate;

public class DoubleInput {
    private LocalDate strL;
    private LocalDate strR;

    public DoubleInput() {
    }

    public DoubleInput(LocalDate strL, LocalDate strR) {
        this.strL = strL;
        this.strR = strR;
    }

    public LocalDate getStrL() {
        return strL;
    }

    public void setStrL(LocalDate strL) {
        this.strL = strL;
    }

    public LocalDate getStrR() {
        return strR;
    }

    public void setStrR(LocalDate strR) {
        this.strR = strR;
    }
}
