/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import data.Currency;
import data.Money;
import data.Ticket;
import java.math.BigDecimal;
import services.MoneyExchange;
import services.RatioDoesNotExistException;
import services.StockExchange;
import services.TicketDoesNotExistException;

/**
 *
 * @author Jordi Blanco
 */
public class FutureSell implements Investment {
    Ticket ticket;
    int numShares; 
    Money pricePerShare;
    
    public FutureSell (Ticket ticket, int numShares, Money pricePerShare){
        this.ticket = ticket;
        this.numShares = numShares;
        this.pricePerShare = pricePerShare;
    }

    @Override
    public Money evaluate(Currency currencyTo, MoneyExchange moneyEx, StockExchange stockEx) throws EvaluationException {
        FutureBuy operation = new FutureBuy(this.ticket,this.numShares,this.pricePerShare);
        return operation.evaluate(currencyTo, moneyEx, stockEx);
    }
}
