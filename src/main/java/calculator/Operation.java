package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operation {
    PLUS("+", Number::add),
    MINUS("-", Number::subtract),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private final String symbol;
    private final Calculator calculator;

    private final static List<String> SYMBOLS = Arrays.stream(Operation.values())
                                                      .map(op -> op.symbol)
                                                      .collect(Collectors.toList());

    Operation(final String symbol, final Calculator calculator) {
        this.symbol = symbol;
        this.calculator = calculator;
    }

    public static Operation of(final String value) {
        return Arrays.stream(Operation.values())
                     .filter(op -> op.symbol.equals(value))
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new);
    }

    public static boolean isSupportedSymbol(final char symbol) {
        return SYMBOLS.contains(Character.toString(symbol));
    }

    public Number calculate(final Number operand1, final Number operand2) {
        return calculator.calculate(operand1, operand2);
    }

}
