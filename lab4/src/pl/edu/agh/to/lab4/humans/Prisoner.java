package pl.edu.agh.to.lab4.humans;

import java.util.Calendar;

public class Prisoner extends AbstractHuman{
    private final int judgementYear;

    private final int sentenceDuration;

    private final String pesel;

    public Prisoner(String firstName, String surname, String pesel, int judgementYear, int sentenceDuration) {
        super(firstName, surname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean couldBeSuspicious() {
//        on freedom
        return judgementYear + sentenceDuration < getCurrentYear();
    }

    private int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
