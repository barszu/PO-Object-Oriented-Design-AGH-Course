package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23);
	private final UUID id;
    private final List<OrderProduct> orderProducts = new ArrayList<>();
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private String customerName = "";

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    @Deprecated
    public Order(Product product) {
        this.orderProducts.add(new OrderProduct(product, BigDecimal.ZERO));
        id = UUID.randomUUID();
        paid = false;
    }

    @Deprecated
    public Order(List<Product> products) {
        for (Product product : products) {
            this.orderProducts.add(new OrderProduct( product, BigDecimal.ZERO));
        }
        id = UUID.randomUUID();
        paid = false;
    }

    public Order(Collection<OrderProduct> orderProducts , String customerName) {
        this.orderProducts.addAll(orderProducts);
        id = UUID.randomUUID();
        paid = false;
        this.customerName = customerName;
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Shipment getShipment() {
        return shipment;
    }

    //    all products
    public BigDecimal getAllProductsPrice() {
        return orderProducts.stream()
                .map(OrderProduct::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getAllProductPriceWithTaxes() {
        return getAllProductsPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    //    single product
    public BigDecimal getProductPrice(int productID){
        return orderProducts.get(productID).getPrice();
    }

    public BigDecimal getProductPriceWithTaxes(int productID){
        return getProductPrice(productID).multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    public List<Product> getProductsList() {
        return orderProducts.stream().map(OrderProduct::getProduct).collect(Collectors.toList());
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
