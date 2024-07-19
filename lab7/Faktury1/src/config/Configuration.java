package config;

import dokumenty.printers.DetailedAbstractInvoicePrinter;
import dokumenty.printers.AbstractInvoicePrinter;
import rabaty.IPriceAfterDiscount;
import rabaty.PriceAfterPercentageDiscount;

public class Configuration {
    private static Configuration instance;
    private IPriceAfterDiscount discountCalculator;
    private AbstractInvoicePrinter abstractInvoicePrinter;

    private Configuration() {
        // Initialize the discountCalculator with a default strategy
        discountCalculator = new PriceAfterPercentageDiscount(0); // default 0% discount
        abstractInvoicePrinter = new DetailedAbstractInvoicePrinter();
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public IPriceAfterDiscount getDiscountCalculator() {
        return discountCalculator;
    }

    public void setDiscountCalculator(IPriceAfterDiscount discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public AbstractInvoicePrinter getInvoicePrinter() {
        return abstractInvoicePrinter;
    }

    public void setInvoicePrinter(AbstractInvoicePrinter abstractInvoicePrinter) {
        this.abstractInvoicePrinter = abstractInvoicePrinter;
    }
}