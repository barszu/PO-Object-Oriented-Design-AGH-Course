package dokumenty.printers;

import dokumenty.Invoice;

public abstract class AbstractInvoicePrinter {
    public final void printInvoice(Invoice invoice) {
        printHeader(invoice);
        printPositions(invoice);
        printFooter(invoice);
    }

    protected abstract void printHeader(Invoice invoice);
    protected abstract void printPositions(Invoice invoice);
    protected abstract void printFooter(Invoice invoice);
}
