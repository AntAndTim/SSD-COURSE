package tech.antandtim.calculation.big.decimal.operation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

/**
 * Here there is no handling for zero division, as I find java.lang.ArithmeticException: BigDecimalDivision by zero
 * message
 * rather understandable for user, thus I will not implement my own exceptions
 */
public class BigDecimalDivision extends BigDecimalOperation {

    @Override
    public BiFunction<BigDecimal, BigDecimal, BigDecimal> getCalculation() {
        return (first, second) -> first.divide(second, RoundingMode.HALF_EVEN);
    }
}
