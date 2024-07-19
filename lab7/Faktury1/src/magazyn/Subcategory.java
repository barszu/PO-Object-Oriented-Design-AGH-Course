package magazyn;

import java.util.ArrayList;

public class Subcategory extends CategoryComponent{
    private final ArrayList<CategoryComponent> categoryComponents = new ArrayList<>();
    private final String name;

    public Subcategory(String name) {
        this.name = name;
    }

    @Override
    public void add(CategoryComponent categoryComponent) {
        categoryComponents.add(categoryComponent);
    }

    @Override
    public void remove(CategoryComponent categoryComponent) {
        categoryComponents.remove(categoryComponent);
    }

    @Override
    public CategoryComponent getChild(int i) {
        return categoryComponents.get(i);
    }

    @Override
    public void print() {
        System.out.println("\nSubcategory: " + name);
        System.out.println("---------------------");
        for (CategoryComponent categoryComponent : categoryComponents) {
            categoryComponent.print();
        }
    }
}
