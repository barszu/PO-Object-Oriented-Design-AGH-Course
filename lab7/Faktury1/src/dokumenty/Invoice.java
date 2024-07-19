package dokumenty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import config.Configuration;
import magazyn.Product;
import rabaty.IPriceAfterDiscount;


public class Invoice { //faktura
	private final Date orderDate;
	public Date getOrderDate()
	{
		return orderDate;
	}
	private final String clientName;
	public String getClientName()
	{
		return this.clientName;
	}
	private final ArrayList<InvoicePosition> invoicePositions = new ArrayList<InvoicePosition>();
	private double total = 0;
	public double getTotal()
	{
		return total;
	}
	private void setTotal() { //jak sie zmieni cos na fakturze to trzeba wywolac te metode
		Iterator<InvoicePosition> iterator= invoicePositions.iterator();
		InvoicePosition invoicePosition;
		total = 0;
		while(iterator.hasNext())
		{
			invoicePosition = iterator.next();
			total += invoicePosition.getTotal();
		}
	}

	public Invoice(Date orderDate, String clientName) {
		this.orderDate = orderDate;
		this.clientName = clientName;
	}

	// methods:

	public void addInvoicePosition(Product product, double quantity) {
		InvoicePosition invoicePosition = new InvoicePosition(product, quantity);
		double originalPrice = invoicePosition.getPrice();
		double discountedPrice = Configuration
				.getInstance()
				.getDiscountCalculator()
				.calculate(originalPrice); // calculate the discounted price
		invoicePosition.setPrice(discountedPrice); // set the discounted price
		invoicePositions.add(invoicePosition);
		this.setTotal();
	}


	public void addInvoicePosition(Product product, double quantity, IPriceAfterDiscount priceAfterDiscount) {
		InvoicePosition invoicePosition = new InvoicePosition(product, quantity);
		double originalPrice = invoicePosition.getPrice();
		double discountedPrice = priceAfterDiscount.calculate(originalPrice); // calculate the discounted price
		invoicePosition.setPrice(discountedPrice); // set the discounted price
		invoicePositions.add(invoicePosition);
		this.setTotal();
	}




	public Iterator<InvoicePosition> getInvoicePositionsIterator()
	{
		return invoicePositions.iterator();
	}

	@Deprecated
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();

		res.append("=====================================================\n");
		res.append("FA z dnia: ").append(this.getOrderDate().toString()).append("\n");
		res.append("Wystawiona dla: ").append(this.getClientName()).append("\n");
		res.append("Na kwote: ").append(this.getTotal()).append("\n");
		Iterator<InvoicePosition> iteratorPozycji= this.getInvoicePositionsIterator();
		while(iteratorPozycji.hasNext())
		{
			InvoicePosition invoicePosition = iteratorPozycji.next();
			res.append("Towar: ").append(invoicePosition.getName()).append(" Ilosc: ").append(invoicePosition.getQuantity()).append(" Wartosc:").append(invoicePosition.getTotal()).append("\n");
		}
		res.append("=====================================================");
		res.append("\n");

		return res.toString();
	}
	
	
}
