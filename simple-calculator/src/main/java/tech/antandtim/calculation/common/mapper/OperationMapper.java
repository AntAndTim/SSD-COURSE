package tech.antandtim.calculation.common.mapper;

import tech.antandtim.calculation.common.operation.Operation;

public interface OperationMapper<NUMBER_TYPE> {

    Operation<NUMBER_TYPE> map(String operation);
}
