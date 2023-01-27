package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
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

	@Test
	void 랜덤값이_4이상일경우_전진한다() {
		assertThat(car.shouldMove(4)).isTrue();
		assertThat(car.shouldMove(3)).isFalse();
	}

	@Test
	@DisplayName("자동차가 전진하지 못하면 위치는 그대로이다.")
	void not_move_forward_car() {
		car.moveForward(3);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("자동차를 전진시키면 위치가 1 증가해야 한다.")
	void move_forward_car() {
		car.moveForward(4);
		assertThat(car.getPosition()).isEqualTo(1);
	}
}
