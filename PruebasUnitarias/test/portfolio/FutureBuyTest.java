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
import org.junit.Test;
import static org.junit.Assert.*;
import services.MoneyExchange;
import services.MoneyExchangeImplD;
import services.StockExchange;
import services.StockExchangeImplD;

/**
 *
 * @author Jordi Blanco
 */
public class FutureBuyTest {
    public class MoneyExchangeDouble extends MoneyExchangeImplD {
        
    }
    public class StockExchangeDouble extends StockExchangeImplD {

    }
    /**
     * Test of evaluate method with differents currencys in ticket and currency 
     * final and same currencys in pricePerShare and final currency, of class FutureBuy.
     */
    @Test
    public void evaluateFutureBuyCorrectWithDifferentCurrencyInTicket() throws EvaluationException {
        Currency currencyTo = new Currency("dollar");
        Ticket ticket = new Ticket("apple");
        BigDecimal quantity = new BigDecimal(2.45);
        Money pricePerShare = new Money(quantity, currencyTo);
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        FutureBuy futureBuy = new FutureBuy(ticket, 10, pricePerShare);
        Money expResult = new Money(new BigDecimal(8.90), currencyTo);
        Money result = futureBuy.evaluate(currencyTo, moneyEx, stockEx);
        assertEquals(expResult, result);
    }
    /**
     * Test of evaluate method with differents currencys in pricePerShare and currency 
     * final and same currencys in ticket and final currency, of class FutureBuy.
     */
    @Test
    public void evaluateFutureBuyCorrectWithDifferentCurrencyInPricePerShare() throws EvaluationException {
        Currency currencyTo = new Currency("euro");
        Ticket ticket = new Ticket("apple");
        BigDecimal quantity = new BigDecimal(2.45);
        Money pricePerShare = new Money(quantity, new Currency("dollar"));
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        FutureBuy futureBuy = new FutureBuy(ticket, 10, pricePerShare);
        Money expResult = new Money(new BigDecimal(18.10), currencyTo);
        Money result = futureBuy.evaluate(currencyTo, moneyEx, stockEx);
        assertEquals(expResult, result);
    }
    /**
     * Test of evaluate method with Ticket not exist, of class FutureBuy.
     */
    @Test (expected = EvaluationException.class)
    public void evaluateFutureBuyIncorrectWithTicketNotExist() throws EvaluationException {
        Currency currencyTo = new Currency("euro");
        Ticket ticket = new Ticket("xiaomi");
        BigDecimal quantity = new BigDecimal(2.45);
        Money pricePerShare = new Money(quantity, currencyTo);
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        FutureBuy futureBuy = new FutureBuy(ticket, 10, pricePerShare);
        Money result = futureBuy.evaluate(currencyTo, moneyEx, stockEx);
    }
    
}
