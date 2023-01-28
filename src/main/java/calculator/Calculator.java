package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String customDelimiterPattern = "//(.)\n(.*)";
    private static final String defaultDelimiterPattern = ",|:";

    private static final Pattern COMPILED_CUSTOM_SPLIT_REGEX = Pattern.compile(customDelimiterPattern);

    public int splitAndSum(String input) {
        if (isInputNullOrEmpty(input)) {
            return 0;
        }
        if (customSeparatorExists(input)) {
            return calculateWithCustomDelimiter(input);
        }
        if (isInputOneNumberString(input)) {
            return calculateOneNumberInputString(input);
        }
        return calculateWithDefaultSeparator(input);
    }

    private boolean isInputNullOrEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }

    private boolean customSeparatorExists(String input) {
        return input.matches(customDelimiterPattern);
    }

    private int calculateWithCustomDelimiter(String input) {
        checkTokensAreInvalid(input);
        String s = input.replaceAll("[\\D]", " ")
                .trim();
        String[] tokens = s.split(" ");
        return calculateSum(tokens);
    }

    private void checkTokensAreInvalid(String input) {
        try {
            splitCustomInputAndParseToInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지정된 커스텀 구분자로 숫자를 구분해야 합니다.");
        }
    }

    private void splitCustomInputAndParseToInt(String input) {
        Matcher m = COMPILED_CUSTOM_SPLIT_REGEX.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2)
                    .split(customDelimiter);
            Arrays.stream(tokens).forEach(token -> {
                Integer.parseInt(token.trim());
            });
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

    private int calculateOneNumberInputString(String input) {
        String result = splitInputString(input)[0];
        return Integer.parseInt(result);
    }

    private int calculateWithDefaultSeparator(String input) {
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

}
