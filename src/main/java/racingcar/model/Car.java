package racingcar.model;

public class Car {
	private static final int MOVE_FORWARD_RANDOM_NUMBER_STANDARD = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void moveForward(int randomNumber) {
		if (shouldMove(randomNumber)) {
			this.position++;
		}
	}

	public boolean shouldMove(int randomNumber) {
		return randomNumber >= MOVE_FORWARD_RANDOM_NUMBER_STANDARD;
	}

	public boolean isWinner(int maxPosition) {
		return this.getPosition() == maxPosition;
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}
}
