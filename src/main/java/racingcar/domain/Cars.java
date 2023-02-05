package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return cars;
    }

    public int getLeadCarPosition() {
        Car leadCar = cars.stream()
            .max(Comparator.comparing(Car::getPosition))
            .get();
        return leadCar.getPosition();
    }

    public List<String> getCarsByPosition(int position) {
        return cars.stream()
            .filter(car -> car.getPosition() == position)
            .map(Car::getName)
            .collect(Collectors.toList());
    }


    public void printRacingGameWinner() {
        int leadCarPosition = getLeadCarPosition();
        String winnerString = buildWinnerString(leadCarPosition).toString();
        System.out.println(winnerString);
    }

    private StringBuilder buildWinnerString(int leadCarPosition) {
        List<String> winners = getCarsByPosition(leadCarPosition);

        return new StringBuilder("최종 우승자 : ")
            .append(String.join(", ", winners));
    }
}
