package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<RandomMovingCar> cars;
    private final StringBuilder winnerString = new StringBuilder("최종 우승자 : ");
    private final StringBuilder currentCarPositionString = new StringBuilder();
    private int gameCount;

    public Racing(List<RandomMovingCar> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void race() {
        System.out.println("실행 결과");
        while (isLeftRacing()) {
            gameCount--;
            raceAllCar();
            printCurrentRaceResult();
        }
        printWinner();
    }

    private boolean isLeftRacing() {
        return gameCount > 0;
    }

    private void raceAllCar() {
        cars.forEach(RandomMovingCar::race);
    }

    private void printCurrentRaceResult() {
        cars.forEach(
            randomMovingCar -> System.out.println(buildCurrentPositionString(randomMovingCar)));
        System.out.println();
    }

    private int getLeadCarPosition() {
        RandomMovingCar leadRandomMovingCar = cars.stream()
            .max(Comparator.comparing(RandomMovingCar::getPosition))
            .get();
        return leadRandomMovingCar.getPosition();
    }

    private void printWinner() {
        int leadCarPosition = getLeadCarPosition();
        buildWinnerString(leadCarPosition);
        System.out.println(winnerString);
    }

    private void buildWinnerString(int leadCarPosition) {
        List<String> winners = cars.stream()
            .filter(randomMovingCar -> randomMovingCar.getPosition() == leadCarPosition)
            .map(RandomMovingCar::getName)
            .collect(Collectors.toList());

        String winnerNamesString = String.join(", ", winners);
        winnerString.append(winnerNamesString);
    }

    private StringBuilder buildCurrentPositionString(RandomMovingCar randomMovingCar) {
        currentCarPositionString.setLength(0);
        currentCarPositionString
            .append(randomMovingCar.getName())
            .append(" : ")
            .append("-".repeat(randomMovingCar.getPosition()));

        return currentCarPositionString;
    }
}
