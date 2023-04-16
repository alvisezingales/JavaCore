package dishes;

import enums.DietaryOptions;
import enums.Preferences;

/**
 * This class represents a second course and extends the Dish class
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */
public class SecondCourse extends Dish {

    private String sideDish;

    /**
     * Second course constructor that takes the following parameters:
     * @param course    Course type
     * @param dishName  Second course name
     * @param dishType  Second course type
     * @param price     Second course price
     * @param sideDish  Second's side dish
     */

    public SecondCourse(String course, String dishName, Preferences dishType, DietaryOptions dietaryOptions, double price, String ingredients, String sideDish) {
        super(course, dishName, dishType, dietaryOptions, ingredients, price);
        this.sideDish = sideDish;
    }

    /**
     * This is an override method from the Dish class that prints the details of the dish
     */
    @Override
    public void printDishDetail() {
        super.printDishDetail();
        System.out.println("Side dish: " +this.sideDish);
    }
    /**
     * Getter and Setter of the variable
     */
    public String getSideDish() {
        return sideDish;
    }

    public void setSideDish(String sideDish) {
        this.sideDish = sideDish;
    }
}
