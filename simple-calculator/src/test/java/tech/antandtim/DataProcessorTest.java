package tech.antandtim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import tech.antandtim.calculation.big.decimal.bean.BigDecimalCalculationBean;
import tech.antandtim.calculation.big.decimal.operation.BigDecimalDivision;
import tech.antandtim.calculation.big.decimal.operation.BigDecimalMultiplication;
import tech.antandtim.calculation.big.decimal.operation.BigDecimalSubtraction;
import tech.antandtim.calculation.big.decimal.operation.BigDecimalSummation;
import tech.antandtim.calculation.common.bean.CalculationBean;
import tech.antandtim.processing.BigDecimalDataProcessor;
import tech.antandtim.processing.DataProcessor;

class DataProcessorTest {

    private static final DataProcessor<BigDecimal> DATA_PROCESSOR = new BigDecimalDataProcessor(null);

    private static InputStream produceInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes());
    }

    @Test
    void calculateDivision() {
        var calculationBean = new BigDecimalCalculationBean(BigDecimal.valueOf(3), BigDecimal.valueOf(4),
                                                            new BigDecimalDivision());
        assertEquals(DATA_PROCESSOR.calculate(calculationBean), BigDecimal.valueOf(0.75));
    }

    @Test
    void calculateSummation() {
        var calculationBean = new BigDecimalCalculationBean(BigDecimal.valueOf(3), BigDecimal.valueOf(4),
                                                            new BigDecimalSummation());
        assertEquals(DATA_PROCESSOR.calculate(calculationBean), BigDecimal.valueOf(7));
    }

    @Test
    void calculateMultiplication() {
        var calculationBean = new BigDecimalCalculationBean(BigDecimal.valueOf(3), BigDecimal.valueOf(4),
                                                            new BigDecimalMultiplication());
        assertEquals(DATA_PROCESSOR.calculate(calculationBean), BigDecimal.valueOf(12));
    }

    @Test
    void calculateSubtraction() {
        var calculationBean = new BigDecimalCalculationBean(BigDecimal.valueOf(3), BigDecimal.valueOf(4),
                                                            new BigDecimalSubtraction());
        assertEquals(DATA_PROCESSOR.calculate(calculationBean), BigDecimal.valueOf(-1));
    }

    //Extraction tests

    @Test
    void extractSummation() {
        String s = "3 + 4";
        var calculationBeanOptional = DATA_PROCESSOR.extract(produceInputStream(s));
        if (calculationBeanOptional.isEmpty()) {
            throw new NullPointerException();
        }

        assertCalculationBean(calculationBeanOptional.get(),
                              BigDecimal.valueOf(3), BigDecimal.valueOf(4),
                              BigDecimalSummation.class);
    }

    @Test
    void extractDivision() {
        String s = "3.0 / 4.5";
        var calculationBeanOptional = DATA_PROCESSOR.extract(produceInputStream(s));
        if (calculationBeanOptional.isEmpty()) {
            throw new NullPointerException();
        }

        assertCalculationBean(calculationBeanOptional.get(),
                              BigDecimal.valueOf(3.0), BigDecimal.valueOf(4.5),
                              BigDecimalDivision.class);
    }

    @Test
    void extractMultiplication() {
        String s = "33 * 0.21";
        var calculationBeanOptional = DATA_PROCESSOR.extract(produceInputStream(s));
        if (calculationBeanOptional.isEmpty()) {
            throw new NullPointerException();
        }

        assertCalculationBean(calculationBeanOptional.get(),
                              BigDecimal.valueOf(33), BigDecimal.valueOf(0.21),
                              BigDecimalMultiplication.class);
    }

    @Test
    void extractSubtraction() {
        String s = "3 - 7.9";
        var calculationBeanOptional = DATA_PROCESSOR.extract(produceInputStream(s));
        if (calculationBeanOptional.isEmpty()) {
            throw new NullPointerException();
        }

        assertCalculationBean(calculationBeanOptional.get(),
                              BigDecimal.valueOf(3), BigDecimal.valueOf(7.9),
                              BigDecimalSubtraction.class);
    }

    @Test
    void extractNotOperation() {
        String s = "3 & 7.9";
        assertThrows(NumberFormatException.class, () -> DATA_PROCESSOR.extract(produceInputStream(s)));
    }

    private void assertCalculationBean(CalculationBean<BigDecimal> calculationBean,
                                       BigDecimal firstNumber, BigDecimal secondNumber,
                                       Class<?> operationClass) {

        assertEquals(firstNumber, calculationBean.getFirstNumber());
        assertEquals(secondNumber, calculationBean.getSecondNumber());
        assertEquals(operationClass, calculationBean.getOperation().getClass());
    }
}