package racingcar.view;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
	private static ArrayList<String> strings = new ArrayList<>();
	private static int TRY_NUM;

	public static ArrayList<String> readNames() {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

		stringInputProcess(sc);
		return strings;
	}

	public static int readNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("시도할 회수는 몇회인가요?");

		intInputProcess(sc);
		return TRY_NUM;
	}

	private static void intInputProcess(Scanner sc) {
		try {
			String input = sc.nextLine();
			RacingCarInputException.isEmpty(input);
			RacingCarInputException.isNull(input);
			TRY_NUM = RacingCarInputException.isNum(input);
			RacingCarInputException.isPositive(TRY_NUM);
		} catch (Exception e) {
			System.out.println("1이상의 숫자를 입력하세요.");
			intInputProcess(sc);
		}
	}

	private static void stringInputProcess(Scanner sc) {
		try {
			String input = sc.nextLine();
			RacingCarInputException.isNull(input);
			RacingCarInputException.isEmpty(input);
			RacingCarInputException.checkValidation(strings, input.split(","));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			stringInputProcess(sc);
		}
	}
}
