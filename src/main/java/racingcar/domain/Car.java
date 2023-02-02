package racingcar.domain;

import racingcar.util.RandomNum;

public class Car {
	private static final int MOVE = 4;

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

	public void race(int num) {
		int positionStandard = position;
		for (int i = 0; i < num; i++) {
			move(RandomNum.createRandomNum());
		}
		position -= positionStandard;
	}

	public boolean move(int randomNum) {
		if (randomNum >= MOVE) {
			position++;
			return true;
		}
		return false;
	}
}
