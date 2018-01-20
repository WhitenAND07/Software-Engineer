/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import data.Currency;
import data.Money;
import java.math.BigDecimal;
import services.MoneyExchange;
import services.StockExchange;
import services.RatioDoesNotExistException;

/**
 *
 * @author Jordi Blanco
 */
public class Cash implements Investment {
    Money money;
    public Cash (Money money){
        this.money = money;
    }
    @Override
    public Money evaluate(Currency currencyTo, MoneyExchange moneyEx, StockExchange stockEx) throws EvaluationException {
        try{
            if(this.money.getCurrency().equals(currencyTo)){
               return this.money;
            }
            else{
               BigDecimal ratio = moneyEx.exchangeRatio(this.money.getCurrency(), currencyTo);
               return this.money.change(ratio, currencyTo);
            }
        }
        catch(RatioDoesNotExistException rd) {
            throw new EvaluationException(rd.getMessage());
        }
    }
    
}
