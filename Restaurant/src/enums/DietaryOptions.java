package enums;
/**
 * This enum provides the type of special diets
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */

public enum DietaryOptions {
    LACTOSE_FREE("Privo di lattosio"),
    DAIRY_FREE("Privo di latte e dei suoi derivati"),
    GLUTEN_FREE("Privo di glutine"),
    NUT_FREE("Privo di frutta a guscio"),
    PEANUT_FREE("Privo di arachidi"),
    SEAFOOD_FREE("Privo di pesci, crostacei e molluschi"),
    LOCALLY_PRODUCED ("Produzione locale");

    private final String description;

    DietaryOptions(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
