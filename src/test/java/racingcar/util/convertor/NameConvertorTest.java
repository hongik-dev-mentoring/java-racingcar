package racingcar.util.convertor;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameConvertorTest {
	@Test
	@DisplayName("자동차 이름 생성에 성공")
	void create_name_success() {
		assertThat(NameConvertor.convertCarNames("chan,dong,ho"))
			.contains("chan", "dong", "ho");
	}
}
