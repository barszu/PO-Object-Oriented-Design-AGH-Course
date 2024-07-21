package pl.edu.agh.internetshop.filters;

import pl.edu.agh.internetshop.Order;

public interface OrderFilterable {
    public boolean filter(Order order);
}
