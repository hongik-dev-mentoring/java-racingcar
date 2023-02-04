package racingcar.util.generator;

public class ForwardNumberGenerator implements NumberGenerator {
	private static final int CAN_MOVE_FORWARD = 5;

	@Override
	public int generate() {
		return CAN_MOVE_FORWARD;
	}
}
