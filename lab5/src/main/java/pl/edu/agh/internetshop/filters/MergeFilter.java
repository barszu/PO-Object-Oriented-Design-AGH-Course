package pl.edu.agh.internetshop.filters;

import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.OrderHistory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MergeFilter implements OrderFilterable{
    private final List<OrderFilterable> filters = new ArrayList<>();

    public MergeFilter(Collection<OrderFilterable> filters) {
        this.filters.addAll(filters);
    }

    public MergeFilter addFilter(OrderFilterable filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean filter(Order order) {
        for (OrderFilterable filter : filters) {
            if (!filter.filter(order)) {
                return false;
            }
        }
        return true;
    }
}
