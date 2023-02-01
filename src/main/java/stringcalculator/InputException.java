package stringcalculator;

public class InputException {

	public static int getNumOrThrow(String token) {
		int num;
		try {
			num = Integer.parseInt(token);
		} catch (NumberFormatException e) {
			throw new RuntimeException("숫자를 입력하세요.");
		}
		return num;
	}

	public static void ifNegativeThenThrow(int num) {
		if (num < 0) {
			throw new RuntimeException("양수를 입력하세요.");
		}
	}
}
