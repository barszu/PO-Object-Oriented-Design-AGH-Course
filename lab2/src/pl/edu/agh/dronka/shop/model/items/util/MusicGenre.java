package pl.edu.agh.dronka.shop.model.items.util;

public enum MusicGenre {
    POP("Pop"),
    RAP("Rap"),
    ROCK("Rock"),
    BALLAD("Ballada");

    private final String repr;
    MusicGenre(String repr) {
        this.repr = repr;
    }
    public String getRepr() {
        return repr;
    }

    public static MusicGenre parse(String string) {
        return switch (string) {
            case "POP" -> POP;
            case "RAP" -> RAP;
            case "BALLADA" -> BALLAD;
            case "ROCK" -> ROCK;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }
}
