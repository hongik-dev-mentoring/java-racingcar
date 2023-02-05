package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import racingcar.domain.movingstrategy.RangedRandomNumberPicker;

public class RangedRandomNumberPickerTest {

    int form = 0;
    int to = 9;

    @RepeatedTest(100)

    void 범위내의_무작위_숫자를_뽑을_수_있다() {
        // given
        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(form, to);

        // when
        int result = randomNumberPicker.pickRandomNumber();

        // then
        assertThat(result).isGreaterThanOrEqualTo(form).isLessThanOrEqualTo(to);
    }
}
