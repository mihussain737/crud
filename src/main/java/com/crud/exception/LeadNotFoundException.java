package com.crud.exception;

public class LeadNotFoundException extends RuntimeException{
    public LeadNotFoundException(String msg){
        super(msg);
    }
}
