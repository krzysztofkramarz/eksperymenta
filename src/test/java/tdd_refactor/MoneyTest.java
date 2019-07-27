package tdd_refactor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import tdd_refactor.currency.Money;
import tdd_refactor.operations.Multiplicator;

/**
 * @author krzysztof.kramarz
 */
public class MoneyTest
{

   @Test
   public void testDollarFrankEquality()
   {
      assertThat(Money.dollar(5)).isNotEqualTo(Money.frank(5));
   }

   @Test
   public void testCurrency()
   {
      assertThat(Money.dollar(1).getCurrency()).isEqualTo(Money.USD);
      assertThat(Money.dollar(1).getCurrency()).isNotEqualTo(Money.FRANK);
      assertThat(Money.frank(1).getCurrency()).isEqualTo(Money.FRANK);
      assertThat(Money.frank(1).getCurrency()).isNotEqualTo(Money.USD);
   }


   @Test
   public void testMultiplicationNegative()
   {
      Money five = Money.dollar(5);
      Multiplicator multiplication = new Multiplicator();

      Money ten = multiplication.times(five, 2);

      assertThat(ten).isNotEqualTo(Money.dollar(5));
      assertThat(ten).isNotNull();
   }

   @Test
   public void testMultiplicationPositive()
   {
      Money five = Money.dollar(5);
      Multiplicator multiplication = new Multiplicator();

      Money ten = multiplication.times(five, 2);
      Money fifteen = multiplication.times(five, 3);

      assertThat(ten).isEqualTo(Money.dollar(10));
      assertThat(fifteen).isEqualTo(Money.dollar(15));
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
      Money five1 = Money.dollar(5);
      Money five2 = Money.dollar(5);
      assertThat(five1).isSameAs(five1);
      assertThat(five1).isNotSameAs(five2);
   }

   @Test
   public void testMultiplicationNegativeFrank()
   {
      Money five = Money.frank(5);
      Multiplicator multiplication = new Multiplicator();

      Money ten = multiplication.times(five, 2);

      assertThat(ten).isNotEqualTo(Money.frank(5));
      assertThat(ten).isNotNull();
   }

   @Test
   public void testMultiplicationPositiveFrank()
   {
      Money five = Money.frank(5);
      Multiplicator multiplication = new Multiplicator();

      Money ten = multiplication.times(five, 2);
      Money fifteen = multiplication.times(five, 3);

      assertThat(ten).isEqualTo(Money.frank(10));
      assertThat(fifteen).isEqualTo(Money.frank(15));
   }

   @Test
   public void testEqualityFrank()
   {
      assertThat(Money.frank(5)).isEqualTo(Money.frank(5));
      assertThat(Money.frank(5)).isNotEqualTo(Money.frank(6));
   }

   @Test
   public void testSameFrank()
   {
      Money five1 = Money.frank(5);
      Money five2 = Money.frank(5);
      assertThat(five1).isSameAs(five1);
      assertThat(five1).isNotSameAs(five2);
   }


}