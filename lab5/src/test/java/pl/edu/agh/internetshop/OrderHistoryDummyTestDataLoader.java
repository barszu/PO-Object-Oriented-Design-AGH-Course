package pl.edu.agh.internetshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderHistoryDummyTestDataLoader {
    protected OrderHistory orderHistory;
    protected Order order1;
    protected Order order2;
    protected Order order3;
    protected Order order4;
    protected Product product1;
    protected Product product2;
    protected Product product3;
    protected OrderProduct orderProduct1;
    protected OrderProduct orderProduct2;
    protected OrderProduct orderProduct3;

    @BeforeEach
    void setUp() {
        orderHistory = new OrderHistory();

        product1 = new Product("Product1", BigDecimal.valueOf(100));
        product2 = new Product("Product2", BigDecimal.valueOf(200));
        product3 = new Product("Product3", BigDecimal.valueOf(300));

        orderProduct1 = new OrderProduct(product1, new BigDecimal("0.1"));
        orderProduct2 = new OrderProduct(product2, BigDecimal.ZERO);
        orderProduct3 = new OrderProduct(product3, new BigDecimal("1"));


        order1 = new Order(Arrays.asList(orderProduct1, orderProduct2), "Customer1");
        order2 = new Order(Arrays.asList(orderProduct2, orderProduct3), "Customer2");
        order3 = new Order(Arrays.asList(orderProduct1, orderProduct3), "Customer3");
        order4 = new Order(Arrays.asList(orderProduct1, orderProduct2, orderProduct3), "Customer4");

        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);
        orderHistory.addOrder(order3);
        orderHistory.addOrder(order4);
    }

    @Test
    void isContainOrder() {
        assertTrue(orderHistory.getOrders().contains(order1));
        assertTrue(orderHistory.getOrders().contains(order2));
        assertTrue(orderHistory.getOrders().contains(order3));
        assertTrue(orderHistory.getOrders().contains(order4));
    }

    @Test
    void isContainOrderProduct() {
        assertTrue(order1.getOrderProducts().contains(orderProduct1));
        assertTrue(order1.getOrderProducts().contains(orderProduct2));
        assertTrue(order2.getOrderProducts().contains(orderProduct2));
        assertTrue(order2.getOrderProducts().contains(orderProduct3));
        assertTrue(order3.getOrderProducts().contains(orderProduct1));
        assertTrue(order3.getOrderProducts().contains(orderProduct3));
        assertTrue(order4.getOrderProducts().contains(orderProduct1));
        assertTrue(order4.getOrderProducts().contains(orderProduct2));
        assertTrue(order4.getOrderProducts().contains(orderProduct3));
    }


}
