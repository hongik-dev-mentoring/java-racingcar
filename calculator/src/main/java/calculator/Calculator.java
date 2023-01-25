package calculator;

public class Calculator {
    public int splitAndSum(String input) {
        if (isInputNullOrEmpty(input)) {
            return 0;
        }
        return 1;
    }

    private static boolean isInputNullOrEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }
}
