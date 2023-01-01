package calculator;

import java.util.Optional;

import calculator.view.CalculateInfo;

public class StringCalculator {

    public static Number calculate(final CalculateInfo target) {
        return _calculate(target).orElse(Number.ZERO);
    }

    private static Optional<Number> _calculate(final CalculateInfo target) {
        return target.getNumbers()
                     .stream()
                     .reduce((x, y) -> target.pollOperation().calculate(x, y));
    }
}
