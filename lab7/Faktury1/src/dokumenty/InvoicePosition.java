package dokumenty;

import magazyn.Product;

public class InvoicePosition {
	private Product product;
	private double price;
	public double getPrice()
	{
		return this.price;
	}
	private double quantity;
	public double getQuantity() {
		return quantity;
	}
	private double total;
	public double getTotal() {
		return total;
	}

	// jak sie zmieni cos w pozycji to trzeba wywolac te metode
	private void setTotal() {
		this.total = this.quantity * this.price;
	}

	private final String name;
	public String getName() {
		return name;
	}

	public InvoicePosition(Product product, double quantity) {
		this.product = product;
		this.quantity = quantity;

		this.price = product.getPrice();
		this.name = product.getName();
		this.setTotal();
	}

	public void setProduct(Product product) {
		this.product = product;
		this.price = product.getPrice();
		this.setTotal();
	}



	public void setQuantity(double quantity) {
		this.quantity = quantity;
		this.setTotal();
	}


	
	public void setPrice(double price) {
		this.price = price;
		this.setTotal();
	}








}
