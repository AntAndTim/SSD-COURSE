package tech.antandtim;

import java.math.BigDecimal;
import java.util.Optional;
import tech.antandtim.calculation.common.bean.CalculationBean;
import tech.antandtim.processing.BigDecimalDataProcessor;
import tech.antandtim.processing.DataProcessor;

// TODO: cases such as 3/7
public class EntryPoint {

    private static final DataProcessor<BigDecimal> DATA_PROCESSOR = new BigDecimalDataProcessor();

    public static void main(String[] args) {
        Optional<CalculationBean<BigDecimal>> calculationBean = DATA_PROCESSOR.extract(System.in);
        calculationBean.ifPresent(EntryPoint::process);
    }

    private static void process(CalculationBean<BigDecimal> bean) {
        System.out.println(DATA_PROCESSOR.calculate(bean));
    }
}
