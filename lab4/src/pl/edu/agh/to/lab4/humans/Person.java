package pl.edu.agh.to.lab4.humans;

public class Person extends AbstractHuman{
    private final int age;

    public Person(String firstname, String surname, int age) {
        super(firstname, surname);
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    @Override
    public boolean couldBeSuspicious() {
        return age > 18;
    }
}
