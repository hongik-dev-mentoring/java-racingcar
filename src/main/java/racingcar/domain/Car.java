package racingcar.domain;

import racingcar.util.generator.NumberGenerator;

public class Car {
	private static final int CAN_MOVE_MIN_NUMBER = 4;
	private static final int DEFAULT_POSITION = 0;
	private final Name name;
	private final Position position;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position(DEFAULT_POSITION);
	}

	public void moveForward(NumberGenerator numberGenerator) {
		if (numberGenerator.generate() >= CAN_MOVE_MIN_NUMBER) {
			position.moveCarForward();
		}
	}

	public boolean shouldMove(int randomNumber) {
		return randomNumber >= CAN_MOVE_MIN_NUMBER;
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
