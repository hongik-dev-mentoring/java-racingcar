package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final static String BLANK = " ";
    private final static String DEFAULT_DELIMITER_PATTERN = ",|:";
    private final static String NON_DIGIT_CHARACTER_PATTERN = "[\\D]";
    private final static String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern COMPILED_CUSTOM_SPLIT_REGEX =
            Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    private static final String CANNOT_CALCULATE_NEGATIVE_NUMBER = "음수는 계산할 수 없습니다.";
    private static final String SHOULD_BE_SEPARATED_BY_DELIMITER = "지정된 커스텀 구분자로 숫자를 구분해야 합니다.";

    private final static Integer RESULT_OF_EMPTY_INPUT = 0;
    private final static Integer INITIAL_VALUE_OF_SUM = 0;
    private final static Integer ZERO_INPUT_NUMBER = 0;
    private final static Integer FIRST_INDEX_OF_SPLIT_RESULT = 0;
    private final static Integer ONE_INPUT_NUMBER = 1;
    private final static Integer CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private final static Integer CUSTOM_INPUT_NUMBER_GROUP_INDEX = 2;

    public int splitAndSum(String input) {
        if (isInputNullOrEmpty(input)) {
            return RESULT_OF_EMPTY_INPUT;
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
        return input.matches(CUSTOM_DELIMITER_PATTERN);
    }

    private int calculateWithCustomDelimiter(String input) {
        checkTokensAreInvalid(input);
        String stringNumbers = input.replaceAll(NON_DIGIT_CHARACTER_PATTERN, BLANK)
                .trim();
        String[] tokens = stringNumbers.split(BLANK);
        return calculateSum(tokens);
    }

    private void checkTokensAreInvalid(String input) {
        try {
            splitCustomInputAndParseToInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SHOULD_BE_SEPARATED_BY_DELIMITER);
        }
    }

    private void splitCustomInputAndParseToInt(String input) {
        Matcher customInputMatcher = COMPILED_CUSTOM_SPLIT_REGEX.matcher(input);
        if (customInputMatcher.find()) {
            String customDelimiter = customInputMatcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
            String[] tokens = customInputMatcher.group(CUSTOM_INPUT_NUMBER_GROUP_INDEX)
                    .split(customDelimiter);
            Arrays.stream(tokens)
                    .forEach(token -> Integer.parseInt(token.trim()));
        }
    }

    private Integer calculateSum(String[] tokens) {
        return Arrays.stream(tokens)
                .map(token -> Integer.parseInt(token.trim()))
                .reduce(INITIAL_VALUE_OF_SUM, Integer::sum);
    }

    private boolean isInputOneNumberString(String input) {
        String[] tokens = splitInputString(input);
        return tokens.length == ONE_INPUT_NUMBER;
    }

    private String[] splitInputString(String input) {
        return input.trim().split(DEFAULT_DELIMITER_PATTERN);
    }

    private int calculateOneNumberInputString(String input) {
        String result = splitInputString(input)[FIRST_INDEX_OF_SPLIT_RESULT];
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
        if (number < ZERO_INPUT_NUMBER) {
            throw new RuntimeException(CANNOT_CALCULATE_NEGATIVE_NUMBER);
        }
    }

}
