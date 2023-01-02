package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import calculator.string.StringUtils;

public enum Operation {
    PLUS("+", PlusCalculator.instance),
    MINUS("-", MinusCalculator.instance),
    MULTIPLY("*", MultiplyCalculator.instance),
    DIVIDE("/", DivideCalculator.instance);

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

    public static List<Operation> extractOperation(final String value) {
        final char[] chars = StringUtils.getChars(value);
        return IntStream.range(0, chars.length)
                        .filter(i -> Operation.isSupportedSymbol(chars[i]))
                        .mapToObj(i -> String.valueOf(chars[i]))
                        .map(Operation::of)
                        .collect(Collectors.toList());
    }

}
