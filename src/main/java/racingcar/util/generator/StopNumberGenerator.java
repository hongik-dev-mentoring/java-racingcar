package racingcar.util.generator;

public class StopNumberGenerator implements NumberGenerator {
	private static final int NOT_MOVE_FORWARD = 0;

	@Override
	public int generate() {
		return NOT_MOVE_FORWARD;
	}
}
