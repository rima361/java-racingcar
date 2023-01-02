package calculator;

public class MultiplyCalculator implements Calculator {

    public static final MultiplyCalculator instance = new MultiplyCalculator();

    @Override
    public Number calculate(final Number operand1, final Number operand2) {
        return operand1.multiply(operand2);
    }
}
