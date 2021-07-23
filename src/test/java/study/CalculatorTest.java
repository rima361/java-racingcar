package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 = 3", "2 + 4 = 6"}, delimiter = '=')
    public void plusTest(String data, int expectResult) {
        int calcResult = Calculator.calculate(data);
        assertThat(calcResult).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 - 1 = 1", "4 - 2 = 2"}, delimiter = '=')
    public void minusTest(String data, int expectResult) {
        int calcResult = Calculator.calculate(data);
        assertThat(calcResult).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 3 = 6", "4 * 2 = 8"}, delimiter = '=')
    public void multiplicationTest(String data, int expectResult) {
        int calcResult = Calculator.calculate(data);
        assertThat(calcResult).isEqualTo(expectResult);
    }


}