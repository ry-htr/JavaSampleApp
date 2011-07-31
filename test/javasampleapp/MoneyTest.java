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

/**
 *
 * @author hattoriryou
 */
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
        Doller five = new Doller(5);
        assertEquals(new Doller(10), five.times(2));
        assertEquals(new Doller(15), five.times(3));
    }
    
    @Test
    public void testEquality() {
      assertTrue(new Doller(5).equals(new Doller(5)));
      assertFalse(new Doller(5).equals(new Doller(6)));
      assertTrue(new Franc(5).equals(new Franc(5)));
      assertFalse(new Franc(5).equals(new Franc(6)));
      assertFalse(new Franc(5).equals(new Doller(5)));
    }
    
    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }
}
