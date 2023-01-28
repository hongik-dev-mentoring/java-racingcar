package racingcar.input;

import racingcar.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static racingcar.message.ConsoleMessage.INPUT_CAR_NAMES;
import static racingcar.message.ConsoleMessage.INPUT_MOVE_COUNT;

public class InputProcess {

    private final Scanner sc = new Scanner(System.in);

    private final Validation validation = new Validation();

    private List<Car> carList;

    private Integer moveCount;

    public List<Car> getCarList() {
        try {
            System.out.println(INPUT_CAR_NAMES);
            String input = sc.nextLine();
            validation.validateCarNameInputProcess(input);
            createCarList(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getCarList();
        }
        return carList;
    }

    private void createCarList(String input) {
        carList = Arrays.stream(input.split(","))
                .map(s -> new Car(s.trim())).collect(Collectors.toList());
    }

    public Integer getMoveCount() {
        try {
            System.out.println(INPUT_MOVE_COUNT);
            String input = sc.nextLine();
            validation.validateMoveCountInputProcess(input);
            moveCount = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getMoveCount();
        }
        return moveCount;
    }
}
