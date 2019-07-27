package com.fonowizja.eksperymenta.tdd_refactor.operations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tdd_refactor.calculators.Bank;
import tdd_refactor.currency.Money;

/**
 * @author krzysztof.kramarz
 */
@AllArgsConstructor
@Getter
@Setter
public class ExpressionImpl  implements Expression
{



   @Override
   public Money reduce(Bank bank, String to)
   {
      return null;
   }

   @Override
   public  Money plus(Money augend, Money addend )
   {
      return new Money(augend.getAmount() + addend.getAmount(), augend.getCurrency());
   }

   @Override
   public Money minus(Money augend, Money addend)
   {
      return null;
   }

}
