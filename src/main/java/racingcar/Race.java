package racingcar;

import racingcar.input.InputProcess;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.message.ConsoleMessage.RESULT_TEXT;
import static racingcar.message.ConsoleMessage.WINNER_TEXT;
import static racingcar.message.Constant.COMMA_IN_RESULT_TEXT;

public class Race {

    private List<Car> cars;

    private Integer moveCount;

    private List<Car> winners;

    public void start() {
        startInputProcess();
        System.out.println(RESULT_TEXT);
        for (int i = 0; i < moveCount; i++) {
            proceedOneRound();
            System.out.println();
        }
    }

    private void startInputProcess() {
        InputProcess input = new InputProcess();
        this.cars = input.getCarList();
        this.moveCount = input.getMoveCount();
    }

    private void proceedOneRound() {
        this.moveCars();
        this.printCarPositions();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printCarPositions() {
        for (Car car : cars) {
            car.printPosition();
        }
    }

    public void printWinners() {
        winners = selectWinners(cars);
        createFinalResultText();
    }

    private List<Car> selectWinners(List<Car> cars) {
        Integer maxPosition = getMaxPosition(cars);
        return getCarsAtPosition(cars, maxPosition);
    }

    private static Integer getMaxPosition(List<Car> cars) {
        Integer maxPosition = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get().getPosition();
        return maxPosition;
    }

    private static List<Car> getCarsAtPosition(List<Car> cars, Integer maxPosition) {
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .collect(Collectors.toList());
        return winners;
    }

    private void createFinalResultText() {
        StringBuilder sb = new StringBuilder();
        for (Car winner : winners) {
            sb.append(winner.getName());
            sb.append(COMMA_IN_RESULT_TEXT);
        }
        deleteLastCommaFromResult(sb);
        sb.append(WINNER_TEXT);
        System.out.println(sb);
    }

    private static void deleteLastCommaFromResult(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
