// package tdd_refactor.operations;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// import org.junit.Test;
// import tdd_refactor.calculators.Bank;
// import tdd_refactor.currency.Money;
// import tdd_refactor.operations.Sum;
//
// /**
//  * @author krzysztof.kramarz
//  */
// public class SumTest
// {
//    @Test
//    public void testPlus()
//    {
//       Expression fiveDollars = Money.dollar(5);
//       Expression tenFrancs = Money.frank(10);
//       Bank bank = new Bank();
//       bank.addRate(Money.FRANK, Money.USD, 2);
//
//       Expression plus = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
//       Expression plusFranc = new Sum(fiveDollars, tenFrancs).plus(tenFrancs);
//       Money reduce = bank.reduce(plus, Money.USD);
//       Money reduceFranc = bank.reduce(plusFranc, Money.USD);
//       assertThat(reduce).isEqualTo(Money.dollar(15));
//       assertThat(reduceFranc).isEqualTo(Money.dollar(15));
//    }
//
//    @Test
//    public void testTimes()
//    {
//       Expression fiveDollars = Money.dollar(5);
//       Expression tenFrancs = Money.frank(10);
//       Integer multiplier = 5;
//       Bank bank = new Bank();
//       bank.addRate(Money.FRANK, Money.USD, 2);
//       Expression plus = new Sum(fiveDollars, tenFrancs).times(multiplier);
//       Money reduce = bank.reduce(plus, Money.USD);
//       assertThat(reduce).isEqualTo(Money.dollar(50));
//       assertThat(reduce).isNotEqualTo(Money.dollar(51));
//    }
// }