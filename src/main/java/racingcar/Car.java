package racingcar;

import java.util.Random;

public class Car {
    private final String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    private int pickRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(10);
    }

    public void move() {
        if (pickRandomNumber() >= 4) {
            this.position++;
        }
    }

    public void printPosition() {
        StringBuilder sb = new StringBuilder(name);
        sb.append(" : ");
        String step = "-";
        sb.append(step.repeat(position));
        System.out.println(sb);
    }

    public Integer getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
