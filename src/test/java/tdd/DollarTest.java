package tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import tdd.currency.Money;

/**
 * @author krzysztof.kramarz
 */
public class DollarTest
{

   @Test
   public void testMultiplicationNegative()
   {
      // Dollar five =  new Dollar(5);
      Money five = Money.dollar(5);

      assertThat(five.times(2)).isNotEqualTo(Money.dollar(5));
   }

   @Test
   public void testMultiplicationPositive()
   {
      Money five = Money.dollar(5);

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
   public void testSame()
   {
      // Dollar five1 = Money.dollar(5);
      // Dollar five2 = Money.dollar(5);
      Money five1 = Money.dollar(5);
      Money five2 = Money.dollar(5);
      assertThat(five1).isSameAs(five1);
      assertThat(five1).isNotSameAs(five2);
   }


}