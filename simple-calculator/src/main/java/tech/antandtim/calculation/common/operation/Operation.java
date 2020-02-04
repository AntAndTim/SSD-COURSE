package tech.antandtim.calculation.common.operation;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Operation<NUMBER_TYPE> {

    BiFunction<NUMBER_TYPE, NUMBER_TYPE, NUMBER_TYPE> getCalculation();
}
