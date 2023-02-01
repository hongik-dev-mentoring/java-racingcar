package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberPickerTest {
    @Test
    @DisplayName("난수 생성 테스트")
    public void randomNumberPickerTest() {
        // given
        RandomNumberPicker randomNumberPicker = new RandomNumberPicker(9, 9);
        // when
        Integer randomNumber = randomNumberPicker.pickRandomNumber();
        // then
        Assertions.assertThat(randomNumber).isEqualTo(9);
    }
}
