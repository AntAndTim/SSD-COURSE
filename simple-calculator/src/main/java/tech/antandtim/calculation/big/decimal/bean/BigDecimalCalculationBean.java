package tech.antandtim.calculation.big.decimal.bean;

import java.math.BigDecimal;
import tech.antandtim.calculation.common.bean.CalculationBean;
import tech.antandtim.calculation.common.operation.Operation;

public class BigDecimalCalculationBean implements CalculationBean<BigDecimal> {

    private final BigDecimal firstNumber;
    private final BigDecimal secondNumber;
    private final Operation<BigDecimal> operation;

    public BigDecimalCalculationBean(BigDecimal firstNumber, BigDecimal secondNumber, Operation<BigDecimal> operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    @Override
    public BigDecimal getFirstNumber() {
        return this.firstNumber;
    }

    @Override
    public BigDecimal getSecondNumber() {
        return this.secondNumber;
    }

    @Override
    public Operation<BigDecimal> getOperation() {
        return this.operation;
    }

    public String toString() {
        return "BigDecimalCalculationBean(firstNumber=" + this.getFirstNumber() + ", secondNumber="
            + this.getSecondNumber()
            + ", operation=" + this.getOperation() + ")";
    }
}
