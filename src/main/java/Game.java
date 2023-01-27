import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
	private static List<Car> cars;
	private static int tryNum;

	public Game() {
		ArrayList<String> carNames = Input.readNames();
		tryNum = Input.readNum();

		cars = createCars(carNames);
	}

	public static List<Car> createCars(ArrayList<String> carNames){
		return carNames.stream().map(Car::new).collect(Collectors.toList());
	}

	public static void play(){
		System.out.println("실행 결과\n");
		for(int i = 0 ; i < tryNum; i++){
			race(cars);
			recordWinNum(selectRoundWinner(rankRound(cars)));
		}
		//최종결과
		Output.printWinner(selectFinalWinner(rankFinal(cars)));
	}


	public static void race(List<Car> cars) {
		cars.forEach(m -> m.race(tryNum));
		System.out.println();
	}

	public static void recordWinNum(List<Car> winner) {
		winner.forEach(Car::increaseWinNum);
	}

	public static List<Car> selectRoundWinner(List<Car> carRanking) {
		int maxPosition = carRanking.get(0).getPosition();

		return carRanking.stream()
			.filter((m) -> m.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}

	public static List<Car> selectFinalWinner(List<Car> carRanking) {
		int maxWin = carRanking.get(0).getWinNum();

		return carRanking.stream()
			.filter((m) -> m.getWinNum() == maxWin)
			.collect(Collectors.toList());
	}

	public static List<Car> rankRound(List<Car> cars) {
		return cars.stream()
			.sorted(Comparator.comparing(Car::getPosition).reversed())
			.collect(Collectors.toList());
	}

	public static List<Car> rankFinal(List<Car> cars) {
		return cars.stream()
			.sorted(Comparator.comparing(Car::getWinNum).reversed())
			.collect(Collectors.toList());
	}
}