package rabaty;

public class PriceAfterValueDiscount implements IPriceAfterDiscount{

        private final double valueDiscount;

        public PriceAfterValueDiscount(double valueDiscount) {
            this.valueDiscount = valueDiscount;
        }

        @Override
        public double calculate(double originalPrice) {
            return originalPrice - valueDiscount;
        }
}
