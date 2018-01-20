/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordi Blanco
 */
public class MoneyTest {
    
    /**
     * Test of getCurrency method, of class Money.
     */
    @Test
    public void testGetCurrency() {
        Money instance = new Money (new BigDecimal(1000), new Currency("euro"));
        Currency expResult = new Currency ("euro");
        Currency result = instance.getCurrency();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class Money.
     */
    @Test
    public void testAdd() {
        Money other =  new Money (new BigDecimal(1000), new Currency("euro"));
        Money instance =  new Money (new BigDecimal(1000), new Currency("euro"));
        Money expResult =  new Money (new BigDecimal(2000), new Currency("euro"));
        Money result = instance.add(other);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method and expect IllegalArgumentException, of class Money.
     */
    @Test(expected =IllegalArgumentException.class)
    public void testAddError(){
        Money other =  new Money (new BigDecimal(1000), new Currency("euro"));
        Money instance =  new Money (new BigDecimal(1000), new Currency("peso"));
        Money result = instance.add(other);
    }

    /**
     * Test of subtract method, of class Money.
     */
    @Test
    public void testSubtract() {
        Money other =  new Money (new BigDecimal(1000), new Currency("euro"));
        Money instance =  new Money (new BigDecimal(2000), new Currency("euro"));
        Money expResult =  new Money (new BigDecimal(1000), new Currency("euro"));
        Money result = instance.subtract(other);
        assertEquals(expResult, result);
    }
/**
     * Test of subtract method and expect IllegalArgumentException, of class Money.
     */
    @Test(expected =IllegalArgumentException.class)
    public void testSubtractError() {
        Money other =  new Money (new BigDecimal(1000), new Currency("euro"));
        Money instance =  new Money (new BigDecimal(1000), new Currency("dollar"));
        Money result = instance.subtract(other);
    }
    /**
     * Test of multiply method, of class Money.
     */
    @Test
    public void testMultiply() {
        int multiplier = 2;
        Money instance =  new Money (new BigDecimal(1000), new Currency("euro"));
        Money expResult = new Money (new BigDecimal(2000), new Currency("euro"));;
        Money result = instance.multiply(multiplier);
        assertEquals(expResult, result);
    }

    /**
     * Test of change method, of class Money.
     */
    @Test
    public void testChange() {
        BigDecimal ratio = new BigDecimal(25);
        Currency to = new Currency("euro");
        Money instance = new Money (new BigDecimal(1000), new Currency("dollar"));
        Money expResult = new Money (new BigDecimal(25000), new Currency("euro"));
        Money result = instance.change(ratio, to);
        assertEquals(expResult, result);
    }
        /**
     * Test of change method and expect IllegalArgumentException, of class Money.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testChangeError() {
        BigDecimal ratio = new BigDecimal(25);
        Currency to = new Currency("euro");
        Money instance = new Money (new BigDecimal(1000), new Currency("euro"));
        Money result = instance.change(ratio, to);
    }
    /**
     * Test of equals method, of class Money.
     */
    @Test
    public void testEquals() {
        Object other =  new Money (new BigDecimal(1000), new Currency("euro"));
        Money instance = new Money(new BigDecimal(1000), new Currency("euro"));;
        boolean expResult = true;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method and are not equals, of class Money.
     */
    @Test
    public void testEqualsNotEquals() {
        Object other =  new Money (new BigDecimal(1000), new Currency("euro"));
        Money instance = new Money(new BigDecimal(1000), new Currency("dollar"));
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
    }  
}
