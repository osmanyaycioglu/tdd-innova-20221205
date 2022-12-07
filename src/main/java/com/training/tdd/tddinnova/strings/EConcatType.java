package com.training.tdd.tddinnova.strings;

public enum EConcatType {
    SNAKE("_"), KEBAP("-"), DIVIDE("/");


    private String divider;

    EConcatType(String divider) {

        this.divider = divider;
    }

    public String getDivider() {
        return divider;
    }
}
