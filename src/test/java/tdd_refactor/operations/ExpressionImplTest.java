package tdd_refactor.operations;

import com.fonowizja.eksperymenta.tdd_refactor.currency.Money;
import com.fonowizja.eksperymenta.tdd_refactor.operations.Expression;
import com.fonowizja.eksperymenta.tdd_refactor.operations.ExpressionImpl;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * @author krzysztof.kramarz
 */
public class ExpressionImplTest {
    @Test
    public void testPlusWithoutPrzelicznik() {
        Expression expression = new ExpressionImpl();

        assertThat(expression.plus(Money.dollar(1), Money.frank(1))).isEqualTo(Money.dollar(2));
        assertThat(expression.plus(Money.frank(1), Money.dollar(1))).isEqualTo(Money.frank(2));
        assertThat(expression.plus(Money.frank(1), Money.dollar(1)).getCurrency()).isEqualTo(Money.USD);

        assertThat(expression.plus(Money.dollar(1), Money.frank(1))).isNotEqualTo(Money.dollar(3));
        assertThat(expression.plus(Money.frank(1), Money.dollar(1))).isNotEqualTo(Money.frank(3));

    }

    //
    // @Test
    // public void testPlusReturnsSum()
    // {
    //    Money five = Money.dollar(5);
    //    Money result = five.plus(five);
    //    Sum sum = (Sum) result;
    //    assertThat(sum.getAugend()).isEqualTo(five);
    //    assertThat(sum.getAddend()).isEqualTo(five);
    // }
    //
    // @Test
    // public void testSumReturnsMoney(){
    //
    //    Expression plus = Money.dollar(1).plus(Money.dollar(1));
    //    assertThat(plus).isNotInstanceOf(Money.class);
    // }

}