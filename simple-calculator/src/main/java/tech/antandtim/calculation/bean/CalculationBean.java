package tech.antandtim.calculation.bean;

import tech.antandtim.calculation.operation.Operation;

import java.math.BigDecimal;

public class CalculationBean {

    private final BigDecimal firstNumber;
    private final BigDecimal secondNumber;
    private final Operation operation;

    public CalculationBean(BigDecimal firstNumber, BigDecimal secondNumber, Operation operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    public BigDecimal getFirstNumber() {
        return this.firstNumber;
    }

    public BigDecimal getSecondNumber() {
        return this.secondNumber;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public String toString() {
        return "CalculationBean(firstNumber=" + this.getFirstNumber() + ", secondNumber=" + this.getSecondNumber()
                + ", operation=" + this.getOperation() + ")";
    }
}
