package racingcar.util.generator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameGeneratorTest {
	@Test
	@DisplayName("자동차 이름 생성에 성공")
	void create_name_success() {
		assertThat(NameGenerator.generateCarNames("chan,dong,ho"))
			.contains("chan", "dong", "ho");
	}

}
