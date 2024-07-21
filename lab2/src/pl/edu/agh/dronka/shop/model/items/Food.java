package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.time.LocalDate;

public class Food extends Item {
    private final LocalDate expirationDate;

    public Food(String name, Category category, int price, int quantity, LocalDate expirationDate) {
        super(name, category, price, quantity);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
