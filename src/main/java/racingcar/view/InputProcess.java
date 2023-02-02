package racingcar.view;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputProcess {

    private static final String COMMA_DELIMITER = ",";
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).";
    private static final String INPUT_MOVE_COUNT = "시도할 회수는 몇회인가요?";

    private final Validation validation = new Validation();
    private final Scanner sc = new Scanner(System.in);
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
        carList = Arrays.stream(input.split(COMMA_DELIMITER))
                .map(carName -> new Car(carName.trim())).collect(Collectors.toList());
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
