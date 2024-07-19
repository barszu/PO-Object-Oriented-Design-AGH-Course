package rabaty;

import rabatlosowy.LosowyRabat;

public class RandomPercentageDiscountAdapter implements IPriceAfterDiscount{
    private final LosowyRabat losowyRabat;

    public RandomPercentageDiscountAdapter() {
        this.losowyRabat = new LosowyRabat();
    }

    @Override
    public double calculate(double originalPrice) {
        double discount = losowyRabat.losujRabat(); // get the discount from LosowyRabat
        return new PriceAfterPercentageDiscount((int) discount*100)
                .calculate(originalPrice); // calculate the discounted price
    }
}
