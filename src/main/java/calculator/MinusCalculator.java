package calculator;

public class MinusCalculator implements Calculator {

    public static final MinusCalculator instance = new MinusCalculator();

    @Override
    public Number calculate(final Number operand1, final Number operand2) {
        return new Number(operand1.getValue() - operand2.getValue());
    }
}
