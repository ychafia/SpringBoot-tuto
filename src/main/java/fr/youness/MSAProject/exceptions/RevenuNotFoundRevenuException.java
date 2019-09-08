package fr.youness.MSAProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RevenuNotFoundRevenuException extends RuntimeException{
    public RevenuNotFoundRevenuException(String s){
        super(s);
    }
}
