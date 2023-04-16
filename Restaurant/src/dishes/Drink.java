package dishes;

import enums.DietaryOptions;
import enums.Preferences;

/**
 * This class represents a drink and extends the Dish class
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */
public class Drink extends Dish {

    private double alcoholicVolume;
    private boolean isAlcoholic;

    /**
     * Alcoholic drink constructor that takes the following parameters:
     * @param course          Course type
     * @param drinkName       Drink name
     * @param drinkType       Drink type
     * @param drinkPrice      Drink price
     * @param isAlcoholic     Boolean about alcohol presence
     * @param alcoholicVolume Drink's alcohol content
     */
    public Drink(String course, String drinkName, Preferences drinkType, DietaryOptions dietaryOptions, String ingredients, double drinkPrice, double alcoholicVolume, boolean isAlcoholic) {
        super(course, drinkName, drinkType, dietaryOptions, ingredients, drinkPrice);
        this.alcoholicVolume = alcoholicVolume;
        this.isAlcoholic = isAlcoholic;
    }

    /**
     * Getter and Setter of each variable
     */
    public double getAlcoholicVolume() {
        return alcoholicVolume;
    }

    public void setAlcoholicVolume(double alcoholicVolume) {
        this.alcoholicVolume = alcoholicVolume;
    }

    public boolean getIsAlcoholic() {
        return isAlcoholic;
    }

    public void setIsAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    /**
     * This is an override method from the Dish class that prints the details of the drink
     */
    @Override
    public void printDishDetail() {
        System.out.println("### "+super.getCourse()
                          +" ###"+"\n"+super.getDishName()
                           +"\n"+((this.isAlcoholic) ? "\nvol % : "+this.alcoholicVolume : "Unalcoholic drink")
                           +"\nPrice: "+this.getDishPrice());
    }
}
