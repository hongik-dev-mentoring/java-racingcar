package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.util.generator.ForwardNumberGenerator;
import racingcar.util.generator.StopNumberGenerator;

class CarTest {
	private Car car;

	@BeforeEach
	void initialize() {
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

	@ParameterizedTest(name = "랜덤 숫자 : {0}, 전진 결과 : {1}")
	@CsvSource({"4, true", "3, false"})
	@DisplayName("랜덤값이 4 이상이면 전진한다.")
	void move_forward_if_random_number_greater_than_four(int randomNumber, boolean canMove) {
		assertThat(car.shouldMove(randomNumber)).isEqualTo(canMove);
	}

	@Test
	@DisplayName("자동차 정지하면 위치는 그대로이다.")
	void not_move_forward_car() {
		car.moveForward(new StopNumberGenerator());
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("자동차를 전진하면 위치는 1 증가한다.")
	void move_forward_car() {
		car.moveForward(new ForwardNumberGenerator());

		assertThat(car.getPosition()).isEqualTo(1);
	}
}
