package com.umutavci;

public class FalscheIBANException extends Exception{
    public FalscheIBANException(String message){
        super(message);
    }
    public FalscheIBANException(){}
}
