package racingcar.view;

import java.util.Scanner;

public class Input {


    public CarNames getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            return inputCarNamesString();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getCarNames();
        }
    }

    public int getRacingGameCount() {
        System.out.println("시도할 횟수는 몇회인가요?");

        try {
            return inputGameCountString();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getRacingGameCount();
        }
    }

    private CarNames inputCarNamesString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무 이름도 입력하지 않으셨습니다. 다시 입력해주세요.");
        }

        return CarNames.createCarNamesFromCarNamesString(input);
    }

    private int inputGameCountString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            checkInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getRacingGameCount();
        }
    }

    private void checkInput(String input) {
        validateInputIsNotEmpty(input);
        validateInputIsNumber(input);
        validateInputNumberIsNotNegative(input);
    }

    private void validateInputIsNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 공란이 있습니다. 다시 입력하세요.");
        }
    }

    private void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 포함되었습니다. 다시 입력하세요.");
        }
    }

    private void validateInputNumberIsNotNegative(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 음수를 입력하셨습니다. 다시 입력하세요.");
        }
    }
}
