package com.fonowizja.eksperymenta.tdd_refactor.operations;

import tdd_refactor.calculators.Bank;
import tdd_refactor.currency.Money;

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
   Money plus(Money augend, Money addend );
   Money minus(Money augend, Money addend );

}
