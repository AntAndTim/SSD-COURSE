package tech.antandtim;

import java.math.BigDecimal;
import java.util.Optional;
import tech.antandtim.calculation.common.bean.CalculationBean;
import tech.antandtim.processing.BigDecimalDataProcessor;
import tech.antandtim.processing.DataProcessor;
import tech.antandtim.worker.Worker;
import tech.antandtim.worker.input.ConsoleWorker;

// TODO: cases such as 3/7
public class EntryPoint {


    public static void main(String[] args) {
        Worker worker = new ConsoleWorker();
        worker.start();
    }
}
