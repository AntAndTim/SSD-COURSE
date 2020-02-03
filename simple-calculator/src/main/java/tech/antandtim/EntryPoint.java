package tech.antandtim;

import java.util.Optional;
import tech.antandtim.calculation.bean.CalculationBean;

public class EntryPoint {

    public static void main(String[] args) {
        Optional<CalculationBean> calculationBean = DataProcessor.extract(System.in);
        calculationBean.ifPresent(EntryPoint::process);
    }

    private static void process(CalculationBean bean) {
        System.out.println(DataProcessor.calculate(bean));
    }
}
