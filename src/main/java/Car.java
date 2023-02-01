import java.util.Random;

public class Car {
	private static final int MOVE = 4;
	private final int ZERO_TO_NINE_CONVERTER = 10;

	private String name;
	private int position = 0;
	private int winNum = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public int getWinNum() {
		return winNum;
	}

	public void increaseWinNum() {
		winNum++;
	}

	public int createRandomNum() {
		return (int)(Math.random() * ZERO_TO_NINE_CONVERTER);
	}

	public void race(int num) {
		int positionStandard = position;
		for (int i = 0; i < num; i++) {
			move();
		}
		position -= positionStandard;
		Output.printRace(name, position);
	}

	public boolean move() {
		if (createRandomNum() >= MOVE) {
			position++;
			return true;
		}
		return false;
	}
}
