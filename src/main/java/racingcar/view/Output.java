package racingcar.view;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;

public class Output {

	public static void printRace(String name, int position) {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void printWinner(List<Car> winner) {
		ArrayList<String> names = new ArrayList<>();
		winner.forEach(m -> names.add(m.getName()));

		System.out.print(String.join(",", names));
		System.out.println("가 우승했습니다.");
	}
}
