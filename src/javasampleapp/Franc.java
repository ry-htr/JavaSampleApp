/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javasampleapp;

/**
 *
 * @author hattoriryou
 */
public class Franc extends Money{
    
    Franc(int amount){
        this.amount = amount;
    }
    
    Franc times(int multiplier){
        return new Franc(amount * multiplier);
    }
}
