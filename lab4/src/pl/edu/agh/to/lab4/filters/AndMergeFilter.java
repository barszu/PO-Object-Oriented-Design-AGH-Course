package pl.edu.agh.to.lab4.filters;

import pl.edu.agh.to.lab4.humans.AbstractHuman;

import java.util.Collection;

public class AndMergeFilter implements IFilter{

    private final Collection<IFilter> filters;

    public AndMergeFilter(Collection<IFilter> filters) {
        this.filters = filters;
    }

    @Override
    public boolean filter(AbstractHuman human) {
        for (IFilter filter : filters) {
            if (!filter.filter(human)) {
                return false;
            }
        }
        return true;
    }
}
