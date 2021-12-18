package nextstep.ladder.step4.domain.ladder;

import static java.lang.Boolean.FALSE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"false,true", "true,false", "false,false"})
    @DisplayName("생성 성공")
    void create(boolean left, boolean right) {
        assertThat(Direction.first(left).next(right)).isEqualTo(Direction.first(left).next(right));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("last 테스트")
    void last(boolean left) {
        assertThat(Direction.first(left).last()).isEqualTo(Direction.first(left).next(FALSE));
    }

}
