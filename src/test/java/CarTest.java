import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("차 객체 생성")
	void createCar(){
		Car car = new Car("tae");

		assertAll(
			()->assertThat(car.getName()).isEqualTo("tae"),
			()->assertThat(car.getPosition()).isEqualTo(0)
		);

	}

	@Test
	@DisplayName("랜덤 수 생성")
	void createRandomNum(){
		Car car = new Car("tae");

		int num = car.createRandomNum();

		assertAll(
			()->assertThat(num).isGreaterThanOrEqualTo(0),
			()->assertThat(num).isLessThanOrEqualTo(9)
		);
	}

	@Test
	@DisplayName("차 움직이기")
	void moveOrNot(){
		Car car = new Car("tae");

		boolean isMove = car.move();

		assertAll(
			()->assumingThat(isMove == true, ()->assertThat(car.getPosition()).isEqualTo(1)),
			()->assumingThat(isMove == false, ()->assertThat(car.getPosition()).isEqualTo(0))
		);
	}


}