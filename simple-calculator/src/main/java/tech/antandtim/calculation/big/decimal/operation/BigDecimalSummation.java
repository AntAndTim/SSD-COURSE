package tech.antandtim.calculation.big.decimal.operation;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class BigDecimalSummation extends BigDecimalOperation {

    @Override
    public BiFunction<BigDecimal, BigDecimal, BigDecimal> getCalculation() {
        return BigDecimal::add;
    }
}
