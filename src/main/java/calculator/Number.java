package calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import calculator.string.StringUtils;

public class Number {
    private final Long value;

    public static final Number ZERO = new Number(0L);

    public Number(Long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        if(value == null) {
            return StringUtils.EMPTY;
        }
        return value.toString();
    }

    public static List<Number> extractNumber(final String value) {
        final char[] chars = StringUtils.getChars(value);
        return IntStream.range(0, chars.length)
                        .filter(i -> Character.isDigit(chars[i]))
                        .mapToObj(i -> String.valueOf(chars[i]))
                        .map(Long::parseLong)
                        .map(Number::new)
                        .collect(Collectors.toList());
    }

    public Number add(final Number target) {
        return new Number(value + target.value);
    }

    public Number subtract(final Number target) {
        return new Number(value - target.value);
    }

    public Number multiply(final Number target) {
        return new Number(value * target.value);
    }

    public Number divide(final Number target) {
        return new Number(value / target.value);
    }
}
