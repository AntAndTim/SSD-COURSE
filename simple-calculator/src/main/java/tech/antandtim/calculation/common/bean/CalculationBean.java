package tech.antandtim.calculation.common.bean;

import tech.antandtim.calculation.common.operation.Operation;

public interface CalculationBean<NUMBER_TYPE> {

    NUMBER_TYPE getFirstNumber();

    NUMBER_TYPE getSecondNumber();

    Operation<NUMBER_TYPE> getOperation();

}
