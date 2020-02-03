package tech.antandtim.calculation.mapper;

import tech.antandtim.calculation.operation.Division;
import tech.antandtim.calculation.operation.Multiplication;
import tech.antandtim.calculation.operation.Operation;
import tech.antandtim.calculation.operation.Subtraction;
import tech.antandtim.calculation.operation.Summation;

public class OperationMapper {

    public static Operation map(String operation) {
        if (operation == null) {
            throw new UnsupportedOperationException("Please, provide some operation!");
        }
        switch (operation) {
            case "+":
                return new Summation();
            case "-":
                return new Subtraction();
            case "/":
                return new Division();
            case "*":
                return new Multiplication();
            default:
                return null;
        }
    }
}
