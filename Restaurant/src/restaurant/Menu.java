package restaurant;

import dishes.Dish;
import enums.BasedOn;
import enums.Preferences;
import enums.TypeOfMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Restaurant menu
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */
public class Menu {

    private Preferences menuPreferences;
    private BasedOn basedOn;
    private TypeOfMenu menuType;
    private List<Dish> dishList;

    /**
     *
     * @param menuPreferences Type of special diets
     * @param menuType        Type of menu
     * @param basedOn         Menu base
     */
    public Menu(Preferences menuPreferences, TypeOfMenu menuType, BasedOn basedOn, List<Dish> dishList) {
        this.menuPreferences = menuPreferences;
        this.menuType = menuType;
        this.basedOn = basedOn;
        this.dishList = dishList;
    }

    /**
     *The following methods are getters and setters for each instance variables
     */

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public TypeOfMenu getMenuType() {
        return menuType;
    }

    public void setMenuType(TypeOfMenu menuType) {
        this.menuType = menuType;
    }

    public Preferences getMenuPreferences() {
        return menuPreferences;
    }

    public void setMenuPreferences(Preferences menuPreferences) {
        this.menuPreferences = menuPreferences;
    }

    public BasedOn getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(BasedOn basedOn) {
        this.basedOn = basedOn;
    }

    /**
     * This method prints all menu's details and each dish
     */

    public void printMenu(){
        System.out.println(this.menuType
                           +"\n"+ this.menuType.getDescription()
                           +"\nMenu based on "+this.basedOn.toString().toLowerCase()
                           +"\nDietary options: "+this.menuPreferences.toString().toLowerCase()+"\n"
                           );
        for (Dish dish : dishList) {
            dish.printDishDetail();
            System.out.println();
        }
    }
}
