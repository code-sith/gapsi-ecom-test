package com.gapsi.ecom.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Setter
public class DefaultResponse {

    private int status;
    private String error;
    private long timestamp;

    public DefaultResponse(){
        this.timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }
}
