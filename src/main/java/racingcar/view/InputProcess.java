package racingcar.view;

import racingcar.domain.CarList;
import racingcar.domain.MoveCount;

import java.util.Scanner;

public class InputProcess {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).";
    private static final String INPUT_MOVE_COUNT = "시도할 회수는 몇회인가요?";

    private final Scanner sc = new Scanner(System.in);
    private CarList carList;
    private MoveCount moveCount;

    public CarList getCarList() {
        try {
            System.out.println(INPUT_CAR_NAMES);
            String input = sc.nextLine();
            carList = new CarList(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getCarList();
        }
        return carList;
    }

    public MoveCount getMoveCount() {
        try {
            System.out.println(INPUT_MOVE_COUNT);
            String input = sc.nextLine();
            moveCount = new MoveCount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getMoveCount();
        }
        return moveCount;
    }
}
