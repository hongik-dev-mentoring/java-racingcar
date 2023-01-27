package racingcar.util.generator;

public class RandomNumberGenerator {
	public static int generateRandomNumber() {
		double num = Math.random();
		return (int)(num * 10);
	}
}
