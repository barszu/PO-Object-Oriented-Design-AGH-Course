package pl.edu.agh.to.lab4.agregators;

import pl.edu.agh.to.lab4.humans.AbstractHuman;
import pl.edu.agh.to.lab4.humans.Person;
import pl.edu.agh.to.lab4.humans.Prisoner;
import pl.edu.agh.to.lab4.providers.PersonDataProvider;
import pl.edu.agh.to.lab4.providers.PrisonersDataProvider;
import pl.edu.agh.to.lab4.util.NestedMapValueIterator;

import java.util.*;
import java.util.function.Consumer;

public class HumanAgregator implements Iterable<AbstractHuman>{

    private final Collection<Person> allPersons;

    private final Map<String, Collection<Prisoner>> allPrisonersMappedToCity;

    public HumanAgregator(Collection<Person> allPersons, Map<String, Collection<Prisoner>> allPrisonersMappedToCity) {
        this.allPersons = allPersons;
        this.allPrisonersMappedToCity = allPrisonersMappedToCity;
    }

    public HumanAgregator(PersonDataProvider personDataProvider, PrisonersDataProvider prisonersDataProvider) {
        this(personDataProvider.getAllCracovCitizens(), prisonersDataProvider.findAll());
    }

    @Override
    public Iterator<AbstractHuman> iterator() {
        Iterator<Person> personIterator = allPersons.iterator();
        Iterator<Prisoner> prisonerIterator = new NestedMapValueIterator<>(allPrisonersMappedToCity);
        return new Iterator<AbstractHuman>() {
            @Override
            public boolean hasNext() {
                return personIterator.hasNext() || prisonerIterator.hasNext();
            }

            @Override
            public AbstractHuman next() {
                if (personIterator.hasNext()) {
                    return personIterator.next();
                } else if (prisonerIterator.hasNext()) {
                    return prisonerIterator.next();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
