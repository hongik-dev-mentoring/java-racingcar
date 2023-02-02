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
	@DisplayName("winNum 1 올리기")
	void increaseWinNum() {

		car.increaseWinNum();

		assertThat(car.getWinNum()).isEqualTo(1);
	}
}
