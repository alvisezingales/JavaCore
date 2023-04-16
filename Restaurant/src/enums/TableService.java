package enums;
/**
 * This enum describes how restaurant serves dishes
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */

public enum TableService {
    BUFFET ("Buffet"),
    A_LA_CARTE ("À la carte");

    private final String description;

    TableService(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
