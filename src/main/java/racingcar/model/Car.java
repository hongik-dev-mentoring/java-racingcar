package racingcar.model;

import racingcar.util.validator.NameValidator;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
		NameValidator.validateCarName(name);
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
		return randomNumber >= 4;
	}

	public boolean isWinner(int maxPosition) {
		if (this.getPosition() == maxPosition) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}
}
