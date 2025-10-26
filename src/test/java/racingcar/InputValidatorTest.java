package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    @Test
    void 자동차_이름_분리_테스트() {
        List<String> names = InputValidator.parseCarNames("pobi,woni,jun");
        
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }
    
    @Test
    void 이름_길이_초과_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.parseCarNames("polbis"))
            .isInstanceOf(IllegalArgumentException.class);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 빈_문자열_예외_테스트(String invalidName) {
        assertThatThrownBy(() -> InputValidator.parseCarNames(invalidName))
            .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 시도_횟수_파싱_테스트() {
        int count = InputValidator.parseRoundCount("5");
        
        assertThat(count).isEqualTo(5);
    }
    
    @Test
    void 시도_횟수_0_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.parseRoundCount("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 시도_횟수_음수_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.parseRoundCount("-1"))
            .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 시도_횟수_문자_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.parseRoundCount("abc"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}