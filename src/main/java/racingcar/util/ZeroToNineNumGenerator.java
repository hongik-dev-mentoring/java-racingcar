package racingcar.util;

public class RandomNum implements Random {
	private static final int ZERO_TO_NINE_CONVERTER = 10;

	public int generateNum() {
		return (int)(Math.random() * ZERO_TO_NINE_CONVERTER);
	}
}
