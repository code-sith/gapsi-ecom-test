package com.gapsi.ecom.enums;

public enum Error {

    NOT_FOUND(404, "record not found"),
    CONFLICT(409, "a previous record already exists with the information provided");

    private int code;
    private String desc;

    Error(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }

    public int getCode(){
        return this.code;
    }
}
