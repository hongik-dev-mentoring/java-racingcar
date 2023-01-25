package calculator;

public class Calculator {
    public int splitAndSum(String input) {
        if (isInputNullOrEmpty(input)) {
            return 0;
        }
        if (isInputOneNumberString(input)) {
            String result = splitInputString(input)[0];
            return Integer.parseInt(result);
        }
        return 1;
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
