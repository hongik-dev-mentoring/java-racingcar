package racingcar.domain;

public class Car {
	private static final int MOVE_FORWARD_RANDOM_NUMBER_STANDARD = 4;
	private static final int DEFAULT_POSITION = 0;
	private final Name name;
	private final Position position;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position(DEFAULT_POSITION);
	}

	public void moveForward(int randomNumber) {
		if (shouldMove(randomNumber)) {
			position.moveCarForward();
		}
	}

	public boolean shouldMove(int randomNumber) {
		return randomNumber >= MOVE_FORWARD_RANDOM_NUMBER_STANDARD;
	}

	public boolean isWinner(int maxPosition) {
		return position.getValue() == maxPosition;
	}

	public Name getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}
}
