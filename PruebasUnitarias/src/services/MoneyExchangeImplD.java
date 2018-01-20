/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.Currency;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Jordi Blanco
 */
public class MoneyExchangeImplD implements MoneyExchange {
    @Override
    public BigDecimal exchangeRatio (Currency from, Currency to) throws RatioDoesNotExistException{
        if(!from.equals(to)){
            if(from.equals(new Currency("euro")) && to.equals(new Currency("dollar"))){
                return new BigDecimal(1.25).setScale(2, RoundingMode.HALF_UP);
            }
        }
        throw new RatioDoesNotExistException("Error: The currencys are equals");
        
    }
}
