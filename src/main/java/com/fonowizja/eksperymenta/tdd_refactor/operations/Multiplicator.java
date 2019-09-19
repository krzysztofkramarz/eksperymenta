package com.fonowizja.eksperymenta.tdd_refactor.operations;

import com.fonowizja.eksperymenta.tdd_refactor.currency.Money;

/**
 * @author krzysztof.kramarz
 */
public class Multiplicator {

    public Money times(Money money, Integer multiplier) //TODO zwraca zawsze USD
    {
        return new Money(money.getAmount() * multiplier, Money.USD);
    }
}
