/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import data.Currency;
import data.Money;
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
public class CashTest {
    
    public class MoneyExchangeDouble extends MoneyExchangeImplD {
        
    }
    public class StockExchangeDouble extends StockExchangeImplD {

    }
    /**
     * Test of evaluate method, of class Cash.
     */
    @Test
    public void evaluateCashAboutDifferentCurrencies() throws EvaluationException {
        Currency from = new Currency("euro");
        Currency to = new Currency("dollar");
        BigDecimal quantity = new BigDecimal(5.14);
        Money money = new Money(quantity, from);
        Cash cash = new Cash(money);
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        Money result = cash.evaluate(to, moneyEx, stockEx);
        Money expResult = new Money(new BigDecimal(6.43), to);
        assertEquals(expResult, result);
    }
    
    @Test
    public void evaluateCashAboutSameCurrencies () throws EvaluationException {
        Currency from = new Currency("euro");
        Currency to = new Currency("euro");
        BigDecimal quantity = new BigDecimal(5.14);
        Money money = new Money(quantity, from);
        Cash cash = new Cash(money);
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        Money result = cash.evaluate(to, moneyEx, stockEx);  
        Money expResult = new Money(new BigDecimal(5.14), to);
        assertEquals(expResult, result);
    }
    
    @Test (expected = EvaluationException.class)
    public void evaluateCashAboutDifferentCurrenciesAndMoneyExchangeNotExists () throws EvaluationException {
        Currency from = new Currency("peso");
        Currency to = new Currency("libra");
        BigDecimal quantity = new BigDecimal(5.14);
        Money money = new Money(quantity, from);
        Cash cash = new Cash(money);
        MoneyExchange moneyEx = new MoneyExchangeDouble();
        StockExchange stockEx = new StockExchangeDouble();
        Money result = cash.evaluate(to, moneyEx, stockEx);       
    }
}
