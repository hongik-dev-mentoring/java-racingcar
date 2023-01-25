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
        Integer result = Arrays.stream(tokens)
                .map(s -> Integer.parseInt(s.trim()))
                .reduce(0, (a, b) -> a + b);

        return result;
    }

    private boolean isInputOneNumberString(String input) {
        String[] tokens = splitInputString(input);
        return tokens.length == 1;
    }

    public String[] splitInputString(String input) {
        return input.trim().split(",|:");
    }

    private boolean isInputNullOrEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }
}
