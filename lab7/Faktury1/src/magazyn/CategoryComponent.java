package magazyn;

public abstract class CategoryComponent {
    public void add(CategoryComponent categoryComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(CategoryComponent categoryComponent) {
        throw new UnsupportedOperationException();
    }

    public CategoryComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void print();
}
