package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.filters.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FiltersTest extends OrderHistoryDummyTestDataLoader {
    @Test
    void customerNameFilterTest() {
        // given
        OrderFilterable filter = new CustomerNameFilter("Customer1");

        // when
        List<Order> filteredOrders = orderHistory.getFilteredOrders(filter);

        // then
        assertFalse(filteredOrders.contains(order2));
        assertTrue(filteredOrders.contains(order1));
    }

    @Test
    void productNamesFilterTest() {
        // given
        OrderFilterable filter = new ProductNameFilter("Product1");

        // when
        List<Order> filteredOrders = orderHistory.getFilteredOrders(filter);

        // then
        assertTrue(filteredOrders.contains(order1));
        assertTrue(filteredOrders.contains(order3));
        assertTrue(filteredOrders.contains(order4));
        assertFalse(filteredOrders.contains(order2));
    }

    @Test
    void productPriceFilterTest() {
        // given
        OrderFilterable filter = new OrderPriceIntervalFilter(new BigDecimal(100), new BigDecimal(200));

        // when
        List<Order> filteredOrders = orderHistory.getFilteredOrders(filter);

        // then
        assertFalse(filteredOrders.contains(order1));
        assertTrue(filteredOrders.contains(order2));
        assertFalse(filteredOrders.contains(order3));
        assertFalse(filteredOrders.contains(order4));
    }

    @Test
    void productPriceFilterTest2() {
        // given
        OrderFilterable filter = new OrderPriceIntervalFilter(new BigDecimal(0), new BigDecimal(100));

        // when
        List<Order> filteredOrders = orderHistory.getFilteredOrders(filter);

        // then
        assertFalse(filteredOrders.contains(order1));
        assertFalse(filteredOrders.contains(order2));
        assertTrue(filteredOrders.contains(order3));
        assertFalse(filteredOrders.contains(order4));
    }

    @Test
    void mergeFiltersTest() {
        // given
        OrderFilterable filter1 = new ProductNameFilter("Product1");
        OrderFilterable filter2 = new OrderPriceIntervalFilter(new BigDecimal(100), new BigDecimal(200));

        List<OrderFilterable> filters = new ArrayList<>();
        filters.add(filter1);
        filters.add(filter2);

        OrderFilterable mergedFilter = new MergeFilter(filters);
        // when
        List<Order> filteredOrders = orderHistory.getFilteredOrders(mergedFilter);

        // then
        assertFalse(filteredOrders.contains(order2));
        assertFalse(filteredOrders.contains(order1));
        assertFalse(filteredOrders.contains(order3));
        assertFalse(filteredOrders.contains(order4));
    }
}
