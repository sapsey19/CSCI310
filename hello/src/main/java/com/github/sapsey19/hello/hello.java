package com.github.sapsey19.hello;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssapsey
 */
public class HelloWorld {
    public static void main(String [] args) throws Exception
    {
        HelloWorld helloWorld = new HelloWorld();
       
        helloWorld.sayMessage();
    }

    private void sayMessage() { 
        System.out.println(getMessage());
    }
    
    private String message = "";
    
    public void setMessage(String _message) {
        if(_message != null)
            message = _message;
        else 
            throw new UnsupportedOperationException("message cannot be null");
    }
    
    public String getMessage() {
        return message;
    }
}

