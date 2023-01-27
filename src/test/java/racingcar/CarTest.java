package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

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
}
