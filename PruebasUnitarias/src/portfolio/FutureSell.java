/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import data.Currency;
import data.Money;
import data.Ticket;
import services.MoneyExchange;
import services.StockExchange;

/**
 *
 * @author Jordi Blanco
 */
public class FutureSell implements Investment {
    Ticket ticket;
    int numShares; 
    Money pricePerShare;
    /**
     * Constructor
     * @param ticket (Ticket)
     * @param numShares (Integer)
     * @param pricePerShare (Money)
     */
    public FutureSell (Ticket ticket, int numShares, Money pricePerShare){
        this.ticket = ticket;
        this.numShares = numShares;
        this.pricePerShare = pricePerShare;
    }
    /**
     * Function to evaluate a future sell in a ticket of a specific currency 
     * @param currencyTo The specific currency
     * @param moneyEx External service to evaluate the money exchange 
     * @param stockEx External service to evaluate the Stock exchange
     * @return Return a new Money about the result
     * @throws EvaluationException When not exists the money or the ticket in the external service
     */
    @Override
    public Money evaluate(Currency currencyTo, MoneyExchange moneyEx, StockExchange stockEx) throws EvaluationException {
        FutureBuy operation = new FutureBuy(this.ticket,this.numShares,this.pricePerShare);
        return operation.evaluate(currencyTo, moneyEx, stockEx);
    }
}
