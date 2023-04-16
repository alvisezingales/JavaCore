package enums;
/**
 * This enum describes the base of the menu
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */

public enum BasedOn {
    FISH ("Menu di pesce"),
    MEAT("Menu di carne"),
    VEGETABLES("Menu di verdure");

    private final String description;

    BasedOn(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
