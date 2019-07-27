package tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import tdd.currency.Money;
import tdd.operations.Expression;
import tdd.operations.Sum;

/**
 * @author krzysztof.kramarz
 */
public class MoneyTest
{

   @Test
   public void testMultiplicationNegative()
   {
      Money five = Money.dollar(5);
      assertThat(five.times(2)).isNotEqualTo(Money.dollar(5));
   }

   @Test
   public void testMultiplicationPositive()
   {
      Money five = Money.dollar(5);

      assertThat(five.getAmount()).isEqualTo(5);
      assertThat(five.times(2)).isEqualTo(Money.dollar(10));
      assertThat(five.times(3)).isEqualTo(Money.dollar(15));
   }

   @Test
   public void testEquality()
   {
      assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
      assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6));
   }

   @Test
   public void testPlusReturnsSum()
   {
      Money five = Money.dollar(5);
      Expression result = five.plus(five);
      Sum sum = (Sum) result;
      assertThat(sum.getAugend()).isEqualTo(five);
      assertThat(sum.getAddend()).isEqualTo(five);
   }

   @Test
   public void testSumReturnsMoney(){

      Expression plus = Money.dollar(1).plus(Money.dollar(1));
      assertThat(plus).isNotInstanceOf(Money.class);
   }

}