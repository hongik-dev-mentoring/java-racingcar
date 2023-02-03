package racingcar.domain;

import java.util.List;
import racingcar.domain.movingstrategy.MovingStrategy;

public class Racing {

    private final Cars cars;
    private int gameCount;

    public Racing(Cars cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void race(MovingStrategy movingStrategy) {
        System.out.println("실행 결과");
        while (isLeftRacing()) {
            gameCount--;
            cars.raceAllCar(movingStrategy);
            cars.printCurrentRaceResult();
        }
        printWinner();
    }

    private boolean isLeftRacing() {
        return gameCount > 0;
    }

    private void printWinner() {
        int leadCarPosition = cars.getLeadCarPosition();
        String winnerString = buildWinnerString(leadCarPosition).toString();
        System.out.println(winnerString);
    }

    private StringBuilder buildWinnerString(int leadCarPosition) {
        List<String> winners = cars.getCarsByPosition(leadCarPosition);

        return new StringBuilder("최종 우승자 : ")
            .append(String.join(", ", winners));
    }
}
