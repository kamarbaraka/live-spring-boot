package com.develhope.livespringboot.app.item.exception;

/**
 * an exception indicating resource not found.
 * @author kamar baraka.*/

public class NotFoundException extends Throwable {

    public NotFoundException(String message){

        /*pass the message to the parent*/
        super(message);
    }
}
