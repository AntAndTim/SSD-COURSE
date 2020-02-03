package tech.antandtim.calculation.operation;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class Subtraction implements Operation {

    @Override
    public BiFunction<BigDecimal, BigDecimal, BigDecimal> getCalculation() {
        return BigDecimal::subtract;
    }
}
