package racingcar.domain;

public class Position {
	private static final String POSITION_NEGATIVE_MESSAGE = "자동차의 위치는 음수일 수 없습니다.";
	private static final int POSITION_IS_NOT_NEGATIVE = 0;
	private int position = 0;

	public Position(int position) {
		this.position = position;
		validatePositionRange(position);
	}

	private void validatePositionRange(int position) {
		if (position < POSITION_IS_NOT_NEGATIVE) {
			throw new IllegalArgumentException(POSITION_NEGATIVE_MESSAGE);
		}
	}

	public void moveCarForward() {
		this.position++;
	}

	public int getValue() {
		return position;
	}
}
