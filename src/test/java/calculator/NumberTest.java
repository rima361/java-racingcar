package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    @DisplayName("문자열에서 숫자만 추출한다.")
    public void test_extract_number() {
        assertThat(Number.extractNumber("2 + 3 * 4 / 2")).containsExactly(new Number(2L), new Number(3L), new Number(4L), new Number(2L));
    }

}