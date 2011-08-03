/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javasampleapp;

public class Franc extends Money{

    Franc(int amount, String currency){
        super(amount, currency);
    }

    Money times(int multiplier){
        return Money.franc(amount * multiplier);
    }
}
