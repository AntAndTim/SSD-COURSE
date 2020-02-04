package tech.antandtim.processing;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;
import tech.antandtim.calculation.common.bean.CalculationBean;
import tech.antandtim.calculation.big.decimal.bean.BigDecimalCalculationBean;
import tech.antandtim.calculation.common.mapper.OperationMapper;
import tech.antandtim.calculation.big.decimal.mapper.BigDecimalOperationMapper;

public class BigDecimalDataProcessor implements DataProcessor<BigDecimal> {

    private static final OperationMapper<BigDecimal> operationMapper = new BigDecimalOperationMapper();

    @Override
    public BigDecimal calculate(CalculationBean<BigDecimal> calculationBean) {
        return calculationBean
            .getOperation()
            .getCalculation()
            .apply(calculationBean.getFirstNumber(), calculationBean.getSecondNumber());
    }

    @Override
    public Optional<CalculationBean<BigDecimal>> extract(InputStream inputStream) {
        var scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            var inputString = scanner.nextLine();
            var calculationInputs = inputString
                .replace(" ", "")
                .split(ALLOWED_OPERATIONS);
            var firstNumber = new BigDecimal(calculationInputs[0]);
            var secondNumber = new BigDecimal(calculationInputs[1]);
            var operation = operationMapper.map(extractOperation(inputString));
            return Optional.of(new BigDecimalCalculationBean(firstNumber, secondNumber, operation));
        }
        return Optional.empty();
    }

    /**
     * Case of incorrect operation is not handled by reason. I think, java.lang.NumberFormatException is pretty much
     * clear in explaining problem to the user, so I find no reason in implementing my own exceptions.
     */
    private static String extractOperation(String inputString) {
        var matcher = ALLOWED_PATTERN.matcher(inputString);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
