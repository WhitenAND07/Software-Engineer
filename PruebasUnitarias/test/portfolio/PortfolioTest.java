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
public class PortfolioTest {
    public class MoneyExchangeDouble extends MoneyExchangeImplD {
        
    }
    public class StockExchangeDouble extends StockExchangeImplD {

    }
    /**
     * Test of evaluate method, of class Portfolio.
     */
    @Test
    public void evaluatePortfolioAllInvestments() throws Exception {
        Currency cashCurrency = new Currency("euro");
        BigDecimal cashQuantity = new BigDecimal(55.99);
        Money cashMoney = new Money(cashQuantity, cashCurrency);
        Investment cash = new Cash(cashMoney);
        
        Ticket ticket = new Ticket("apple");
        Investment stock = new Stock(ticket, 5);
        
        Currency fBuyCurrency = new Currency("euro");
        BigDecimal fBuyQuantity = new BigDecimal(100);
        Money fBuyMoney = new Money(fBuyQuantity, fBuyCurrency);
        Ticket fBuyTicket = new Ticket("apple");
        Investment futureBuy = new FutureBuy(fBuyTicket, 10, fBuyMoney);
        
        Currency fSellCurrency = new Currency("euro");
        BigDecimal fSellQuantity = new BigDecimal(100);
        Money fSellMoney = new Money(fSellQuantity, fSellCurrency);
        Ticket fSellTicket = new Ticket("apple");
        Investment futureSell = new FutureSell(fSellTicket, 0, fSellMoney);
        
        Currency currencyToFinal = new Currency("dollar");
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        Portfolio portfolio = new Portfolio();
        
        portfolio.addInvestment(cash);
        portfolio.addInvestment(stock);
        portfolio.addInvestment(futureBuy);
        portfolio.addInvestment(futureSell);
        
        Money expResult = new Money(new BigDecimal(1312.20), currencyToFinal);;
        Money result = portfolio.evaluate(currencyToFinal, moneyEx, stockEx);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of evaluate method, of class Portfolio.
     */
    @Test (expected = EvaluationException.class)
    public void evaluatePortfolioAllInvestmentsANDTicketNotExistInStock() throws Exception {
        Currency cashCurrency = new Currency("euro");
        BigDecimal cashQuantity = new BigDecimal(55.99);
        Money cashMoney = new Money(cashQuantity, cashCurrency);
        Investment cash = new Cash(cashMoney);
        
        Ticket ticket = new Ticket("xiaomi");
        Investment stock = new Stock(ticket, 5);
        
        Currency fBuyCurrency = new Currency("euro");
        BigDecimal fBuyQuantity = new BigDecimal(100);
        Money fBuyMoney = new Money(fBuyQuantity, fBuyCurrency);
        Ticket fBuyTicket = new Ticket("apple");
        Investment futureBuy = new FutureBuy(fBuyTicket, 10, fBuyMoney);
        
        Currency fSellCurrency = new Currency("euro");
        BigDecimal fSellQuantity = new BigDecimal(100);
        Money fSellMoney = new Money(fSellQuantity, fSellCurrency);
        Ticket fSellTicket = new Ticket("apple");
        Investment futureSell = new FutureSell(fSellTicket, 0, fSellMoney);
        
        Currency currencyToFinal = new Currency("dollar");
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        Portfolio portfolio = new Portfolio();
        
        portfolio.addInvestment(cash);
        portfolio.addInvestment(stock);
        portfolio.addInvestment(futureBuy);
        portfolio.addInvestment(futureSell);
        
        Money result = portfolio.evaluate(currencyToFinal, moneyEx, stockEx);
    }
}
