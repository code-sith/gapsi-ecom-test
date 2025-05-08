package com.gapsi.ecom.exception;

import com.gapsi.ecom.enums.Error;

public class DuplicateRecordException extends ApplicationException{

    public DuplicateRecordException() {
        super(Error.CONFLICT);
    }
}
