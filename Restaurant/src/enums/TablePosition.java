package enums;
/**
 * This enum provides the position of the table
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */
public enum TablePosition {
    INDOOR ("Tavolo all'interno"),
    OUTDOOR("Tavolo all'esterno");

    private final String description;

    TablePosition(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
