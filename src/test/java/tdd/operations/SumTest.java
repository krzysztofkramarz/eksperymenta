package tdd.operations;

import com.fonowizja.eksperymenta.tdd.calculators.Bank;
import com.fonowizja.eksperymenta.tdd.currency.Money;
import com.fonowizja.eksperymenta.tdd.operations.Expression;
import com.fonowizja.eksperymenta.tdd.operations.Sum;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author krzysztof.kramarz
 */
public class SumTest {
    @Test
    public void testPlus() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.frank(10);
        Bank bank = new Bank();
        bank.addRate(Money.FRANK, Money.USD, 2);

        Expression plus = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
        Expression plusFranc = new Sum(fiveDollars, tenFrancs).plus(tenFrancs);
        Money reduce = bank.reduce(plus, Money.USD);
        Money reduceFranc = bank.reduce(plusFranc, Money.USD);
        assertThat(reduce).isEqualTo(Money.dollar(15));
        assertThat(reduceFranc).isEqualTo(Money.dollar(15));
    }

    @Test
    public void testTimes() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.frank(10);
        Integer multiplier = 5;
        Bank bank = new Bank();
        bank.addRate(Money.FRANK, Money.USD, 2);
        Expression plus = new Sum(fiveDollars, tenFrancs).times(multiplier);
        Money reduce = bank.reduce(plus, Money.USD);
        assertThat(reduce).isEqualTo(Money.dollar(50));
        assertThat(reduce).isNotEqualTo(Money.dollar(51));
    }
}