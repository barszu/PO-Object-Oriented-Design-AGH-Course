package pl.edu.agh.to.lab4.filters.util;

import pl.edu.agh.to.lab4.filters.AndMergeFilter;
import pl.edu.agh.to.lab4.filters.IFilter;

import java.util.ArrayList;
import java.util.Collection;

public class AndMergeFilterBuilder {
    private Collection<IFilter> filters = new ArrayList<>();

    public AndMergeFilterBuilder addFilter(IFilter filter) {
        filters.add(filter);
        return this;
    }

    public AndMergeFilter build() {
        return new AndMergeFilter(filters);
    }
}
