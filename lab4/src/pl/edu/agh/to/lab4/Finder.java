package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.agregators.HumanAgregator;
import pl.edu.agh.to.lab4.filters.CouldBeSuspiciousFilter;
import pl.edu.agh.to.lab4.filters.IFilter;
import pl.edu.agh.to.lab4.filters.NameFilter;
import pl.edu.agh.to.lab4.filters.util.AndMergeFilterBuilder;
import pl.edu.agh.to.lab4.humans.AbstractHuman;
import pl.edu.agh.to.lab4.humans.Person;
import pl.edu.agh.to.lab4.humans.Prisoner;
import pl.edu.agh.to.lab4.providers.PersonDataProvider;
import pl.edu.agh.to.lab4.providers.PrisonersDataProvider;
import pl.edu.agh.to.lab4.util.NestedMapValueIterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Finder {
    private final HumanAgregator humanAgregator;
    public Finder(PersonDataProvider personDataProvider, PrisonersDataProvider prisonersDataProvider) {
        this.humanAgregator = new HumanAgregator(personDataProvider, prisonersDataProvider);
    }
    public Finder(Collection<Person> allPersons, Map<String, Collection<Prisoner>> allPrisonersMappedToCity) {
        this.humanAgregator = new HumanAgregator(allPersons, allPrisonersMappedToCity);
    }

    public void displayAllSuspectsWithName(String name) {
        displayAllSuspectsWithName(name, 10);
    }

    public void displayAllSuspectsWithName(String name, int bound) {
        Collection<AbstractHuman> suspected = new ArrayList<>();

        IFilter filter = new AndMergeFilterBuilder()
                .addFilter(new NameFilter(name))
                .addFilter(new CouldBeSuspiciousFilter())
                .build();

        for (AbstractHuman human : humanAgregator) {
            if (suspected.size() >= bound) {
                break;
            }
            if (filter.filter(human)) {
                suspected.add(human);
            }
        }

        System.out.println("Znalazlem " + suspected.size() + " pasujacych podejrzanych!");
        for (AbstractHuman human : suspected){
            System.out.println(human.display());
        }

    }
}
