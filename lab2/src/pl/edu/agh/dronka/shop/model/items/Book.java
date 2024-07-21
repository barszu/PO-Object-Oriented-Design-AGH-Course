package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Book extends Item {
    private final int pagesNo;
    private boolean hasHardCover;

    public Book() {
        super();
        this.pagesNo = 0;
        this.hasHardCover = false;
    }
    public Book(String name, Category category, int price, int quantity, int pagesNo, boolean hasHardCover) {
        super(name, category, price, quantity);
        this.pagesNo = pagesNo;
        this.hasHardCover = hasHardCover;
    }

    public int getPagesNo() {
        return pagesNo;
    }

    public boolean getHasHardcover() {
        return hasHardCover;
    }
    public void setHardCover(boolean value) {
        this.hasHardCover = value;
    }
}
