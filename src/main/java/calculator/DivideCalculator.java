package calculator;

public class DivideCalculator implements Calculator {

    public static final DivideCalculator instance = new DivideCalculator();

    @Override
    public Number calculate(final Number operand1, final Number operand2) {
        return new Number(operand1.getValue() / operand2.getValue());
    }
}
