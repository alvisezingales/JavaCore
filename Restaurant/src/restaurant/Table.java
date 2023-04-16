package restaurant;

import enums.TablePosition;

/**
 * This class represents a Table
 * @author Valentina Carpentiero , Alvise Zingales , Daniele Caramanica
 */
public class Table {


    private int idTable = 0;
    private int seatsNumber;
    private TablePosition tablePosition;
    private boolean isAvailable;


    /**
     * Table constructor that takes the following parameters and assigns the true value to the boolean isAvailable:
     * @param idTable       Table ID
     * @param seatsNumber   Table's number of seats
     * @param tablePosition Position of table
     */
    public Table(int idTable, int seatsNumber, TablePosition tablePosition){
        this.idTable = idTable;
        this.seatsNumber = seatsNumber;
        this.tablePosition = tablePosition;
        this.isAvailable = true;
    }
    /**
     *The following methods are getters and setters for each instance variables
     */
    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public TablePosition getType() {
        return tablePosition;
    }

    public void setType(TablePosition tablePosition) {
        this.tablePosition = tablePosition;
    }
}

