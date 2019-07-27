package com.fonowizja.eksperymenta.tdd.operations;

import tdd.calculators.Bank;
import tdd.currency.Money;

/**
 * @author krzysztof.kramarz
 */

public interface Expression
{
   Money reduce(Bank bank, String to);

   /**
    * Sums two Expressions
    * @param addend Expression to be added
    * @return Expression
    */
   Expression plus(Expression addend);

   Expression times(Integer multiplier);
}
