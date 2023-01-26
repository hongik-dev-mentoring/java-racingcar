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

    public List<Car> getCarList() {
        System.out.println(INPUT_CAR_NAMES);
        String input = sc.nextLine();
        validation.validateCarNameInputProcess(input);
        List<Car> carList = Arrays.stream(input.split(","))
                .map(s -> new Car(s.trim())).collect(Collectors.toList());
        return carList;
    }

    public Integer getMoveCount() {
        System.out.println(INPUT_MOVE_COUNT);
        String input = sc.nextLine();
        validation.validateMoveCountInputProcess(input);
        return Integer.parseInt(input);
    }
}
