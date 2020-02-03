package tech.antandtim;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import tech.antandtim.calculation.bean.CalculationBean;
import tech.antandtim.calculation.mapper.OperationMapper;

public class DataProcessor {

    private static final String ALLOWED_OPERATIONS = "[+\\-/*]";
    private static final Pattern ALLOWED_PATTERN = Pattern.compile(ALLOWED_OPERATIONS);

    public static BigDecimal calculate(CalculationBean calculationBean) {
        return calculationBean
            .getOperation()
            .getCalculation()
            .apply(calculationBean.getFirstNumber(), calculationBean.getSecondNumber());
    }

    public static Optional<CalculationBean> extract(InputStream inputStream) {
        var scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            var inputString = scanner.nextLine();
            var calculationInputs = inputString
                .replace(" ", "")
                .split(ALLOWED_OPERATIONS);
            var firstNumber = new BigDecimal(calculationInputs[0]);
            var secondNumber = new BigDecimal(calculationInputs[1]);
            var operation = OperationMapper.map(extractOperation(inputString));
            return Optional.of(new CalculationBean(firstNumber, secondNumber, operation));
        }
        return Optional.empty();
    }

    private static String extractOperation(String inputString) {
        var matcher = ALLOWED_PATTERN.matcher(inputString);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
