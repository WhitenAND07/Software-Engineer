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
public class TicketDoesNotExistException extends Exception {
    String message;
    public TicketDoesNotExistException(String message){
        this.message = message;
    }
}
