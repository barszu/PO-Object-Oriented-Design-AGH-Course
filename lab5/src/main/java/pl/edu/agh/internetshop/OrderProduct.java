package pl.edu.agh.internetshop;

import java.math.BigDecimal;

// wrapper class for product and quantity and discount
public class OrderProduct{
    private final Product product;
    private final BigDecimal discount;

    public OrderProduct(Product product, BigDecimal discount) {
        this.product = product;
        this.discount = discount;
    }
    public Product getProduct() {
        return product;
    }
    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getPriceWithoutDiscount() {
        return product.getPrice();
    }

    public BigDecimal getPrice() {
        return getPriceWithoutDiscount().multiply(BigDecimal.ONE.subtract(discount));
    }

    public BigDecimal getPriceWithTaxes(BigDecimal taxValue) {
        return getPrice().multiply(taxValue).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

}
