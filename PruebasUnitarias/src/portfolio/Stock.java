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
public class Stock implements Investment {
    Ticket ticket;
    int numShares;
    public Stock(Ticket ticket, int numShares){
        this.ticket = ticket;
        this.numShares=numShares;
    }
    @Override
    public Money evaluate(Currency currencyTo, MoneyExchange moneyEx, StockExchange stockEx) throws EvaluationException {    
        try {
            Money stock = stockEx.value(this.ticket);
            if (stock.getCurrency().equals(currencyTo)) {
                return stock.multiply(numShares);
            }
            else {
                BigDecimal ratio = moneyEx.exchangeRatio(stock.getCurrency(), currencyTo);
                return stock.multiply(numShares).change(ratio, currencyTo);
            }            
        }
        catch (TicketDoesNotExistException | RatioDoesNotExistException rd) {
            throw new EvaluationException(rd.getMessage());
        }
    }
}
