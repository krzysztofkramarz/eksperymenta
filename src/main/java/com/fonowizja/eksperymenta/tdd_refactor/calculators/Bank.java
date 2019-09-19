package com.fonowizja.eksperymenta.tdd_refactor.calculators;

import com.fonowizja.eksperymenta.tdd_refactor.currency.Money;
import com.fonowizja.eksperymenta.tdd_refactor.operations.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author krzysztof.kramarz
 */
@SuppressWarnings("NewClassNamingConvention")
@Getter
@Setter
public class Bank {
    private Money augend;
    private Money addend;

    private Map<Pair, Integer> rate = new HashMap<>();

    public Bank(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Expression source, String to) {
        Money first = new Money(augend.getAmount() / rate(augend.getCurrency(), to), augend.getCurrency());
        Money second = new Money(addend.getAmount() / rate(addend.getCurrency(), to), addend.getCurrency());

        return new Money(source.plus(first, second).getAmount(), to);
    }

    public Pair addRate(String from, String to, int i) {
        Pair pair = new Pair(from, to);
        rate.put(pair, i);
        return pair;
    }

    private Integer getRate(Pair pair) {
        return rate.get(pair);
    }

    public Integer rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        Pair pair = new Pair(from, to);

        return getRate(pair);
    }

    /**
     * @author krzysztof.kramarz
     */
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Pair {
        private String from;
        private String to;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return Objects.equals(from, pair.from) &&
                    Objects.equals(to, pair.to);
        }

        @Override
        public int hashCode() {
            return 0;
            // return Objects.hash(from, to);
        }
    }
}
