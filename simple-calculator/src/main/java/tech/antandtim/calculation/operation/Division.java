package tech.antandtim.calculation.operation;

import java.math.BigDecimal;
import java.util.function.BiFunction;

/**
 * Here there is no handling for zero division, as I find java.lang.ArithmeticException: Division by zero message
 * rather understandable for user, thus I will not implement my own exceptions
 */
public class Division implements Operation {

    @Override
    public BiFunction<BigDecimal, BigDecimal, BigDecimal> getCalculation() {
        return BigDecimal::divide;
    }
}
