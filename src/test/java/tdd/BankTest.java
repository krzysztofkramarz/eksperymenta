package tdd;

import com.fonowizja.eksperymenta.tdd.calculators.Bank;
import com.fonowizja.eksperymenta.tdd.currency.Money;
import com.fonowizja.eksperymenta.tdd.operations.Expression;
import com.fonowizja.eksperymenta.tdd.operations.Sum;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author krzysztof.kramarz
 */
public class BankTest {

    @Test
    public void testReduceSumTheSameCurrency() {
        Money five = Money.dollar(5);
        Money seven = Money.dollar(7);
        Expression sum = new Sum(five, seven);
        Bank bank = new Bank();

        Money reduce = bank.reduce(sum, Money.USD);
        assertThat(reduce).isEqualTo(Money.dollar(12));
    }

    @Test
    public void testReduceTheSameCurrency() {
        Money five = Money.dollar(5);
        Bank bank = new Bank();

        Money reduce = bank.reduce(five, Money.USD);
        assertThat(reduce).isEqualTo(Money.dollar(5));
    }

    @Test
    public void testReduceDifferentCurrency() {
        Money eightFrancs = Money.frank(8);
        Bank bank = new Bank();
        bank.addRate(Money.FRANK, Money.USD, 2);

        Money reduce = bank.reduce(eightFrancs, Money.USD);
        assertThat(reduce).isEqualTo(Money.dollar(4));
    }

    @Test
    public void testMixedAddition() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.frank(10);
        Bank bank = new Bank();
        bank.addRate(Money.FRANK, Money.USD, 2);

        Money reduceFranc = bank.reduce(tenFrancs.plus(fiveDollars), Money.USD);
        Money reduceDollar = bank.reduce(fiveDollars.plus(tenFrancs), Money.USD);
        assertThat(reduceDollar).isEqualTo(Money.dollar(10));
        assertThat(reduceFranc).isEqualTo(Money.dollar(10));
    }

    @Test
    public void testIdentityRate() {
        Bank bank = new Bank();
        assertThat(bank.rate(Money.USD, Money.USD)).isEqualTo(1);
    }


}