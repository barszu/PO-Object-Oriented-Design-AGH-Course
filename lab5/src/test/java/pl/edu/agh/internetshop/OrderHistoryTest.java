package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.filters.CustomerNameFilter;
import pl.edu.agh.internetshop.filters.OrderFilterable;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderHistoryTest extends OrderHistoryDummyTestDataLoader {

    @Test
    void addOrder() {
        Product product4 = new Product("Product4", BigDecimal.valueOf(400));
        OrderProduct orderProduct4 = new OrderProduct(product4, BigDecimal.ZERO);
        Order order4 = new Order(Arrays.asList(orderProduct4), "Customer4");
        orderHistory.addOrder(order4);
        assertTrue(orderHistory.getOrders().contains(order4));
    }

    @Test
    void getOrders() {
        List<Order> orders = orderHistory.getOrders();
        assertTrue(orders.contains(order1));
        assertTrue(orders.contains(order2));
        assertTrue(orders.contains(order3));
    }

    @Test
    void getFilteredOrders() {
        OrderFilterable filter = new CustomerNameFilter("Customer1");
        List<Order> filteredOrders = orderHistory.getFilteredOrders(filter);
        assertFalse(filteredOrders.contains(order2));
        assertTrue(filteredOrders.contains(order1));
    }
}