package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputProcess {
    private static final String COLON = " : ";
    private static final String ONE_MOVE_MARK = "-";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String COMMA_IN_RESULT_TEXT = ", ";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";

    private final List<Car> cars;

    public OutputProcess(List<Car> cars) {
        this.cars = cars;
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void printCarPositions() {
        for (Car car : cars) {
            printCarPosition(car);
        }
    }

    private void printCarPosition(Car car) {
        StringBuilder sb = new StringBuilder(car.getName());
        sb.append(COLON);
        sb.append(ONE_MOVE_MARK.repeat(car.getPosition()));
        System.out.println(sb);
    }

    public void createFinalResultText(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println(String.join(COMMA_IN_RESULT_TEXT, winnerNames) + WINNER_TEXT);
    }
}
