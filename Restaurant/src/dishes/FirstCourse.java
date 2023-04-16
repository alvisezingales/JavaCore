package dishes;

import enums.DietaryOptions;
import enums.Preferences;

/**
 * This class represents a first course and extends the Dish class
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */

public class FirstCourse extends Dish {

    private boolean isPastaFresca;

    /**
     * First course constructor that takes the following parameters:
     * @param course        Course type
     * @param dishName      First Course name
     * @param dishType      First Course type
     * @param price         First Course price
     * @param ingredients   Dish ingredients
     * @param isPastaFresca Boolean about pasta production
     */

    public FirstCourse(String course, String dishName, Preferences dishType, DietaryOptions dietaryOptions, double price, String ingredients, boolean isPastaFresca){
        super(course, dishName, dishType, dietaryOptions, ingredients, price);
        this.isPastaFresca = isPastaFresca;

    }
    /**
     * This is an override method from the Dish class that prints the details of the dish
     */
    @Override
    public void printDishDetail() {
        super.printDishDetail();
        System.out.println("Type of pasta: "+((isPastaFresca) ? "Pasta fresca":"Not home made pasta"));
    }

    /**
     * Getter and Setter of the instance variable
     * @return boolean isPastaFresca?
     */
    public boolean getIsPastaFresca() {
        return isPastaFresca;
    }

    public void setIsPastaFresca(boolean pastaFresca) {
        isPastaFresca = pastaFresca;
    }


}



