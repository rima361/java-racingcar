package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import calculator.view.CalculateInfo;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 / 2:10", "2 / 3 + 4:4" }, delimiter = ':')
    public void test_string_calculate(final String given, final Long result) {
        assertThat(StringCalculator.calculate(CalculateInfo.of(given))).isEqualTo(new Number(result));
    }

}