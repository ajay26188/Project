
package project;

public class Seat {
    public int row;
    public int column;
    private boolean isAvailable;
    
    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        //this.isAvailable = isAvailable;
    }
    
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public void setColumn(int column) {
        this.column = column;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    
}
