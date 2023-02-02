package racingcar.view;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
	private static ArrayList<String> strings = new ArrayList<>();
	private static int TRY_NUM;

	public static ArrayList<String> readNames() {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		while (true) {
			String input = sc.nextLine();
			if (isNoExceptionAtStrings(input)) {
				break;
			}
		}
		return strings;
	}

	public static int readNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("시도할 회수는 몇회인가요?");
		while (true) {
			String input = sc.nextLine();
			if (isNoExceptionAtNum(input)) {
				break;
			}
		}
		return TRY_NUM;
	}

	private static boolean isNoExceptionAtNum(String input) {
		try {
			RacingCarInputException.isEmpty(input);
			RacingCarInputException.isNull(input);
			TRY_NUM = Integer.parseInt(input);
			RacingCarInputException.isPositive(TRY_NUM);
			return true;
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
			return false;
		}
	}

	private static boolean isNoExceptionAtStrings(String input) {
		try {
			RacingCarInputException.isNull(input);
			RacingCarInputException.isEmpty(input);
			RacingCarInputException.checkValidation(strings, input.split(","));
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
