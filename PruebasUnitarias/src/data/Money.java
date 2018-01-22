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
 * @author Jordi Blanco
 */
public class Money {
    private BigDecimal quantity;
    private Currency currency;
    /**
     * Constructor
     * @param quantity (BigDecimal)
     * @param currency (String)
     */
    public Money(BigDecimal quantity, Currency currency){
        this.quantity = quantity.setScale(2, RoundingMode.HALF_UP);
        this.currency = currency;
    }
    /**
     * Function to get the Currency of Money
     * @return return the currency
     */
    public Currency getCurrency() {
        return this.currency;
    }
    /**
     * Function to calculate the sum of two Moneys
     * @param other Money to add
     * @return Return a new Money about the result
     * @throws IllegalArgumentException When the currencys are not equals
     */
    public Money add (Money other) throws IllegalArgumentException{
        if(this.currency.equals(other.currency)){
            return new Money(this.quantity.add(other.quantity).setScale(2, RoundingMode.HALF_UP),this.currency);
        }
        else{
            throw new IllegalArgumentException("Error: The currencys not are equals.");
        }
    }
    /**
     * Function to calculate the substraction of two Moneys
     * @param other Money to substract
     * @return Return a new Money about the result
     * @throws IllegalArgumentException When the currencys are not equals
     */
    public Money subtract(Money	other)throws IllegalArgumentException{
        if(this.currency.equals(other.currency)){
            return new Money(this.quantity.subtract(other.quantity).setScale(2, RoundingMode.HALF_UP),this.currency);
        }
        else{
            throw new IllegalArgumentException("Error: The currencys not are equals.");
        }
    }
    /**
     * Function to calculate the multiply of a Money and a integer
     * @param multiplier integer to multiply
     * @return Return a new Money about the result
     */
    public Money multiply(int multiplier){
        BigDecimal mult = new BigDecimal (multiplier).setScale(2, RoundingMode.HALF_UP);
        Money money = new Money(this.quantity.multiply(mult),this.currency);
        return money;
    }
    /**
     * Function to calculate the change from one currency to another 
     * @param ratio currency exchange ratio 
     * @param to Currency final
     * @return Return a new Money about the result
     * @throws IllegalArgumentException  When the currencys are equals
     */
    public Money change(BigDecimal ratio, Currency to) throws IllegalArgumentException{
        if(!this.currency.equals(to)){
            return new Money(this.quantity.multiply(ratio).setScale(2, RoundingMode.HALF_UP), to);
        }
        else{
            throw new IllegalArgumentException("Error: The currencys are equals.");
        }
    }
    /**
     * Function to compare two money and see if they are equal
     * @param obj money to compare
     * @return  Return true if are equals, false if are not equals
     */
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
    /**
     * Function to do the hashcode about the Money
     * @return return a integer with the value
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.quantity);
        hash = 53 * hash + Objects.hashCode(this.currency);
        return hash;
    }
    /**
     * Transform the object Money to String
     * @return The String about the variables
     */
    @Override
    public String toString() {
        return "Money. " + "quantity =" + quantity + ", currency =" + currency;
    }  	 
}