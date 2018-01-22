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
public class FutureBuy implements Investment {
    Ticket ticket;
    int numShares; 
    Money pricePerShare;
    /**
     * Constructor
     * @param ticket (Ticket)
     * @param numShares (Integer)
     * @param pricePerShare (Money)
     */
    public FutureBuy (Ticket ticket, int numShares, Money pricePerShare){
        this.ticket = ticket;
        this.numShares = numShares;
        this.pricePerShare = pricePerShare;
    }
    /**
     * Function to evaluate a future buy in a ticket of a specific currency 
     * @param currencyTo The specific currency
     * @param moneyEx External service to evaluate the money exchange 
     * @param stockEx External service to evaluate the Stock exchange
     * @return Return a new Money about the result
     * @throws EvaluationException When not exists the money or the ticket in the external service
     */
    @Override
    public Money evaluate(Currency currencyTo, MoneyExchange moneyEx, StockExchange stockEx) throws EvaluationException {
        try {
            Money resultBuy = stockEx.value(this.ticket);
            
            if (!resultBuy.getCurrency().equals(currencyTo)) {
                BigDecimal actualRatio = moneyEx.exchangeRatio(resultBuy.getCurrency(), currencyTo);
                resultBuy = resultBuy.change(actualRatio, currencyTo);
            }
            if (!pricePerShare.getCurrency().equals(currencyTo)) {
                BigDecimal futureRatio = moneyEx.exchangeRatio(pricePerShare.getCurrency(), currencyTo);
                Money pricePerShareF =pricePerShare.change(futureRatio, currencyTo);
                resultBuy = pricePerShareF.subtract(resultBuy).multiply(numShares);
            }
            else{
                resultBuy = pricePerShare.subtract(resultBuy).multiply(numShares);
            }
            
            return resultBuy;
        }
        catch (TicketDoesNotExistException | RatioDoesNotExistException rd) {
            throw new EvaluationException(rd.getMessage());
        }
    }
    
}
