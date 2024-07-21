package pl.edu.agh.internetshop.filters;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class OrderPriceIntervalFilter implements OrderFilterable{
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;

    public OrderPriceIntervalFilter(BigDecimal minPrice, BigDecimal maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean filter(Order order) {
        BigDecimal price = order.getAllProductsPrice();
        return price.compareTo(minPrice) >= 0 && price.compareTo(maxPrice) <= 0;
    }
}
