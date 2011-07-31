/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javasampleapp;

/**
 *
 * @author hattoriryou
 */
public class Doller {
    
    private int amount;
    
    Doller(int amount){
        this.amount = amount;
    }
    
    Doller times(int multiplier){
        return new Doller(amount * multiplier);
    }
    
    public boolean equals(Object object) {
        Doller doller = (Doller) object;
        return amount == doller.amount;
    }
    
}
