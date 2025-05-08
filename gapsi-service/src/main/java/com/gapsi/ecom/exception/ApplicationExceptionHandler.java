package com.gapsi.ecom.exception;

import com.gapsi.ecom.dto.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({DuplicateRecordException.class})
    public ResponseEntity<DefaultResponse> duplicatedException(DuplicateRecordException duplicateRecordException){
        DefaultResponse response = new DefaultResponse();
        response.setStatus(duplicateRecordException.getErrorCode());
        response.setError(duplicateRecordException.getErrorDesc());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({RecordNotFoundException.class})
    public ResponseEntity<DefaultResponse> recordNotFoundException(RecordNotFoundException recordNotFoundException){
        DefaultResponse response = new DefaultResponse();
        response.setStatus(recordNotFoundException.getErrorCode());
        response.setError(recordNotFoundException.getErrorDesc());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
