package racingcar.domain;

import racingcar.util.RandomNum;

public class Car {
	private static final int MOVE = 4;

	private String name;
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

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	public void move() {
		if (RandomNum.createRandomNum() >= MOVE) {
			position++;
		}
	}
}
