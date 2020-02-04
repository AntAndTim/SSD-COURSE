package tech.antandtim.calculation.big.decimal.mapper;

import java.math.BigDecimal;
import tech.antandtim.calculation.common.mapper.OperationMapper;
import tech.antandtim.calculation.common.operation.Operation;
import tech.antandtim.calculation.big.decimal.operation.BigDecimalDivision;
import tech.antandtim.calculation.big.decimal.operation.BigDecimalMultiplication;
import tech.antandtim.calculation.big.decimal.operation.BigDecimalSubtraction;
import tech.antandtim.calculation.big.decimal.operation.BigDecimalSummation;

public class BigDecimalOperationMapper implements OperationMapper<BigDecimal> {

    @Override
    public Operation<BigDecimal> map(String operation) {
        if (operation == null) {
            throw new UnsupportedOperationException("Please, provide some operation!");
        }
        switch (operation) {
            case "+":
                return new BigDecimalSummation();
            case "-":
                return new BigDecimalSubtraction();
            case "/":
                return new BigDecimalDivision();
            case "*":
                return new BigDecimalMultiplication();
            default:
                return null;
        }
    }
}
