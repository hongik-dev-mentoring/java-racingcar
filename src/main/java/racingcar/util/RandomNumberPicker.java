package racingcar.util;

import java.util.Random;

public class RandomNumberPicker {

    private final Integer minRandomNumber;
    private final Integer maxRandomNumber;

    public RandomNumberPicker(Integer min, Integer max) {
        this.minRandomNumber = min;
        this.maxRandomNumber = max;
    }

    public Integer pickRandomNumber() {
        Random random = new Random();
        int bound = maxRandomNumber + 1 - minRandomNumber;
        return random.nextInt(bound) + minRandomNumber;
    }
}
