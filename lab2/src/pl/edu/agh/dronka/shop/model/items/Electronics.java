package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Electronics extends Item {
    private boolean isMobile;
    private boolean hasWarranty;

    public Electronics() {
        super();
    }
    public Electronics(String name, Category category, int price, int quantity, boolean isMobile, boolean hasWarranty) {
        super(name, category, price, quantity);
        this.isMobile = isMobile;
        this.hasWarranty = hasWarranty;
    }

    public boolean getIsMobile() {
        return isMobile;
    }
    public void setIsMobile(boolean value) {
        this.isMobile = value;
    }
    public boolean getHasWarranty() {
        return hasWarranty;
    }
    public void setHasWarranty(boolean value) {
        this.hasWarranty = value;
    }
}
