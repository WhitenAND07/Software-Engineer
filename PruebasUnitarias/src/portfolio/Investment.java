/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import data.Currency;
import data.Money;
import services.MoneyExchange;
import services.StockExchange;

/**
 *
 * @author Jordi Blanco
 */
public interface Investment {
    Money evaluate(Currency currencyTo, MoneyExchange moneyEx, StockExchange stockEx) throws EvaluationException;
}
