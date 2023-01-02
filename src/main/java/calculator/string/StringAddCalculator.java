package calculator.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import calculator.PositiveNumber;

public class StringAddCalculator {

    public static long add(final String value) {
        final List<PositiveNumber> numbers = Arrays.stream(StringUtils.split(value))
                                                   .map(PositiveNumber::of)
                                                   .collect(Collectors.toList());
        return PositiveNumber.sum(numbers);
    }
}
