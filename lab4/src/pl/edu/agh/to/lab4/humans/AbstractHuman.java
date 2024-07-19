package pl.edu.agh.to.lab4.humans;

public abstract class AbstractHuman {
//    abstract class bo zbiera elementy takie same z person i prisoner
//    dalem abstact dlatego ze jesli bedzie potrzeba w przyszlosci dodania nowej metody ktora bedzie implementowana w klasach dziedziczacych
//    to bedzie mozna to zrobic, abstract class laczy funkcjonalnosc interfejsu i zwyklej klasy, pozwala odrazu na implementacje

//    np. couldBeSuspicious() jest metoda ktora bedzie implementowana przez klasy dziedziczace
    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    private final String firstName;

    public AbstractHuman(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    private final String surname;

    public String display() {
        return getFirstName() + " " + getSurname();
    }

    public abstract boolean couldBeSuspicious();

}
