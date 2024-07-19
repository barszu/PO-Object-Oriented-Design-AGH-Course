package main;

import java.util.Calendar;

import config.Configuration;
import magazyn.Category;
import magazyn.Product;

import dokumenty.Invoice;

//ZEWNETRZNY RABAT
import magazyn.Subcategory;
import rabatlosowy.LosowyRabat;


public class Ui {

	public static void main(String[] args) {
		test1();
		test2();
	}

	private static void test1(){
		Calendar calendar=Calendar.getInstance();

		//Tworzymy towary
		Product product1 = new Product(10,"buty");
		Product product2 = new Product(2,"skarpety");

		//I przykladowa fakture
		Invoice invoice=new Invoice(calendar.getTime(),"Fido");
		invoice.addInvoicePosition(product1,3);
		invoice.addInvoicePosition(product2, 5);

		//Wydrukuj fakture
		printInvoice(invoice);

		//TEST ZEWN. rabatu
//		LosowyRabat lr=new LosowyRabat();
//		System.out.println(lr.losujRabat());
	}

	private static void test2(){
		// Create some products
		Product product1 = new Product(10, "Product 1");
		Product product2 = new Product(20, "Product 2");
		Product product3 = new Product(30, "Product 3");
		Product product4 = new Product(40, "Product 4");

		// Create some categories and add products to them
		Category category1 = new Category("Category 1");
		category1.addProduct(product1);
		category1.addProduct(product2);

		Category category2 = new Category("Category 2");
		category2.addProduct(product3);
		category2.addProduct(product4);

		// Create a subcategory and add the categories to it
		Subcategory subcategory = new Subcategory("Subcategory");
		subcategory.add(category1);
		subcategory.add(category2);

		// Print the tree
		subcategory.print();
	}

	public static void printInvoice(Invoice invoice) {
		Configuration.getInstance()
				.getInvoicePrinter()
				.printInvoice(invoice);
	}

}
