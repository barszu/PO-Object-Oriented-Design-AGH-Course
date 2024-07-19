package dokumenty.printers;

import dokumenty.Invoice;
import dokumenty.InvoicePosition;

import java.util.Iterator;

public class DetailedAbstractInvoicePrinter extends AbstractInvoicePrinter {
    @Override
    protected void printHeader(Invoice invoice) {
        System.out.println("Company Name: " + invoice.getClientName());
        System.out.println("Date: " + invoice.getOrderDate());
    }

    @Override
    protected void printPositions(Invoice invoice) {
        Iterator<InvoicePosition> iterator = invoice.getInvoicePositionsIterator();
        while (iterator.hasNext()) {
            InvoicePosition position = iterator.next();
            System.out.println("Item: " + position.getName() + ", Quantity: " + position.getQuantity() + ", Price: " + position.getPrice());
        }
    }

    @Override
    protected void printFooter(Invoice invoice) {
        System.out.println("Total: " + invoice.getTotal());
    }
}
