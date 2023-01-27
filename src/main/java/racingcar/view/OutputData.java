package racingcar.view;

public class OutputData {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String GAME_RESULT_HEADER = "실행 결과";
	private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

	public static void printErrorMessage(String message) {
		System.out.println(ERROR_MESSAGE + message);
	}

	public static void printGameResultHeader() {
		System.out.println(GAME_RESULT_HEADER);
	}

	public static void printBlankLine() {
		System.out.println();
	}
}
