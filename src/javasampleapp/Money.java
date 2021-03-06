/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javasampleapp;

class Money implements Expression{

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
        return new Money(amount, "USD");
    }

    static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    public String toString(){
        return amount + " " + currency;
    }

    public Expression times(int multiplier){
        return new Money(amount * multiplier, currency);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to){
        int rate = bank.rate(currency, to);
        return new Money( amount / rate, to);
    }
}
