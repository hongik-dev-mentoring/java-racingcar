package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final String customDelimiterPattern = "//(.)\n(.*)";
    private final String defaultDelimiterPattern = ",|:";

    public int splitAndSum(String input) {
        if (isInputNullOrEmpty(input)) {
            return 0;
        }
        if (CustomSeparatorExists(input)) {
            return calculateWithCustomDelimiter(input);
        }
        if (isInputOneNumberString(input)) {
            return calcuateOneNumberInputString(input);
        }
        return calculateWithDefaultSeparator(input);
    }

    private int calcuateOneNumberInputString(String input) {
        String result = splitInputString(input)[0];
        return Integer.parseInt(result);
    }

    private int calculateWithCustomDelimiter(String input) {
        Matcher m = Pattern.compile(customDelimiterPattern).matcher(input);
        String[] tokens = new String[0];
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
        checkTokensAreInvalid(tokens);
        return calculateSum(tokens);
    }

    private void checkTokensAreInvalid(String[] tokens) {
        try {
            Arrays.stream(tokens).map(s -> Integer.parseInt(s.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지정된 커스텀 구분자로 숫자를 구분해야 합니다.");
        }
    }

    private int calculateWithDefaultSeparator(String input) {
        String[] tokens = splitInputString(input);
        checkNegativeNumberNotExists(tokens);
        return calculateSum(tokens);
    }

    public boolean CustomSeparatorExists(String input) {
        return input.matches(customDelimiterPattern);
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

    private Integer calculateSum(String[] tokens) {
        return Arrays.stream(tokens)
                .map(s -> Integer.parseInt(s.trim()))
                .reduce(0, (a, b) -> a + b);
    }

    private boolean isInputOneNumberString(String input) {
        String[] tokens = splitInputString(input);
        return tokens.length == 1;
    }

    private String[] splitInputString(String input) {
        return input.trim().split(defaultDelimiterPattern);
    }

    private boolean isInputNullOrEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }
}
