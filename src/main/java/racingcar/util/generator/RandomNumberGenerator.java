package racingcar.util.generator;

public class RandomNumberGenerator {
	private static final int MULTIPLY_NUMBER = 10;

	public static int generateRandomNumber() {
		double num = Math.random();
		return (int)(num * MULTIPLY_NUMBER);
	}
}
