package tech.antandtim.worker.input;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.Stack;
import tech.antandtim.calculation.common.bean.CalculationBean;
import tech.antandtim.handler.input.ConsoleHandler;
import tech.antandtim.processing.BigDecimalDataProcessor;
import tech.antandtim.processing.DataProcessor;
import tech.antandtim.worker.AbstractWorker;

public class ConsoleWorker extends AbstractWorker {

    private static final OperationsLogger LOGGER = new OperationsLogger();
    private final ConsoleHandler consoleHandler = new ConsoleHandler(this);
    private final DataProcessor<BigDecimal> dataProcessor = new BigDecimalDataProcessor(consoleHandler);

    private void process(CalculationBean<BigDecimal> bean) {
        BigDecimal result = dataProcessor.calculate(bean);
        LOGGER.log(result.toString());
        System.out.println(result);
    }

    @Override
    public void doActions() {
        Optional<CalculationBean<BigDecimal>> calculationBean = dataProcessor.extract(System.in);
        calculationBean.ifPresent(this::process);
    }

    @Override
    public void showLog() {
        System.out.println(LOGGER.getMessages());
    }
}
