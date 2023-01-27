package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	private Car car;

	@BeforeEach
	void initiateCar() {
		car = new Car("chan");
	}

	@Test
	@DisplayName("자동차 생성 테스트")
	void create_car() {
		assertThat(car).isNotNull();
	}

	@Test
	@DisplayName("자동차 이름 검증 테스트")
	void validate_car_name() {
		assertThat(car.getName()).isEqualTo("chan");
	}

	@Test
	@DisplayName("자동차의 초기 위치는 0이어야 한다.")
	void first_position_car_equals_zero() {
		assertThat(car.getPosition()).isEqualTo(0);
	}
	
}
