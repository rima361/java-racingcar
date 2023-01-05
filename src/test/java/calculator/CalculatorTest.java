package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    @DisplayName("사칙연산의 결과를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = { "+:8", "*:12", "/:3", "-:4" }, delimiter = ':')
    public void test_calculate(final String operator, final Long expected) {
        assertThat(Operation.of(operator).calculate(new Number(6L), new Number(2L)))
                .isEqualTo(new Number(expected));
    }

}