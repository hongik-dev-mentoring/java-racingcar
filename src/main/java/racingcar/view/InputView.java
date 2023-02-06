package racingcar.view;

import java.util.Scanner;

public class InputView {
	private static final Scanner console = new Scanner(System.in);
	private static final String CAR_NAME_ALERT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String NUMBER_OF_ATTEMPT_ALERT_MESSAGE = "시도할 회수는 몇회인가요?";

	public static String getCarNames() {
		System.out.println(CAR_NAME_ALERT_MESSAGE);
		return console.nextLine();
	}

	public static String getAttemptNumber() {
		System.out.println(NUMBER_OF_ATTEMPT_ALERT_MESSAGE);
		return console.nextLine();
	}
}
