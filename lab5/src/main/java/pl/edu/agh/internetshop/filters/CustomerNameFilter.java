package pl.edu.agh.internetshop.filters;

import pl.edu.agh.internetshop.Order;

public class CustomerNameFilter implements OrderFilterable{

    private final String customerName;

    public CustomerNameFilter(String customerName) {
        this.customerName = customerName;
    }
    @Override
    public boolean filter(Order order) {
        return order.getCustomerName().equals(customerName);
    }
}
