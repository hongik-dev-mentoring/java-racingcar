package racingcar.message;

public enum ConsoleMessage {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)."),
    INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
