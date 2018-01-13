/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author jbl8
 */
public class Money {
    private BigDecimal quantity;
    private Currency currency;
    
    public Money(BigDecimal quantity, Currency currency){
        this.quantity = quantity;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return this.currency;
    }
    
    public Money add (Money other) throws IllegalArgumentException{
        if(this.currency.equals(other.currency)){
            return new Money(this.quantity.add(quantity),this.currency);
        }
        else{
            throw new IllegalArgumentException("Error: The currencys not are equals.");
        }
    }
    public Money subtract(Money	other)throws IllegalArgumentException{
        if(this.currency.equals(other.currency)){
            return new Money(this.quantity.subtract(other.quantity),this.currency);
        }
        else{
            throw new IllegalArgumentException("Error: The currencys not are equals.");
        }
    }
    public Money multiply(int multiplier){
        BigDecimal mult = new BigDecimal (multiplier);
        Money money = new Money(this.quantity.multiply(mult),this.currency);
        return money;
    }
    public Money change(BigDecimal ratio, Currency to) throws IllegalArgumentException{
        if(this.currency.equals(to) == false){
            return new Money(this.quantity.multiply(ratio),this.currency);
        }
        else{
            throw new IllegalArgumentException("Error: The currencys are equals.");
        }
    }
    
    @Override
    public boolean equals(Object other){
        return this.currency.equals(((Money)other).currency) && this.quantity.equals(((Money) other).quantity);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.quantity);
        hash = 53 * hash + Objects.hashCode(this.currency);
        return hash;
    }

    @Override
    public String toString() {
        return "Money. " + "quantity =" + quantity + ", currency =" + currency;
    }  	 
}