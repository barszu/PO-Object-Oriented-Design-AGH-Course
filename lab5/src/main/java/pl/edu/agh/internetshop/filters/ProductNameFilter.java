package pl.edu.agh.internetshop.filters;

import pl.edu.agh.internetshop.Order;

public class ProductNameFilter implements OrderFilterable{
    private final String productName;

    public ProductNameFilter(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean filter(Order order) {
        return order.getProductsList().stream().anyMatch(product -> product.getName().equals(productName));
    }
}
