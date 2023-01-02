package calculator.view;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import calculator.Number;
import calculator.Operation;
import calculator.string.StringUtils;

public class CalculateInfo {
    private final List<Number> numbers;
    private final Queue<Operation> operations;

    private CalculateInfo(final List<Number> numbers, final List<Operation> operations) {
        this.numbers = numbers;
        this.operations = new LinkedList<>(operations);
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public Queue<Operation> getOperations() {
        return operations;
    }

    public static CalculateInfo of(final String value) {
        if (!new CalculatorInputValidator(value).isValid()) {
            throw new IllegalArgumentException();
        }
        return new CalculateInfo(Number.extractNumber(value), Operation.extractOperation(value));
    }

    public Operation pollOperation() {
        final Operation op = this.operations.poll();
        if(op == null) {
            throw new RuntimeException("operation is empty.");
        }
        return op;
    }
}
