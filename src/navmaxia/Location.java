
package navmaxia;

/**
 *
 * @author Tsok
 */
public class Location {
    private int row, col;
    private Ship ship;
    private boolean marked;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Ship getShip() {
        return ship;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    public void mark(){
        
        marked = true;
        
        if (ship != null){
            
            ship.hit();
            
            
        }
    }
    
    public boolean isEmpty(){
        return ship == null;
    } 
    
    public boolean isHit(){
        if (ship != null && marked == true)return true;
        else return false;
    }
    
    public String toString(){
        if (marked == false) return ".  ";
        else if (marked == true  && ship == null) return "o  ";
        else if (marked == true  && ship.isSinking() == false) return "x  ";
        else if (marked == true  && ship.isSinking()) return "x" + ship.getLetter() + " ";
        else return "Err";
    }
    
    public String toStringWithShips(){
        if      (marked == false && ship == null) return ".  ";
        else if (marked == true  && ship == null) return "o  ";
        else if (marked == true  && ship != null) return "x" + ship.getLetter() + " ";
        else if (marked == false && ship != null) return ship.getLetter() + "  ";
        else return "Err";
    }
}
