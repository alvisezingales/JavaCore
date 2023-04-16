package dishes;

import enums.DietaryOptions;
import enums.Preferences;

/**
 * This class represents a general Dish
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */
public class Dish {

    private String dishName;
    private String course;
    private String ingredients;
    private Preferences dishType;
    private double dishPrice;
    private DietaryOptions dietaryOptions;

    /**
     * Dish constructor that takes the following parameters:
     * @param course         Course type
     * @param dishName       Dish name
     * @param dishType       Dish type
     * @param dishPrice      Dish price
     * @param dietaryOptions Type of special diets
     * @param ingredients    Dish ingredients
     */

    public Dish(String course, String dishName,Preferences dishType, DietaryOptions dietaryOptions, String ingredients, double dishPrice){
        this.dishPrice = dishPrice;
        this.dishName = dishName;
        this.dishType = dishType;
        this.course = course;
        this.dietaryOptions = dietaryOptions;
        this.ingredients = ingredients;
    }

    /**
     *The following methods are getters and setters for each variable
     */
    public double getDishPrice() {
        return dishPrice;
    }
    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Preferences getDishType() {
        return dishType;
    }

    public void setDishType(Preferences dishType) {
        this.dishType = dishType;
    }

    public DietaryOptions getDietaryOptions() {
        return dietaryOptions;
    }

    public void setDietaryOptions(DietaryOptions dietaryOptions) {
        this.dietaryOptions = dietaryOptions;
    }

    /**
     * This is a method that prints the details of the dish that will be overridden in the subclasses
     */
    public void printDishDetail() {
        System.out.println("### "+this.course
                          +" ###"+"\n"+this.dishName
                          +"\nIngredients: "+this.ingredients
                          +"\nDietary options: "+this.dietaryOptions
                          +"\nPrice: "+this.dishPrice+ "€");
    }
}
