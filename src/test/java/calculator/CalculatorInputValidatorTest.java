package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import calculator.view.CalculatorInputValidator;

class CalculatorInputValidatorTest {

    @DisplayName(" null, 빈 공백이거나 사칙연산 기호가 아닌지 확인한다")
    @ParameterizedTest
    @CsvSource(value = { ":false", "null:false", "1 ; 1:false", "2 + 2:true", " :false"}, delimiter = ':')
    public void test_valid_input(final String given, final boolean expected) {
        Assertions.assertThat(new CalculatorInputValidator(given).isValid()).isEqualTo(expected);
    }

}