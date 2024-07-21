package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.filters.OrderFilterable;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Order> getFilteredOrders(OrderFilterable filter) {
        List<Order> filteredOrders = new ArrayList<>();
        for (Order order : orders) {
            if (filter.filter(order)) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }


}
