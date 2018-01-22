/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Objects;

/**
 *
 * @author Jordi Blanco
 */
public class Currency {
    private final String name;
    /**
     * Constructor
     * @param name (string) 
     */
    public Currency(String name){
        this.name = name;
    }
    /**
     * Function to compare two currencys and see if they are equal
     * @param object currency to compare
     * @return  Return true if are equals, false if are not equals
     */
    @Override
    public boolean equals(Object object) {
        return this.name == ((Currency) object).name;
    }
    /**
     * Function to do the hashcode about the currency
     * @return return a integer with the value
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }
    /**
     * Transform the object currency to String
     * @return The String about the variables
     */
    @Override
    public String toString() {
        return "Currency" + "name =" + name;
    }
}
