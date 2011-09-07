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
    @Test
    public void testSimpleAddition() {
        Money five = Money.doller(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.doller(10), reduced);
    }
    @Test
    public void testPlusReturnSum(){
        Money five = Money.doller(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }
    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.doller(3), Money.doller(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.doller(7), result);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.doller(1), "USD");
        assertEquals(Money.doller(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.doller(1), result);
    }

    @Test
    public void testArrayEquals(){
        assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
    }

    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddtion(){
        Expression fiveBucks = Money.doller(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");

        assertEquals(Money.doller(10), result);
    }

    @Test
    public void testSumPlusMoney(){
        Expression fiveBucks = Money.doller(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();

        bank.addRate("CHF", "USD", 2);

        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);

        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.doller(15), result);
    }

    @Test
    public void testSumTimes(){
        Expression fiveBucks = Money.doller(5);
        Expression tenFrancs = Money.franc(10);

        Bank bank = new Bank();

        bank.addRate("CHF", "USD", 2);

        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);

        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.doller(20), result);
    }
}
