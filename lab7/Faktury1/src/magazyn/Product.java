package magazyn;

public class Product {
	private double price;
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return price;
	}

	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Product(double price, String name)
	{
		this.price = price;
		this.name = name;
	}
	
	//methods:


}
