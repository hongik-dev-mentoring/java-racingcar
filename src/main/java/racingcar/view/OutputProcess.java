package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarList;

import java.util.List;
import java.util.stream.Collectors;

public class OutputProcess {
    private static final String COLON = " : ";
    private static final String ONE_MOVE_MARK = "-";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String COMMA_IN_RESULT_TEXT = ", ";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void printCarPositions(CarList carList) {
        for (Car car : carList.getCars()) {
            printCarPosition(car);
        }
    }

    private static void printCarPosition(Car car) {
        StringBuilder sb = new StringBuilder(car.getName());
        sb.append(COLON);
        sb.append(ONE_MOVE_MARK.repeat(car.getPosition()));
        System.out.println(sb);
    }

    public static void printFinalResult(CarList winners) {
        List<String> winnerNames = winners.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println(String.join(COMMA_IN_RESULT_TEXT, winnerNames) + WINNER_TEXT);
    }
}
