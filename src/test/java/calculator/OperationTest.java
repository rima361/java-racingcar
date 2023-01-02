package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperationTest {

    @Test
    @DisplayName("문자열에서 사칙연산 기호를 추출한다.")
    public void test_extract_number() {
        assertThat(Operation.extractOperation("2 + 3 * 4 / 2")).containsExactly(Operation.PLUS, Operation.MULTIPLY, Operation.DIVIDE);
    }

}