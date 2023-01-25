package calculator;

import java.util.Arrays;

public class Calculator {
    public int splitAndSum(String input) {
        if (isInputNullOrEmpty(input)) {
            return 0;
        }
        if (isInputOneNumberString(input)) {
            String result = splitInputString(input)[0];
            return Integer.parseInt(result);
        }
        String[] tokens = splitInputString(input);
        checkNegativeNumberNotExists(tokens);
        return calculateSum(tokens);
    }

    private void checkNegativeNumberNotExists(String[] tokens) {
        Arrays.stream(tokens).forEach(s -> {
            int number = Integer.parseInt(s.trim());
            checkIfNumberIsNegative(number);
        });
    }

    private void checkIfNumberIsNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 계산할 수 없습니다.");
        }
    }

    private static Integer calculateSum(String[] tokens) {
        return Arrays.stream(tokens)
                .map(s -> Integer.parseInt(s.trim()))
                .reduce(0, (a, b) -> a + b);
    }

    private boolean isInputOneNumberString(String input) {
        String[] tokens = splitInputString(input);
        return tokens.length == 1;
    }

    private String[] splitInputString(String input) {
        return input.trim().split(",|:");
    }

    private boolean isInputNullOrEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }
}
