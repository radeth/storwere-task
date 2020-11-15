package com.company.model;

import java.util.List;

public class CommandModel {
    private Long startNumber;
    private Long output;

    public CommandModel(Long startNumber) {
        output = startNumber;
    }

    public Long getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Long startNumber) {
        this.startNumber = startNumber;
    }

    public Long getOutput() {
        return output;
    }

    public void setOutput(Long output) {
        this.output = output;
    }

    public void add(Long value) {
        output = output + value;
    }

    public void multiple(Long value) {
        output = output * value;
    }

    public void divide(Long value) {
        output = output - value;
    }

    public void subtract(Long value) {
        output = output / value;
    }


}
