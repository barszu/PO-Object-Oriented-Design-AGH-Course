package magazyn;

import java.util.ArrayList;

public class Category extends CategoryComponent{
    private final ArrayList<Product> products = new ArrayList<>();
    private final String name;

    public Category(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void print() {
        System.out.println("\nCategory: " + name);
        System.out.println("---------------------");
        for (Product product : products) {
            System.out.println("Product: " + product.getName());
        }
    }
}
