/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Jordi Blanco
 */
public class RatioDoesNotExistException extends Exception {
    String message;
    /**
     * Constructor
     * @param message (String) 
     */
    public RatioDoesNotExistException(String message){
        this.message = message;
    }
}
