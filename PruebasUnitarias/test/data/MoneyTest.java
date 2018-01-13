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
        System.out.println("*****************TESTgetCurrency*****************");
        Money instance = new Money (new BigDecimal(1000), new Currency("test"));
        Currency expResult = new Currency ("test");
        Currency result = instance.getCurrency();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class Money.
     */
    @Test
    public void testAdd() {
        System.out.println("*****************TESTadd*****************");
        Money other =  new Money (new BigDecimal(1000), new Currency("test"));
        Money instance =  new Money (new BigDecimal(1000), new Currency("test"));
        Money expResult =  new Money (new BigDecimal(2000), new Currency("test"));
        Money result = instance.add(other);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method and expect IllegalArgumentException, of class Money.
     */
    @Test(expected =IllegalArgumentException.class)
    public void testAddError(){
        System.out.println("*****************TESTaddError*****************");
        Money other =  new Money (new BigDecimal(1000), new Currency("test"));
        Money instance =  new Money (new BigDecimal(1000), new Currency("test2"));
        Money result = instance.add(other);
    }

    /**
     * Test of subtract method, of class Money.
     */
    @Test
    public void testSubtract() {
        System.out.println("*****************TESTsubtract*****************");
        Money other =  new Money (new BigDecimal(1000), new Currency("test"));
        Money instance =  new Money (new BigDecimal(2000), new Currency("test"));
        Money expResult =  new Money (new BigDecimal(1000), new Currency("test"));
        Money result = instance.subtract(other);
        assertEquals(expResult, result);
    }
/**
     * Test of subtract method and expect IllegalArgumentException, of class Money.
     */
    @Test(expected =IllegalArgumentException.class)
    public void testSubtractError() {
        System.out.println("*****************TESTsubtractError*****************");
        Money other =  new Money (new BigDecimal(1000), new Currency("test"));
        Money instance =  new Money (new BigDecimal(1000), new Currency("test2"));
        Money result = instance.subtract(other);
    }
    /**
     * Test of multiply method, of class Money.
     */
    @Test
    public void testMultiply() {
        System.out.println("*****************TESTmultiply*****************");
        int multiplier = 2;
        Money instance =  new Money (new BigDecimal(1000), new Currency("test"));
        Money expResult = new Money (new BigDecimal(2000), new Currency("test"));;
        Money result = instance.multiply(multiplier);
        assertEquals(expResult, result);
    }

    /**
     * Test of change method, of class Money.
     */
    @Test
    public void testChange() {
        System.out.println("*****************TESTchange*****************");
        BigDecimal ratio = new BigDecimal(25);
        Currency to = new Currency("test");
        Money instance = new Money (new BigDecimal(1000), new Currency("test2"));
        Money expResult = new Money (new BigDecimal(25000), new Currency("test2"));
        Money result = instance.change(ratio, to);
        assertEquals(expResult, result);
    }
        /**
     * Test of change method and expect IllegalArgumentException, of class Money.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testChangeError() {
        System.out.println("*****************TESTchangeError*****************");
        BigDecimal ratio = new BigDecimal(25);
        Currency to = new Currency("test");
        Money instance = new Money (new BigDecimal(1000), new Currency("test"));
        Money result = instance.change(ratio, to);
    }
    /**
     * Test of equals method, of class Money.
     */
    @Test
    public void testEquals() {
        System.out.println("*****************TESTequals*****************");
        Object other =  new Money (new BigDecimal(1000), new Currency("test"));
        Money instance = new Money(new BigDecimal(1000), new Currency("test"));;
        boolean expResult = true;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
    }
    /**
     * Test of equals method and are not equals, of class Money.
     */
    @Test
    public void testEqualsNotEquals() {
        System.out.println("*****************TESTEqualsNotEquals*****************");
        Object other =  new Money (new BigDecimal(1000), new Currency("test"));
        Money instance = new Money(new BigDecimal(1000), new Currency("test2"));
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
    }  
}
