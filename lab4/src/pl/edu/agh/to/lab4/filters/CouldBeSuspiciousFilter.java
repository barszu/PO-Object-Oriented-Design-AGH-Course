package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.humans.AbstractHuman;

public class CouldBeSuspiciousFilter implements IFilter{
    @Override
    public boolean filter(AbstractHuman human) {
        return human.couldBeSuspicious();
    }
}
