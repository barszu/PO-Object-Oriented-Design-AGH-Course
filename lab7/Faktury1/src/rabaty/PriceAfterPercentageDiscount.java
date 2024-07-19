package rabaty;

public class PriceAfterPercentageDiscount implements IPriceAfterDiscount{

    private final int percentageDiscount;

    public PriceAfterPercentageDiscount(int percentageDiscount) {
        if (percentageDiscount < 0 || percentageDiscount > 100) {
            throw new IllegalArgumentException("Percentage discount must be between 0 and 100");
        }
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public double calculate(double originalPrice) {
        return originalPrice * (100 - percentageDiscount) / 100;
    }
}
