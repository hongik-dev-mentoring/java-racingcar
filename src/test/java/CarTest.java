import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class CarTest {

	Car car;

	@BeforeEach
	void setup(){
		car = new Car("tae");
	}

	@Test
	@DisplayName("랜덤 넘버가 4이상일 때 차 움직이기")
	void move() {

		boolean isMove = car.move(4);

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("랜덤 넘버가 4이상일 때 차 움직이기")
	void notMove() {

		boolean isMove = car.move(3);

		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("winNum 1 올리기")
	void increaseWinNum() {

		car.increaseWinNum();

		assertThat(car.getWinNum()).isEqualTo(1);
	}
}
