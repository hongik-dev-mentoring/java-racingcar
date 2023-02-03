package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {

    private final Integer minRandomNumber;
    private final Integer maxRandomNumber;

    public RandomNumberGenerator(Integer min, Integer max) {
        this.minRandomNumber = min;
        this.maxRandomNumber = max;
    }

    public Integer generate() {
        Random random = new Random();
        int bound = maxRandomNumber + 1 - minRandomNumber;
        return random.nextInt(bound) + minRandomNumber;
    }
}
