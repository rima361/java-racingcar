package calculator.string;

public class StringAddCalculatorInput {

    private final String target;

    public static StringAddCalculatorInput of(final String target) {
        if(target == null) {
            throw new IllegalArgumentException("target is required.");
        }
        return new StringAddCalculatorInput(target);
    }

    private StringAddCalculatorInput(final String target) {
        this.target = target;
    }

    public String[] split(final String splitter) {
        return target.split(splitter);
    }
}
