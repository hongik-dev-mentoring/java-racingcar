package racingcar.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameGeneratorTest {
	@Test
	@DisplayName("자동차 이름 생성에 성공")
	void create_name_success() {
		List<String> cars = NameGenerator.generateCarNames("chan, dong, ho");
		assertThat(cars.size()).isEqualTo(3);
	}
	
}
