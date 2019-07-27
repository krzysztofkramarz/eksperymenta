package com.fonowizja.eksperymenta.tdd_refactor.currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author krzysztof.kramarz
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Money
{
   @SuppressWarnings("FieldNamingConvention")
   public static final String USD = "USD";
   public static final String FRANK = "FRANK";

   private final Integer amount;
   private final String currency;

   // /**
   //  * @param multiplier
   //  *       multiplies ammount of given money
   //  * @return new Money with multiplicated amount
   //  */
   //
   // public Expression times(int multiplier)
   // {
   //    return new Money(amount * multiplier, currency);
   // }

   // /**
   //  * @param money Money to add
   //  * @return Money USD
   //  */
   // public Money sum(Money money)
   // {
   //    return new Money(getAmount() + money.getAmount(), USD);
   // }
   //
   //
   // @Override
   // public Expression plus(Expression addend)
   // {
   //    return new Sum(this, addend);
   // }
   //
   // @Override
   // public Expression times(Integer multiplier)
   // {
   //    return new Money(amount * multiplier, currency);
   // }
   //
   // @Override
   // public Money reduce(Bank bank, String to)
   // {
   //
   //    return new Money(amount / bank.rate(currency, to), to);
   // }

   /**
    * @param amount
    *       amount of currency
    * @return new Money with USD
    */
   public static Money dollar(Integer amount)
   {
      return new Money(amount, USD);
   }

   /**
    * @param amount
    *       amount of currency
    * @return new Money with FRANK
    */
   public static Money frank(Integer amount)
   {
      return new Money(amount, FRANK);
   }

   @Override
   public boolean equals(Object obj)
   {
      Money money = (Money) obj;
      return amount.equals(money.amount) && getCurrency().equals(money.getCurrency());
   }

}
