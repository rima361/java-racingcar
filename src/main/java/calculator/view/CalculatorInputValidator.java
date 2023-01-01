package calculator.view;

import java.util.stream.IntStream;

import calculator.Operation;
import calculator.string.StringSupport;

public class CalculatorInputValidator {

    private final String input;

    public CalculatorInputValidator(String input) {
        this.input = input;
    }

    public boolean isValid() {
        if (input == null || input.isEmpty()) {
            return false;
        }

        final char[] chars = input.replaceAll(StringSupport.SPACE, StringSupport.EMPTY).toCharArray();
        return IntStream.range(0, chars.length)
                        .filter(i -> !Character.isDigit(chars[i]))
                        .allMatch(i -> Operation.isSupportedSymbol(chars[i]));
    }


}
