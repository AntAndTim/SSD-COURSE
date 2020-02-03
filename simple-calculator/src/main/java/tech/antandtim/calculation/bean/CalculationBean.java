package tech.antandtim.calculation.bean;

import java.math.BigDecimal;
import lombok.Data;
import tech.antandtim.calculation.operation.Operation;

@Data
public class CalculationBean {

    private final BigDecimal firstNumber;
    private final BigDecimal secondNumber;
    private final Operation operation;

    public CalculationBean(BigDecimal firstNumber, BigDecimal secondNumber, Operation operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }
}
