/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.Currency;
import data.Money;
import data.Ticket;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Jordi Blanco
 */
public class StockExchangeImplD implements StockExchange {
    
    @Override
    public Money value(Ticket ticket) throws TicketDoesNotExistException {
        Ticket Apple = new Ticket("apple");
        if(!ticket.equals(Apple)){
            throw new TicketDoesNotExistException("Error: The Ticket does not exist ");
        }
        else{
            return new Money(new BigDecimal(2.56).setScale(2, RoundingMode.HALF_UP), new Currency("euro"));
        }
    }
    
}
