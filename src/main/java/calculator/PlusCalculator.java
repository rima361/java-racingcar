package calculator;

public class PlusCalculator implements Calculator {

    public static final PlusCalculator instance = new PlusCalculator();

    @Override
    public Number calculate(final Number operand1, final Number operand2) {
        return new Number(operand1.getValue() + operand2.getValue());
    }
}
