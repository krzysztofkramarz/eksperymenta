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
public class IntegrationTests {
    @Test
    public void testDollarFrankEquality() {
        assertThat(Money.dollar(5)).isNotSameAs(Money.frank(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.frank(5));
    }

    @Test
    public void testCurrency() {
        assertThat(Money.dollar(1).getCurrency()).isEqualTo(Money.USD);
        assertThat(Money.dollar(1).getCurrency()).isNotEqualTo(Money.FRANK);
        assertThat(Money.frank(1).getCurrency()).isEqualTo(Money.FRANK);
        assertThat(Money.frank(1).getCurrency()).isNotEqualTo(Money.USD);
    }

    @Test
    public void testMultiplicationWithoutPrzelicznik() {

        assertThat(Money.dollar(1).sum(Money.frank(1))).isEqualTo(Money.dollar(2));
        assertThat(Money.frank(1).sum(Money.dollar(1))).isEqualTo(Money.dollar(2));

        assertThat(Money.dollar(1).sum(Money.frank(1))).isNotEqualTo(Money.dollar(3));
        assertThat(Money.frank(1).sum(Money.dollar(1))).isNotEqualTo(Money.dollar(3));

    }

    @Test
    public void testMultiplicationWithBank() {
        Money expectedAdditionResult = Money.dollar(10); //oczekiwana suma baksów po dodaniu walut
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);

        Bank bank = new Bank();

        // Money reduced = bank.reduce(sum, Money.USD);
        Money reduced = ((Sum) sum).reduce(bank, Money.USD);

        assertThat(reduced).isEqualTo(expectedAdditionResult);

    }
}


