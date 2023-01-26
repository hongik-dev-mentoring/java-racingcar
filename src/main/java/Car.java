import java.util.Random;

public class Car {
	private String name;
	private int position = 0;
	private final int MOVE = 4;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public int createRandomNum(){
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		return random.nextInt(10);
	}

	public void race(int num){
		int positionStandard = position;//race 진행 전 postion
		for(int i = 0; i < num; i++) {
			move();
		}
		position -= positionStandard;//race 진행 후 position
	}

	public boolean move() {
		if(createRandomNum() >= MOVE){
			position++;
			return true;
		}
		return false;
	}
}
