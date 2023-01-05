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
        if(value == null) {
            throw new IllegalArgumentException("value can not be null.");
        }
        this.value = value;
    }

    public static Number from(final int value) {
        return new Number((long) value);
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
        return value.toString();
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

    public boolean isOdd() {
        return value % 2 == 0;
    }
}
