package calculator.view;

import java.util.stream.IntStream;

import calculator.Number;
import calculator.Operation;
import calculator.string.StringUtils;

public class CalculatorInputValidator {

    private final String input;

    public CalculatorInputValidator(String input) {
        this.input = input;
    }

    public boolean isValid() {
        if (input == null || input.isEmpty() || isInValidSequence()) {
            return false;
        }

        final char[] chars = input.replaceAll(StringUtils.SPACE, StringUtils.EMPTY).toCharArray();
        return IntStream.range(0, chars.length)
                        .filter(i -> !Character.isDigit(chars[i]))
                        .allMatch(i -> Operation.isSupportedSymbol(chars[i]));
    }

    private boolean isInValidSequence() {
        final char[] chars = input.replaceAll(StringUtils.SPACE, StringUtils.EMPTY).toCharArray();

        if(isEndsWithOperation(chars)) {
            return true;
        }

        return IntStream.range(0, chars.length)
                         .anyMatch(i -> Number.from(i).isOdd() ? !Character.isDigit(chars[i]) : !Operation.isSupportedSymbol(chars[i]));
    }

    private boolean isEndsWithOperation(final char[] chars) {
        return !Character.isDigit(chars[chars.length - 1]);
    }
}
