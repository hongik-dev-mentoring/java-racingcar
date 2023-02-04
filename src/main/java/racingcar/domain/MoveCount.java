package racingcar.domain;

public class MoveCount {
    private static final String INPUT_IS_NOT_NUMBER = "이동횟수는 숫자만 입력할 수 있습니다.";
    private static final String INPUT_IS_UNDER_ONE = "이동횟수는 1 이상의 숫자만 가능합니다.";
    private static final Integer INPUT_NUMBER_MIN_LIMIT = 1;

    private final Integer moveCount;

    public MoveCount(String input) {
        validateMoveCountInputProcess(input);
        moveCount = Integer.parseInt(input);
    }

    private void validateMoveCountInputProcess(String input) {
        checkInputIsNumber(input);
        checkInputIsGreaterThanZero(input);
    }

    private void checkInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    private void checkInputIsGreaterThanZero(String input) {
        if (!(Integer.parseInt(input) >= INPUT_NUMBER_MIN_LIMIT)) {
            throw new IllegalArgumentException(INPUT_IS_UNDER_ONE);
        }
    }

    public Integer getNumber() {
        return this.moveCount;
    }
}
