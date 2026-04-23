package com.example.PlayerFinder.ErrorHandling.handler;

public class AlreadyAppliedException extends RuntimeException{

    public AlreadyAppliedException(String message){
        super(message);
    }
}
