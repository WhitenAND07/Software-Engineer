/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 * @author jbl8
 */
public class Money {
    private BigDecimal quantity;
    private Currency currency;
    
    public Money(BigDecimal quantity, Currency currency){
        this.quantity = quantity.setScale(2, RoundingMode.HALF_UP);
        this.currency = currency;
    }

    public Currency getCurrency() {
        return this.currency;
    }
    
    public Money add (Money other) throws IllegalArgumentException{
        if(this.currency.equals(other.currency)){
            return new Money(this.quantity.add(other.quantity).setScale(2, RoundingMode.HALF_UP),this.currency);
        }
        else{
            throw new IllegalArgumentException("Error: The currencys not are equals.");
        }
    }
    public Money subtract(Money	other)throws IllegalArgumentException{
        if(this.currency.equals(other.currency)){
            return new Money(this.quantity.subtract(other.quantity).setScale(2, RoundingMode.HALF_UP),this.currency);
        }
        else{
            throw new IllegalArgumentException("Error: The currencys not are equals.");
        }
    }
    public Money multiply(int multiplier){
        BigDecimal mult = new BigDecimal (multiplier).setScale(2, RoundingMode.HALF_UP);
        Money money = new Money(this.quantity.multiply(mult),this.currency);
        return money;
    }
    public Money change(BigDecimal ratio, Currency to) throws IllegalArgumentException{
        if(!this.currency.equals(to)){
            return new Money(this.quantity.multiply(ratio).setScale(2, RoundingMode.HALF_UP), to);
        }
        else{
            throw new IllegalArgumentException("Error: The currencys are equals.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Money other = (Money) obj;
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.currency, other.currency)) {
            return false;
        }
        return true;
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