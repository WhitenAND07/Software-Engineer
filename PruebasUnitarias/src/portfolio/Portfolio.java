/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import data.Currency;
import data.Money;
import java.math.BigDecimal;
import java.util.ArrayList;
import services.MoneyExchange;
import services.StockExchange;

/**
 *
 * @author Jordi Blanco
 */
public class Portfolio implements Investment {
    private ArrayList<Investment> investmentPortfolio = new ArrayList<Investment>();
    
    public Portfolio(){
    }
    public void addInvestment(Investment investment){
        this.investmentPortfolio.add(investment);
    }

    @Override
    public Money evaluate(Currency currencyTo, MoneyExchange moneyEx, StockExchange stockEx) throws EvaluationException {
        Investment invesment;
        Money tmp, resultTmp;
        Money resultPortfolio = new Money(new BigDecimal(0.00), currencyTo);
        
        try {
            for(int i=0; i<investmentPortfolio.size(); i++) {     
                invesment = investmentPortfolio.get(i);
                resultTmp = resultPortfolio;
                tmp = invesment.evaluate(currencyTo, moneyEx, stockEx);
                resultPortfolio = resultTmp.add(tmp);
            }
            return resultPortfolio;           
        }
        catch (EvaluationException ex) {
            throw new EvaluationException(ex.getMessage());
        }
    }
}
