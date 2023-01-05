package calculator.view;

import java.util.Scanner;

import calculator.Number;
import calculator.StringCalculator;

public class CalculatorRunner {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(final String[] args) {
        System.out.println("Input: ");
        final MathExpression input = MathExpression.of(SCANNER.next());
        final Number result = StringCalculator.calculate(input);
        System.out.println("Result: " + result);
    }
}
