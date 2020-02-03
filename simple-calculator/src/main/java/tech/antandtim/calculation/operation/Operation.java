package tech.antandtim.calculation.operation;

import java.math.BigDecimal;
import java.util.function.BiFunction;

@FunctionalInterface
public interface Operation {

    BiFunction<BigDecimal, BigDecimal, BigDecimal> getCalculation();
}
