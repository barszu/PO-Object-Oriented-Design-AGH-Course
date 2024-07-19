package dokumenty.printers;

import dokumenty.Invoice;
import dokumenty.InvoicePosition;

import java.util.Iterator;

public class SimpleAbstractInvoicePrinter extends AbstractInvoicePrinter {
    @Override
    protected void printHeader(Invoice invoice) {
        System.out.println("Total: " + invoice.getTotal());
    }

    @Override
    protected void printPositions(Invoice invoice) {
        Iterator<InvoicePosition> iterator = invoice.getInvoicePositionsIterator();
        while (iterator.hasNext()) {
            InvoicePosition position = iterator.next();
            System.out.println("Item: " + position.getName());
        }
    }

    @Override
    protected void printFooter(Invoice invoice) {
        // Do nothing
    }
}
