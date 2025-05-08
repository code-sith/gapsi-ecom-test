package com.gapsi.ecom.exception;

import com.gapsi.ecom.enums.Error;
import lombok.Getter;

@Getter
public class ApplicationException extends Exception{

    private int errorCode;
    private String errorDesc;

    public ApplicationException(final int errorCode, final String errorDesc){
        super(errorDesc);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public ApplicationException(Error error){
        super(error.getDesc());
        this.errorDesc = error.getDesc();
        this.errorCode = error.getCode();
    }
}
