import java.util.Random;

public class Car {
	private final int MOVE = 4;

	private String name;
	private int position = 0;
	private int winNum = 0;

	public Car(String name) {
		this.name = name;
	}

	public void setPosition(int n){
		position = n;
	}//Test용

	public void setWinNum(int n){
		winNum = n;
	}//Test용

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public int getWinNum() {
		return winNum;
	}

	public void increaseWinNum(){
		winNum++;
	}

	public int createRandomNum(){
		return (int)(Math.random()*10);
	}

	public void race(int num){
		int positionStandard = position;//race 진행 전 postion
		for(int i = 0; i < num; i++) {
			move();
		}
		position -= positionStandard;//race 진행 후 position
		Output.printRace(name,position);
	}

	public boolean move() {
		if(createRandomNum() >= MOVE){
			position++;
			return true;
		}
		return false;
	}
}
