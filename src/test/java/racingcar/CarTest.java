package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	@Test
	@DisplayName("자동차 생성 테스트")
	void create_car() {
		Car car = new Car("chan");
		assertThat(car).isNotNull();
	}

	@Test
	@DisplayName("자동차 이름 검증 테스트")
	void validate_car_name() {
		Car car = new Car("chan");
		assertThat(car.getName()).isEqualTo("chan");
	}
}
