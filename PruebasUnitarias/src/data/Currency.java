/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Objects;

/**
 *
 * @author jbl8
 */
public class Currency {
    private final String name;

    public Currency(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        return this.name == ((Currency) object).name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public String toString() {
        return "Currency" + "name =" + name;
    }
}
