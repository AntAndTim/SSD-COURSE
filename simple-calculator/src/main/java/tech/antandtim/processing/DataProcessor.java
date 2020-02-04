package tech.antandtim.processing;

import java.io.InputStream;
import java.util.Optional;
import java.util.regex.Pattern;
import tech.antandtim.calculation.common.bean.CalculationBean;

public interface DataProcessor<NUMBER_TYPE> {

    String ALLOWED_OPERATIONS = "[+\\-/*]";
    Pattern ALLOWED_PATTERN = Pattern.compile(ALLOWED_OPERATIONS);

    NUMBER_TYPE calculate(CalculationBean<NUMBER_TYPE> calculationBean);

    Optional<CalculationBean<NUMBER_TYPE>> extract(InputStream inputStream);
}
