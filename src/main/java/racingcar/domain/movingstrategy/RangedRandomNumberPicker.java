package racingcar.domain.movingstrategy;

public class RangedRandomNumberPicker {

    private final int from;
    private final int to;

    public RangedRandomNumberPicker(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int pickRandomNumber() {
        int rangeSize = to - from + 1;
        return (int) (Math.random() * (rangeSize)) + from;
    }
}
