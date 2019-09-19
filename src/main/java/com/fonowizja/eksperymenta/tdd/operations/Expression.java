package com.fonowizja.eksperymenta.tdd.operations;

import com.fonowizja.eksperymenta.tdd.calculators.Bank;
import com.fonowizja.eksperymenta.tdd.currency.Money;

/**
 * @author krzysztof.kramarz
 */

public interface Expression {
    Money reduce(Bank bank, String to);

    /**
     * Sums two Expressions
     *
     * @param addend Expression to be added
     * @return Expression
     */
    Expression plus(Expression addend);

    Expression times(Integer multiplier);
}
