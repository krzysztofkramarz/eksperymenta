package com.fonowizja.eksperymenta.tdd.operations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tdd.calculators.Bank;
import tdd.currency.Money;

/**
 * @author krzysztof.kramarz
 */
@Getter
@Setter
@AllArgsConstructor
public class Sum implements Expression
{
   private Expression augend;
   private Expression addend;

   public Money reduce(Bank bank, String to){
      // Integer rate = bank.rate(augend.getCurrency(), addend.getCurrency());
      Integer amount = augend.reduce(bank, to).getAmount() + addend.reduce(bank, to).getAmount();
      return new Money(amount, to);
   }

   @Override
   public Expression plus(Expression addend)
   {
      return new Sum(this, addend);
   }

   public Expression times(Integer multiplier)
   {
      return new Sum(augend.times(multiplier), addend.times(multiplier));
   }
}
