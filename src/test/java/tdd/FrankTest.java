package tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import tdd.currency.Money;

/**
 * @author krzysztof.kramarz
 */
public class FrankTest
{

   @Test
   public void testMultiplicationNegative()
   {
      // Frank five = new Frank(5);
      // assertThat(five.getAmount()).isEqualTo(5);

      assertThat(Money.frank(5).times(3)).isNotEqualTo(Money.frank(17));
   }
   @Test
   public void testMultiplicationPositive()
   {
      assertThat(Money.frank(5).times(2)).isEqualTo(Money.frank(10));
      assertThat(Money.frank(5).times(3)).isEqualTo(Money.frank(15));
   }

   @Test
   public void testEquality()
   {
      assertThat(Money.frank(5)).isEqualTo(Money.frank(5));
      assertThat(Money.frank(5)).isNotEqualTo(Money.frank(6));
   }

   @Test
   public void testSame()
   {
      // Dollar five1 = Money.dollar(5);
      // Dollar five2 = Money.dollar(5);
      Money five1 = Money.frank(5);
      Money five2 = Money.frank(5);
      assertThat(five1).isSameAs(five1);
      assertThat(five1).isNotSameAs(five2);
   }

}