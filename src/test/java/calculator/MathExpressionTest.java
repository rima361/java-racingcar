package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.view.MathExpression;

class MathExpressionTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "2 + 3 ; 4 / 2", "+ * / 2 3 4 2", "+ * / * + 2 3 4 2" })
    @DisplayName("입력값이 null, 빈 공백, 사칙연산 기호가 아닌 경우, 연산자 순서가 올바르지 않은 경우 IllegalArgumentException 예외가 발생한다.")
    public void test_null_or_empty(final String given) {
        assertThatThrownBy(() -> MathExpression.of(given)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값에서 숫자와 사칙 연산 기호를 분류한다.")
    public void test_calculate_info() {
        final MathExpression given = MathExpression.of("2 + 3 * 4 / 2");
        assertThat(given.getNumbers()).containsExactly(new Number(2L), new Number(3L), new Number(4L), new Number(2L));
        assertThat(given.getOperations()).containsExactly(Operation.PLUS, Operation.MULTIPLY, Operation.DIVIDE);
    }
}