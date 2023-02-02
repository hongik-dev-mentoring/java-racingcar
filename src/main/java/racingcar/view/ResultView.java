package racingcar.view;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;

public class ResultView {

	public static void printCars(List<Car> cars) {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			printMove(car);
			System.out.println();
		}
		System.out.println();
	}

	private static void printMove(Car car) {
		for (int j = 0; j < car.getPosition(); j++) {
			System.out.print("-");
		}
	}

	public static void printWinner(List<Car> winner) {
		ArrayList<String> names = new ArrayList<>();
		winner.forEach(m -> names.add(m.getName()));

		System.out.print(String.join(",", names));
		System.out.println("가 우승했습니다.");
	}
}
