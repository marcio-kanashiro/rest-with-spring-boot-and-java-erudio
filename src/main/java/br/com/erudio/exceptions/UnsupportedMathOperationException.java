package br.com.erudio.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnsupportedMathOperationException(String exception) {
        super(exception);
    }

}
