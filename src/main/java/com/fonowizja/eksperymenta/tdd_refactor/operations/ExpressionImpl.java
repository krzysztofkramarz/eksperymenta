package com.fonowizja.eksperymenta.tdd_refactor.operations;

import com.fonowizja.eksperymenta.tdd_refactor.calculators.Bank;
import com.fonowizja.eksperymenta.tdd_refactor.currency.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author krzysztof.kramarz
 */
@AllArgsConstructor
@Getter
@Setter
public class ExpressionImpl implements Expression {


    @Override
    public Money reduce(Bank bank, String to) {
        return null;
    }

    @Override
    public Money plus(Money augend, Money addend) {
        return new Money(augend.getAmount() + addend.getAmount(), augend.getCurrency());
    }

    @Override
    public Money minus(Money augend, Money addend) {
        return null;
    }

}
