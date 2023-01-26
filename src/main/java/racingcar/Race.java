package racingcar;

import racingcar.input.InputProcess;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final InputProcess input = new InputProcess();

    private List<Car> cars;

    private Integer moveCount;

    private List<Car> winners;

    public void startInputProcess() {
        this.cars = input.getCarList();
        this.moveCount = input.getMoveCount();
    }

    public void start() {
        startInputProcess();
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            this.proceed();
            this.print();
            System.out.println();
        }
    }

    public void proceed() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void print() {
        for (Car car : cars) {
            car.printPosition();
        }
    }

    public List<Car> selectWinners(List<Car> cars) {
        Integer maxPosition = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get().getPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .collect(Collectors.toList());
        return winners;
    }

    public void printWinners() {
        winners = selectWinners(cars);
        StringBuilder sb = new StringBuilder();
        for (Car winner : winners) {
            sb.append(winner.getName());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
