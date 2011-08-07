/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javasampleapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoneyTest {

    public MoneyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMultiplication() {
        Money five = Money.doller(5);
        assertEquals(Money.doller(10), five.times(2));
        assertEquals(Money.doller(15), five.times(3));
    }

    @Test
    public void testEquality() {
      assertTrue(Money.doller(5).equals(Money.doller(5)));
      assertFalse(Money.doller(5).equals(Money.doller(6)));
      assertFalse(Money.franc(5).equals(Money.doller(5)));
    }

    @Test
    public void testCurrency(){
        assertEquals("USD", Money.doller(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    public void testSimpleAddition() {
        Money five = Money.doller(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.doller(10), reduced);
    }
}
