package racingcar.message;

public enum ErrorMessage {
    NOT_PROPER_NAME_LENGTH("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    DUPLICATED_NAMES("중복된 자동차 이름이 존재합니다."),
    INPUT_IS_NOT_NUMBER("이동횟수는 숫자만 입력할 수 있습니다."),
    INPUT_IS_NOT_ALLOWED_UNDER_ONE("이동횟수는 1 이상의 숫자만 가능합니다."),
    NOT_ENOUGH_CARS("경주에 참가하는 자동차가 한대 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + this.message;
    }
}
