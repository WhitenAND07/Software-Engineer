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
public class Ticket {
    private final String name;
    /**
     * Constructor
     * @param name (string) 
     */
    public Ticket(String name){
        this.name = name;
    }
    /**
     * Function to compare two tickets and see if they are equal
     * @param object ticket to compare
     * @return  Return true if are equals, false if are not equals
     */
    @Override
    public boolean equals(Object object) {
        return this.name == ((Ticket) object).name;
    }
    /**
     * Function to do the hashcode about the ticket
     * @return return a integer with the value
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }
    /**
     * Transform the object ticket to String
     * @return The String about the variables
     */
    @Override
    public String toString() {
        return "Ticket" + "name =" + name;
    }

   
    
}
