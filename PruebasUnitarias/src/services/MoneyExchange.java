/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.Currency;
import java.math.BigDecimal;

/**
 *
 * @author Jordi Blanco
 */
public interface MoneyExchange {
    BigDecimal exchangeRatio(Currency from, Currency to) 
            throws RatioDoesNotExistException;
}
