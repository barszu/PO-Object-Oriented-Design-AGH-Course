package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.humans.AbstractHuman;

public class NameFilter implements IFilter{

    private final String name;
    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(AbstractHuman human) {
        return human.getFirstName().equals(name);
    }
}
