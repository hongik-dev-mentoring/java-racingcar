package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberGeneratorTest {
    @DisplayName("난수 생성 테스트")
    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    public void randomNumberPickerTest() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(4, 9);
        // when
        Integer randomNumber = randomNumberGenerator.generate();
        // then
        Assertions.assertThat(randomNumber).isGreaterThan(3);
    }
}
