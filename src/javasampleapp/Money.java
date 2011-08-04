/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javasampleapp;

class Money {

    protected int amount;
    protected String currency;

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && currency() . equals(money.currency());
    }

    String currency(){
        return currency;
    }

    static Money doller(int amount){
        return new Doller(amount, "USD");
    }

    static Money franc(int amount){
        return new Franc(amount, "CHF");
    }

    public String toString(){
        return amount + " " + currency;
    }
    
    Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }
}
