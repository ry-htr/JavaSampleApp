/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javasampleapp;

/**
 *
 * @author hattoriryou
 */
public class Doller extends Money{
    
    Doller(int amount){
        this.amount = amount;
    }
    
    Doller times(int multiplier){
        return new Doller(amount * multiplier);
    }
    
}
