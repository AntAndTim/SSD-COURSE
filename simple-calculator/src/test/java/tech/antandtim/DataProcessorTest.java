package tech.antandtim;

import org.junit.jupiter.api.Test;
import tech.antandtim.calculation.bean.CalculationBean;
import tech.antandtim.calculation.operation.Division;
import tech.antandtim.calculation.operation.Multiplication;
import tech.antandtim.calculation.operation.Subtraction;
import tech.antandtim.calculation.operation.Summation;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DataProcessorTest {

    private static InputStream produceInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes());
    }

    @Test
    void calculateDivision() {
        var calculationBean = new CalculationBean(BigDecimal.valueOf(3), BigDecimal.valueOf(4), new Division());
        assertEquals(DataProcessor.calculate(calculationBean), BigDecimal.valueOf(0.75));
    }

    @Test
    void calculateSummation() {
        var calculationBean = new CalculationBean(BigDecimal.valueOf(3), BigDecimal.valueOf(4), new Summation());
        assertEquals(DataProcessor.calculate(calculationBean), BigDecimal.valueOf(7));
    }

    @Test
    void calculateMultiplication() {
        var calculationBean = new CalculationBean(BigDecimal.valueOf(3), BigDecimal.valueOf(4), new Multiplication());
        assertEquals(DataProcessor.calculate(calculationBean), BigDecimal.valueOf(12));
    }

    @Test
    void calculateSubtraction() {
        var calculationBean = new CalculationBean(BigDecimal.valueOf(3), BigDecimal.valueOf(4), new Subtraction());
        assertEquals(DataProcessor.calculate(calculationBean), BigDecimal.valueOf(-1));
    }

    //Extraction tests

    @Test
    void extractSummation() {
        String s = "3 + 4";
        var calculationBeanOptional = DataProcessor.extract(produceInputStream(s));
        if (calculationBeanOptional.isEmpty()) {
            throw new NullPointerException();
        }

        assertCalculationBean(calculationBeanOptional.get(),
                BigDecimal.valueOf(3), BigDecimal.valueOf(4),
                Summation.class);
    }

    @Test
    void extractDivision() {
        String s = "3.0 / 4.5";
        var calculationBeanOptional = DataProcessor.extract(produceInputStream(s));
        if (calculationBeanOptional.isEmpty()) {
            throw new NullPointerException();
        }

        assertCalculationBean(calculationBeanOptional.get(),
                BigDecimal.valueOf(3.0), BigDecimal.valueOf(4.5),
                Division.class);
    }

    @Test
    void extractMultiplication() {
        String s = "33 * 0.21";
        var calculationBeanOptional = DataProcessor.extract(produceInputStream(s));
        if (calculationBeanOptional.isEmpty()) {
            throw new NullPointerException();
        }

        assertCalculationBean(calculationBeanOptional.get(),
                BigDecimal.valueOf(33), BigDecimal.valueOf(0.21),
                Multiplication.class);
    }

    @Test
    void extractSubtraction() {
        String s = "3 - 7.9";
        var calculationBeanOptional = DataProcessor.extract(produceInputStream(s));
        if (calculationBeanOptional.isEmpty()) {
            throw new NullPointerException();
        }

        assertCalculationBean(calculationBeanOptional.get(),
                BigDecimal.valueOf(3), BigDecimal.valueOf(7.9),
                Subtraction.class);
    }

    @Test
    void extractNotOperation() {
        String s = "3 & 7.9";
        assertThrows(NumberFormatException.class, () -> DataProcessor.extract(produceInputStream(s)));
    }

    private void assertCalculationBean(CalculationBean calculationBean,
                                       BigDecimal firstNumber, BigDecimal secondNumber,
                                       Class<?> operationClass) {

        assertEquals(firstNumber, calculationBean.getFirstNumber());
        assertEquals(secondNumber, calculationBean.getSecondNumber());
        assertEquals(operationClass, calculationBean.getOperation().getClass());
    }
}