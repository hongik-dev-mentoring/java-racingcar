package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.InputProcess;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    private static final String COMMA_IN_RESULT_TEXT = ", ";
    private static final String RESULT_TEXT = "실행 결과";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";

    private Race race;

    public RaceController() {
        executeInputProcess();
    }

    private void executeInputProcess() {
        InputProcess inputProcess = new InputProcess();
        List<Car> cars = inputProcess.getCarList();
        Integer moveCount = inputProcess.getMoveCount();
        race = new Race(cars, moveCount);
    }

    public void startRace() {
        System.out.println(RESULT_TEXT);
        race.proceedWholeRound();
    }

    public void printWinners() {
        List<Car> winners = race.selectWinners();
        createFinalResultText(winners);
    }

    private void createFinalResultText(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println(String.join(COMMA_IN_RESULT_TEXT, winnerNames) + WINNER_TEXT);
    }
}
