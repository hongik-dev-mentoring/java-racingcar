package racingcar;

import racingcar.model.Race;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();
        race.start();
        race.printWinners();
    }
}
