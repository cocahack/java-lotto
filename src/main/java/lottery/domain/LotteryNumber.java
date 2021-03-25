package lottery.domain;

import java.util.Objects;

public class LotteryNumber {

    static final int MINIMUM_VALUE = 1;
    static final int MAXIMUM_VALUE = 45;

    private final int number;

    public LotteryNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int export() {
        return number;
    }

    private void validate(int number) {
        if(!checkRange(number)) {
            throw new IllegalArgumentException(
                String.format(
                    "로또 번호는 %d ~ %d 사이의 번호여야 합니다.",
                    LotteryNumber.MINIMUM_VALUE, LotteryNumber.MAXIMUM_VALUE)
            );
        }
    }

    private boolean checkRange(int number) {
        return number >= MINIMUM_VALUE && number <= MAXIMUM_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotteryNumber)) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
