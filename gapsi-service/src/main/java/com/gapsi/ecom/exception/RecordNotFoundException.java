package com.gapsi.ecom.exception;

import static com.gapsi.ecom.enums.Error.NOT_FOUND;

public class RecordNotFoundException extends ApplicationException{


    public RecordNotFoundException() {
        super(NOT_FOUND);
    }
}
