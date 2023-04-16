package enums;
/**
 * This enum is used as a common element for the Customer preferences and the Menu and Dish type
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */
public enum Preferences {


    CARNIVOROUS ("Carnivoro"),
    VEGETARIAN("Vegetariano"),
    VEGAN("Vegano"),
    MIXED("Senza preferenze specifiche");

    private final String description;

    Preferences(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
