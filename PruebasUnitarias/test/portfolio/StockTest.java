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
public class StockTest {
    public class MoneyExchangeDouble extends MoneyExchangeImplD {
        
    }
    public class StockExchangeDouble extends StockExchangeImplD {

    }
    /**
     * Test of evaluate method, of class Stock.
     */
    @Test
    public void evaluateStockCorrectWithTicketCorrectAndDifferentCurrency() throws EvaluationException {
        Currency currencyTo = new Currency("dollar");
        Ticket ticket = new Ticket("apple");
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        Stock stock = new Stock(ticket, 14);
        Money expResult = new Money(new BigDecimal(21.88), currencyTo);
        Money result = stock.evaluate(currencyTo, moneyEx, stockEx);
        assertEquals(expResult, result);
    }
    @Test
    public void evaluateStockCorrectWithTicketCorrectAndSameCurrency() throws EvaluationException {
        Currency currencyTo = new Currency("euro");
        Ticket ticket = new Ticket("apple");
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        Stock stock = new Stock(ticket, 14);
        Money expResult = new Money(new BigDecimal(17.50), currencyTo);
        Money result = stock.evaluate(currencyTo, moneyEx, stockEx);
        assertEquals(expResult, result);
    }
    @Test (expected = EvaluationException.class)
    public void evaluateStockIncorrectWithTicketNotExist() throws EvaluationException {
        Currency currencyTo = new Currency("peso");
        Ticket ticket = new Ticket("apple");
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        Stock stock = new Stock(ticket, 14);
        Money result = stock.evaluate(currencyTo, moneyEx, stockEx);
    }
    
}
