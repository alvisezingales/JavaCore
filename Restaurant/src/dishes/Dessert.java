package dishes;

import enums.DietaryOptions;
import enums.Preferences;

/**
 * This class represents a Dessert and extends the Dish class
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */
public class Dessert extends Dish {

    private boolean isHomeMade;

    /**
     * Dessert constructor that takes the following parameters:
     * @param course         Course type
     * @param dishName       Dessert name
     * @param dishType       Dessert type
     * @param dietaryOptions Type of special diets
     * @param price          Dessert price
     * @param isHomeMade     Type of Dessert's production
     */

    public Dessert(String course, String dishName, Preferences dishType, DietaryOptions dietaryOptions, double price, String ingredients, boolean isHomeMade) {
        super(course, dishName,dishType,dietaryOptions,ingredients, price);
        this.isHomeMade = isHomeMade;
    }

    /**
     * This is an override method from the Dish class that prints the details of the dessert
     */
    @Override
    public void printDishDetail() {
        super.printDishDetail();
        System.out.println(this.isHomeMade ? "Home made" : "Not home made product");
    }

    /**
     * Getter and Setter of the variable
     */

    public boolean isHomeMade() {
        return isHomeMade;
    }

    public void setHomeMade(boolean homeMade) {
        isHomeMade = homeMade;
    }
}
