package racingcar.util.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
	private static final int RANDOM_BOUND = 10;
	private static final Random random;

	static {
		random = new Random();
		random.setSeed(System.currentTimeMillis());
	}

	@Override
	public int generate() {
		return random.nextInt(RANDOM_BOUND);
	}
}
