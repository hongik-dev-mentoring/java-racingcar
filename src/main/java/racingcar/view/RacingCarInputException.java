package racingcar.view;

import java.util.ArrayList;

public class RacingCarInputException {
	private static final int MAX_LENGTH = 5;

	public static void isEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("이름을 입력해주세요.");
		}
	}

	public static void isNull(String input) {
		if (input == null) {
			throw new IllegalArgumentException("다시 입력해주세요.");
		}
	}

	public static void checkValidation(ArrayList<String> strings, String[] input) {
		for (String s : input) {
			isLessThanFiveLetters(s);
			isDuplicatedName(strings, s);
			isDelimiterInName(s);
			strings.add(s);
		}
	}

	private static void isDelimiterInName(String s) {
		if(s.contains(",")){
			throw new IllegalArgumentException("이름 사이에는 ,가 들어갈 수 없습니다.");
		}
	}

	private static void isLessThanFiveLetters(String s) {
		if (s.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("5이하의 문자열을 입력하세요.");
		}
	}

	private static void isDuplicatedName(ArrayList<String> strings, String s) {
		if(strings.contains(s)){
			throw new IllegalArgumentException("중복된 이름입니다. 다른이름을 입력하세요.");
		}
	}

	public static void isPositive(int num) {
		if (num < 0) {
			throw new IllegalArgumentException("1회 이상의 수를 입력하세요.");
		}
	}
}
