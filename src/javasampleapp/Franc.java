/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javasampleapp;

/**
 *
 * @author hattoriryou
 */
public class Franc {
    private int amount;
    
    Franc(int amount){
        this.amount = amount;
    }
    
    Franc times(int multiplier){
        return new Franc(amount * multiplier);
    }
    
    public boolean equals(Object object){
        Franc franc = (Franc) object;
        return amount == franc.amount;
    }
}
