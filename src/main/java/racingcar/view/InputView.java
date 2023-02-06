package racingcar.view;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private static ArrayList<String> strings = new ArrayList<>();
    private static int TRY_NUM;

    public static ArrayList<String> readNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        validateNames(sc);
        return strings;
    }

    public static int readNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");

        validateTryNum(sc);
        return TRY_NUM;
    }

    private static void validateTryNum(Scanner sc) {
        try {
            String input = sc.nextLine();
            RacingCarInputException.handleEmpty(input);
            RacingCarInputException.handleNull(input);
            TRY_NUM = RacingCarInputException.handleNum(input);
            RacingCarInputException.handlePositive(TRY_NUM);
        } catch (Exception e) {
            System.out.println("1이상의 숫자를 입력하세요.");
            validateTryNum(sc);
        }
    }

    private static void validateNames(Scanner sc) {
        try {
            String input = sc.nextLine();
            RacingCarInputException.handleNull(input);
            RacingCarInputException.handleEmpty(input);
            RacingCarInputException.checkValidation(strings, input.split(","));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validateNames(sc);
        }
    }
}
