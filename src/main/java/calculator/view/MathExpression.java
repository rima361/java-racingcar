package calculator.view;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import calculator.Number;
import calculator.Operation;
import calculator.string.StringUtils;

public class MathExpression {
    private final List<Number> numbers;
    private final Queue<Operation> operations;

    private MathExpression(final List<Number> numbers, final List<Operation> operations) {
        this.numbers = numbers;
        this.operations = new LinkedList<>(operations);
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public Queue<Operation> getOperations() {
        return operations;
    }

    public static MathExpression of(final String value) {
        if (!new CalculatorInputValidator(value).isValid()) {
            throw new IllegalArgumentException();
        }
        final char[] chars = StringUtils.getChars(value);
        return new MathExpression(extractNumber(chars), extractOperation(chars));
    }

    public Operation pollOperation() {
        final Operation op = this.operations.poll();
        if(op == null) {
            throw new RuntimeException("operation is empty.");
        }
        return op;
    }

    private static List<Number> extractNumber(final char[] chars) {
        return IntStream.range(0, chars.length)
                        .filter(i -> Character.isDigit(chars[i]))
                        .mapToObj(i -> String.valueOf(chars[i]))
                        .map(Long::parseLong)
                        .map(Number::new)
                        .collect(Collectors.toList());
    }

    private static List<Operation> extractOperation(final char[] chars) {
        return IntStream.range(0, chars.length)
                        .filter(i -> Operation.isSupportedSymbol(chars[i]))
                        .mapToObj(i -> String.valueOf(chars[i]))
                        .map(Operation::of)
                        .collect(Collectors.toList());
    }

}
