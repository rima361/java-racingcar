package calculator;

public class MultiplyCalculator implements Calculator {

    public static final MultiplyCalculator instance = new MultiplyCalculator();

    @Override
    public Number calculate(final Number operand1, final Number operand2) {
        return new Number(operand1.getValue() * operand2.getValue());
    }
}
