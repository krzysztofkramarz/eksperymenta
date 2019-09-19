package tdd_refactor;

import com.fonowizja.eksperymenta.tdd_refactor.calculators.Bank;
import com.fonowizja.eksperymenta.tdd_refactor.currency.Money;
import com.fonowizja.eksperymenta.tdd_refactor.operations.Expression;
import com.fonowizja.eksperymenta.tdd_refactor.operations.ExpressionImpl;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author krzysztof.kramarz
 */
public class BankTest {

    @Test
    public void testReduceWithBankWithoutPrzelicznik() {
        Money expectedAdditionResult = Money.dollar(10); //oczekiwana suma baksów po dodaniu walut
        Money five = Money.dollar(5);
        Expression sum = new ExpressionImpl();

        Bank bank = new Bank(five, five);

        Money reduced = bank.reduce(sum, Money.USD);

        assertThat(reduced).isEqualTo(expectedAdditionResult);

    }

    @Test
    public void testReduceWithBankWithoutPrzelicznikTwoMoney() {
        Money five = Money.dollar(5);
        Money seven = Money.dollar(7);
        Expression sum = new ExpressionImpl();
        Bank bank = new Bank(five, seven);

        Money reduce = bank.reduce(sum, Money.USD);
        assertThat(reduce).isEqualTo(Money.dollar(12));
    }

    @Test
    public void testReduceTheSameCurrency() {
        Money five = Money.dollar(5);
        Bank bank = new Bank(five, five);
        Expression expression = new ExpressionImpl();
        Money reduce = bank.reduce(expression, Money.USD); //TODO nie da się zaimplementowacprosto redukcji jednej waluty!
        // assertThat(reduce).isEqualTo(Money.dollar(5));
        assertThat(reduce).isEqualTo(Money.dollar(10));//TODO BŁĄD!!!
    }

    @Test
    public void testReduceDifferentCurrency() {
        Money eightFrancs = Money.frank(8);
        Bank bank = new Bank(eightFrancs, eightFrancs); //TODO nie da się zaimplementowacprosto redukcji jednej waluty!
        bank.addRate(Money.FRANK, Money.USD, 2);
        Expression expression = new ExpressionImpl();
        Money reduce = bank.reduce(expression, Money.USD);
        // assertThat(reduce).isEqualTo(Money.dollar(4));
        assertThat(reduce).isEqualTo(Money.dollar(8));//TODO BŁĄD!!! SUMUJE 4 + 4!
    }

    @Test
    public void testMixedAddition() {
        Money fiveDollars = Money.dollar(5);
        Money tenFrancs = Money.frank(10);
        Bank bank = new Bank(fiveDollars, tenFrancs);
        bank.addRate(Money.FRANK, Money.USD, 2);
        Expression expression = new ExpressionImpl();

        Money reduceFranc = bank.reduce(expression, Money.USD);
        Money reduceDollar = bank.reduce(expression, Money.USD);
        assertThat(reduceDollar).isEqualTo(Money.dollar(10));
        assertThat(reduceFranc).isEqualTo(Money.dollar(10));
    }

    @Test
    public void testIdentityRate() {
        Money one = Money.dollar(1);//TODO roblem z nadmiarową inicjalizacją
        Bank bank = new Bank(one, one);
        assertThat(bank.rate(Money.USD, Money.USD)).isEqualTo(1);
    }

}