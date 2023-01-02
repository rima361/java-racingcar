package calculator;

import java.util.List;
import java.util.Objects;

public class PositiveNumber {
    private final long value;

    private PositiveNumber(final long value) {
        this.value = value;
    }

    public static PositiveNumber of(final String value) {
        final long parsed = isEmpty(value) ? 0 : parse(value);
        if (parsed < 0) {
            throw new RuntimeException("Negative number type is not supported.");
        }
        return new PositiveNumber(parsed);
    }

    public static long sum(final List<PositiveNumber> numbers) {
        return numbers.stream()
                      .reduce(PositiveNumber::add)
                      .map(x -> x.value)
                      .orElse(0L);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static long parse(final String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unsupported number type.");
        }
    }

    private static PositiveNumber add(final PositiveNumber num1, final PositiveNumber num2) {
        return new PositiveNumber(num1.value + num2.value);
    }

    private static boolean isEmpty(final String value) {
        return value == null || value.isEmpty();
    }
}
