package caculator.string;

import java.util.Arrays;

import caculator.PositiveNumber;

public class StringAddCalculator {

    public static long add(final String value) {
        return Arrays.stream(StringSplitter.split(value))
                     .map(PositiveNumber::new)
                     .map(PositiveNumber::getValue)
                     .reduce(0L, Long::sum);
    }
}
