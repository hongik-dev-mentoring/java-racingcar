package racingcar.util.validator;

public class NameValidatorTest {

	// @Test
	// @DisplayName("자동차 이름은 Null일 수 없다.")
	// void car_name_should_not_be_null() {
	// 	assertThatThrownBy(() -> validateCarNames(null))
	// 		.isInstanceOf(IllegalArgumentException.class)
	// 		.hasMessageContaining(CAR_NAME_NOT_EXIST_MESSAGE);
	// }
	//
	// @Test
	// @DisplayName("자동차 이름은 비어있을 수 없다.")
	// void car_name_should_not_be_empty() {
	// 	assertThatThrownBy(() -> validateCarNames(""))
	// 		.isInstanceOf(IllegalArgumentException.class)
	// 		.hasMessageContaining(CAR_NAME_NOT_EXIST_MESSAGE);
	// }
	//
	// @Test
	// @DisplayName("자동차 이름은 중복될 수 없다.")
	// void car_name_should_not_be_duplicate() {
	// 	assertThatThrownBy(() -> validateCarNames())
	// 		.isInstanceOf(IllegalArgumentException.class)
	// 		.hasMessageContaining(DUPLICATE_CAR_NAME_MESSAGE);
	// }
	//
	// @Test
	// @DisplayName("자동차 이름은 5자 이내여야 한다.")
	// void validate_car_name_length() {
	// 	assertThatThrownBy(() -> validateCarNames())
	// 		.isInstanceOf(IllegalArgumentException.class)
	// 		.hasMessageContaining(NAME_LENGTH_EXCEPTION_MESSAGE);
	// }
	//
	// @ParameterizedTest(name = "{index}번 자동차 이름 : {0}, 결과 : {1}")
	// @DisplayName("자동차 이름 유효성 검사")
	// @MethodSource("invalidCarNames")
	// void validate_car_name(String carName, String expectedResult) {
	// 	assertThatThrownBy(() -> new Car(carName))
	// 		.isInstanceOf(IllegalArgumentException.class);
	// }
	//
	// static Stream<Arguments> invalidCarNames() {
	// 	return Stream.of(
	// 		Arguments.of("euichan", "이름 5자 초과"),
	// 		Arguments.of("", "1글자 미만"),
	// 		Arguments.of(null, "null 입력"),
	// 		Arguments.of("chan,,dong", "이름이 0자")
	// 	);
	// }
}
