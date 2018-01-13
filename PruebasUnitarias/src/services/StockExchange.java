/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.Money;
import data.Ticket;

/**
 *
 * @author Jordi Blanco
 */
public interface StockExchange {
    Money value(Ticket ticket) 
            throws TicketDoesNotExistException;
}
