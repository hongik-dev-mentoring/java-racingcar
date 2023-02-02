package racingcar.util;

public class RandomNum {
	private static final int ZERO_TO_NINE_CONVERTER = 10;

	public static int createRandomNum() {
		return (int)(Math.random() * ZERO_TO_NINE_CONVERTER);
	}
}
